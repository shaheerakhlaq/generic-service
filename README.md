# Generic Service Implementation in Java with Spring Boot and JPA
## Introduction
In modern enterprise applications, designing a reusable and well-structured service layer is crucial. A generic service layer ensures consistency, reduces redundancy, and improves maintainability. This article provides a comprehensive guide on implementing a generic service layer in Java using Spring Boot and Spring Data JPA, covering CRUD operations, caching, soft deletion, dynamic search, and DTO mapping.

## 1. Defining the Generic Service Interface
A generic service interface abstracts common CRUD operations, promoting a uniform contract across various service implementations.

```
public interface GenericService<E extends BaseEntity, ID> {
    void insert(E entity) throws SWException;
    void update(E entity) throws SWException;
    void delete(ID id) throws SWException;
    E findByEntityId(ID id) throws SWException;
    Page<E> findAll(SearchCriteriaRequestDTO requestDto) throws SWException;
    Page<E> findAll(SearchCriteriaRequestDTO requestDto, Specification<E> specification) throws SWException;
}
```

### Key Benefits
Code Reusability: Eliminates duplicate CRUD logic.
Maintainability: Centralized implementation simplifies updates.
Consistency: Enforces uniform method signatures across services.

## 2. Implementing the Generic Service
The GenericServiceImpl class provides a reusable implementation of CRUD operations using Spring Data JPA's JpaRepository.

```
@Getter
@Transactional
public abstract class GenericServiceImpl<E extends BaseEntity, ID> implements GenericService<E, ID> {
    @Autowired
    private JpaRepository<E, ID> jpaRepository;

    public void insert(E entity) throws SWException {
        validateEntity(entity);
        jpaRepository.save(entity);
    }
    public void update(E entity) throws SWException {
        validateEntity(entity);
        jpaRepository.save(entity);
    }
    public void delete(ID id) throws SWException {
        E entity = findByEntityId(id);
        jpaRepository.save(entity); // Soft delete
    }
    @Cacheable(value = "find", key = "#id", condition = "#id != null")
    public E findByEntityId(ID id) throws SWException {
        return jpaRepository.findById(id)
            .orElseThrow(() -> new ResultNotFoundException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND));
    }
    public Page<E> findAll(SearchCriteriaRequestDTO requestDto) throws SWException {
        Pageable pageable = validateSearchCriteria(requestDto);
        Page<E> pages = jpaRepository.findAll(pageable);
        if (pages.isEmpty()) {
            throw new SWException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND);
        }
        return pages;
    }
    protected void validateEntity(E entity) throws SWException {
        if (entity.getId() != null) {
            throw new SWException(SWStatusConstants.Status.CODE_INVALID_INPUT, "New entity should not have an ID");
        }
        if (entity.getStatus() == null) {
            throw new SWException(SWStatusConstants.Status.CODE_INVALID_INPUT, "Entity status cannot be null");
        }
    }
}
```

### Key Features
JpaRepository Integration: Uses JpaRepository for database interactions.
Caching: Uses @Cacheable for efficient entity retrieval.
Soft Deletion: Implements soft deletion by modifying the entity status.
Pagination: Supports paginated data retrieval.
Custom Validation: Ensures data integrity with validateEntity().

## 3. Enhancing Search Capabilities with GenericSearchServiceImpl
To enable dynamic filtering and DTO transformation, we introduce GenericSearchServiceImpl.

```
@Getter
@Transactional
public abstract class GenericSearchServiceImpl<E extends BaseEntity, ID> extends GenericServiceImpl<E, ID> {
    private final Class<E> entityClass;
    
    @Autowired
    private MapperFactory mapperFactory;

    protected GenericSearchServiceImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    public <E, R> SearchResultResponseDTO<R> getSearchResult(Page<E> pages, Class<E> entityType) throws SWException {
        if (pages.isEmpty()) {
            throw new ResultNotFoundException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND);
        }
        GenericMapper<E, R> mapper = mapperFactory.getMapper(entityType);
        List<R> mappedContent = pages.getContent().stream().map(mapper::find).collect(Collectors.toList());
        return new SearchResultResponseDTO<>(pages.getTotalPages(), pages.getTotalElements(), mappedContent);
    }
}
```

Key Features
Dynamic Filtering: Supports flexible search criteria.
DTO Transformation: Maps entities to DTOs via MapperFactory.
Generic Implementation: Works for different entity types.


## 4. Implementing a Domain-Specific Service (UserServiceImpl)
The UserServiceImpl class extends GenericSearchServiceImpl, leveraging generic CRUD and search functionalities.

```
@Service
public class UserServiceImpl extends GenericSearchServiceImpl<User, Long> {
    public UserServiceImpl() {
        super(User.class);
    }

    @Transactional
    public void addUser(AddUserRequestDTO requestDto) throws SWException {
        User userEntity = getUserMapper().add(requestDto);

        getUserRepository().save(userEntity);

        UserCredential userCredentialEntity = getUserMapper().addUserCredential(requestDto, userEntity);

        getUserCredentialRepository().save(userCredentialEntity);
    }

  public SearchResultResponseDTO<UserDTO> find(SearchCriteriaRequestDTO requestDto) throws SWException {
        Page<User> pages;
        if (requestDto.getSearchCriteria().isEmpty()) {
            pages = findAll(requestDto);
        } else {
            Specification<User> specification = new GenericSpecification<>(requestDto.getSearchCriteria());
            Pageable pageable = validateSearchCriteria(requestDto);
            pages = getUserRepository().findAll(specification, pageable);
        }
        return getSearchResult(pages, User.class);
    }
}
```

## 5. Implementing DTO Mapping with GenericMapper and MapperFactory
### GenericMapper Interface

```
public interface GenericMapper<E, M> {
    M find(E entity) throws SWException;
    Class<E> getEntityType();
}
```

### Concrete Mapper: UserMapper

```
@Component
public class UserMapper implements GenericMapper<User, UserDTO> {
    public UserDTO find(User entity) throws SWException {
        if (entity == null) throw new SWException("User entity cannot be null");
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getStatus());
    }

public Class<User> getEntityType() {
        return User.class;
    }
}
```

### MapperFactory

```
@Getter
@Component
public class MapperFactory {
    private final Map<Class<?>, GenericMapper<?, ?>> mapperMap = new HashMap<>();

@Autowired
    private ApplicationContext applicationContext;
    @PostConstruct
    public void init() {
        applicationContext.getBeansOfType(GenericMapper.class)
            .forEach((name, mapper) -> mapperMap.put(mapper.getEntityType(), mapper));
    }
    public <E, R> GenericMapper<E, R> getMapper(Class<E> type) throws SWException {
        if (!mapperMap.containsKey(type)) {
            throw new SWException("Mapper not found for type: " + type.getName());
        }
        return (GenericMapper<E, R>) mapperMap.get(type);
    }
}

```

## 6. Implementing UserController

```
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @PostMapping("/add")
    public BaseResponseDTO add(@RequestBody AddUserRequestDTO requestDto) throws SWException {
        getUserService().addUser(requestDto);
        return response();
    }

@GetMapping("/find/{userId}")
    public BaseResponseDTO<UserResponseDTO> find(@PathVariable Long userId) throws SWException {
        User entity = getUserService().findByEntityId(userId);
        return response(getUserMapper().find(entity));
    }
    @PostMapping("/find")
    public BaseResponseDTO<SearchResultResponseDTO> find(@RequestBody SearchCriteriaRequestDTO requestDto) throws SWException {
        return response(getUserService().find(requestDto));
    }
}
```

## Conclusion
By implementing a generic service layer, we achieve:
Code Reusability: Centralized business logic.
Maintainability: Simplified service extension.
Scalability: Generic filtering and DTO mapping.

> This approach ensures a clean, scalable, and consistent service layer in Spring Boot applications.
