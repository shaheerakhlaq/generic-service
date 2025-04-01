package com.shr.food.place.persistence.configuration;

import com.shr.food.place.base.util.SWConstants;
import com.shr.food.place.base.util.SWUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
//@EnableJpaRepositories
@EnableTransactionManagement
@Configuration
public class BaseJpaConfiguration {
    private final String[] entityPackageName = new String[]{"com.shr.food.place.*"};

    @Autowired
    private Environment environment;

    /**
     * Create database source
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        try {
            // Extracting property values for better readability and maintainability
            String jdbcDriver = environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_DRIVER_CLASS_NAME);
            String jdbcUrl = environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_URL);
            String jdbcUsername = environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_USERNAME);
            String jdbcPassword = environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_PASSWORD);
            //String poolName = environment.getRequiredProperty(SWConstants.ApplicationYaml.POOL_NAME);
            String connectionTestQuery = environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_CONNECTION_TEST_QUERY);

            int minIdle = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_MIN_IDLE)).get();
            int maxPoolSize = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_MAX_POOL_SIZE)).get();
            int connectionTimeout = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_CONNECTION_TIMEOUT)).get();
            int leakDetectionThreshold = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_LEAK_DETECTION_THRESHOLD)).get();
            int idleTimeout = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_IDLE_TIMEOUT)).get();
            int maxLifetime = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_MAX_LIFETIME)).get();
            //int validationTimeout = SWUtil.stringToInteger(environment.getRequiredProperty(SWConstants.ApplicationYaml.JDBC_VALIDATION_TIMEOUT));

            // Set HikariCP properties
            hikariConfig.setDriverClassName(jdbcDriver);
            hikariConfig.setJdbcUrl(jdbcUrl);
            hikariConfig.setUsername(jdbcUsername);
            hikariConfig.setPassword(jdbcPassword);
            hikariConfig.setMinimumIdle(minIdle);
            hikariConfig.setMaximumPoolSize(maxPoolSize);
            hikariConfig.setConnectionTimeout(connectionTimeout);
            hikariConfig.setLeakDetectionThreshold(leakDetectionThreshold);
            hikariConfig.setIdleTimeout(idleTimeout);
            hikariConfig.setMaxLifetime(maxLifetime);
            //hikariConfig.setValidationTimeout(validationTimeout);
            hikariConfig.setConnectionTestQuery(connectionTestQuery);
            //hikariConfig.setPoolName(poolName);
            hikariConfig.setRegisterMbeans(false);  // Enables JMX registration

            // Set additional data source properties
            hikariConfig.addDataSourceProperty("testOnBorrow", "true");
            hikariConfig.addDataSourceProperty("validationQuery", "SELECT 1");
        } catch (IllegalArgumentException ex) {
            log.error("Error configuring HikariCP: Required properties are missing or invalid", ex);
            throw ex;  // Re-throw after logging to stop misconfigured pool
        } catch (Exception ex) {
            log.error("Unexpected error during HikariCP configuration", ex);
            throw new RuntimeException("Failed to configure HikariCP", ex);  // Generic fallback error
        }

        return new HikariDataSource(hikariConfig);
    }

    /**
     * Interface used to interact with the entity manager factory for the persistence
     *
     * @return EntityManagerFactory
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);
        vendorAdapter.setDatabasePlatform(environment.getProperty(SWConstants.ApplicationYaml.DATABASE_PLATFORM));

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(this.entityPackageName);
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        factory.setJpaProperties(jpaProperties());

        return factory.getObject();
    }

    /**
     * Transaction manager implementations. Commit and rollback
     *
     * @return PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory());
        jpaTransactionManager.setDataSource(dataSource());

        return jpaTransactionManager;
    }

    /**
     * Throw runtime exceptions: JPA
     *
     * @return HibernateExceptionTranslator
     */
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    /**
     * Set jpa properties
     *
     * @return Properties
     */
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.jdbc.lob.non_contextual_creation", Boolean.TRUE);
        properties.put("hibernate.enable_lazy_load_no_trans", Boolean.TRUE);
        properties.put("spring.jpa.properties.hibernate.enable_lazy_load_no_trans", Boolean.TRUE);
        //properties.put("current_session_context_class", "thread");
        //properties.put("spring.jpa.hibernate.ddl-auto", "update");

        return properties;
    }
}