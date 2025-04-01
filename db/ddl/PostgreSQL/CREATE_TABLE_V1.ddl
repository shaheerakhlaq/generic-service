-- Table: public.sw_organizations

-- DROP TABLE IF EXISTS public.sw_organizations;

CREATE TABLE IF NOT EXISTS public.sw_organizations
(
    id                bigint                                             NOT NULL DEFAULT nextval('seq_id_organization'::regclass),
    str_name          character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_code          character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_address       character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_email_address character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_phone_number  character varying(80) COLLATE pg_catalog."default" NOT NULL,
    int_status        integer                                            NOT NULL,
    int_created_by    bigint,
    dat_created_date  timestamp(6) without time zone,
    int_modified_by   bigint,
    dat_modified_date timestamp(6) without time zone,
    CONSTRAINT pk_id_organization PRIMARY KEY (id)
)
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.sw_organizations
    OWNER to postgres;

-- Table: sw_users

CREATE TABLE IF NOT EXISTS sw_users
(
    id                bigint                                             NOT NULL DEFAULT nextval('seq_id_user'::regclass),
    id_organization   bigint                                             NOT NULL,
    str_first_name    character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_last_name     character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_email_address character varying(80) COLLATE pg_catalog."default" NOT NULL,
    str_phone_number  character varying(80) COLLATE pg_catalog."default" NOT NULL,
    int_status        integer                                            NOT NULL,
    int_created_by    bigint,
    dat_created_date  timestamp(6) without time zone,
    int_modified_by   bigint,
    dat_modified_date timestamp(6) without time zone,
    CONSTRAINT pk_id_user PRIMARY KEY (id),
    CONSTRAINT fk_user_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.sw_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS sw_users
    OWNER to postgres;

-- Table: sw_user_credentials

CREATE TABLE IF NOT EXISTS sw_user_credentials
(
    id                bigint                                             NOT NULL DEFAULT nextval('seq_id_user_credential'::regclass),
    id_user           bigint                                             NOT NULL,
    str_credential    character varying(80) COLLATE pg_catalog."default" NOT NULL,
    int_status        integer                                            NOT NULL,
    int_created_by    bigint,
    dat_created_date  timestamp(6) without time zone,
    int_modified_by   bigint,
    dat_modified_date timestamp(6) without time zone,
    CONSTRAINT pk_id_user_credential PRIMARY KEY (id),
    CONSTRAINT fk_user_credential_id_user FOREIGN KEY (id_user)
        REFERENCES sw_users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS sw_user_credentials
    OWNER to postgres;