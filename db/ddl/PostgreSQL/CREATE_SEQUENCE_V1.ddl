-- SEQUENCE: public.seq_id_organization

CREATE SEQUENCE IF NOT EXISTS public.seq_id_organization
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_organization OWNER TO postgres;
--ALTER SEQUENCE public.seq_id_organization OWNED BY public.sw_error_codes.id;

-- SEQUENCE: public.seq_id_user

CREATE SEQUENCE IF NOT EXISTS public.seq_id_user
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user OWNER TO postgres;
--ALTER SEQUENCE public.seq_id_user OWNED BY public.sw_users.id;

-- SEQUENCE: public.seq_id_user_credential

CREATE SEQUENCE IF NOT EXISTS public.seq_id_user_credential
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user_credential OWNER TO postgres;
--ALTER SEQUENCE public.seq_id_user_credential OWNED BY public.sw_user_credentials.id;