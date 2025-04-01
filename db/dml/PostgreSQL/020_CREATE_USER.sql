INSERT INTO sw_users(id_organization, str_first_name, str_last_name, str_email_address, str_phone_number,
                     int_status, int_created_by, dat_created_date)
VALUES (2, 'Super', 'Admin', 'superadmin', '1212213',
        1, 1, now());

-- Password: superadmin
INSERT INTO sw_user_credentials(id_user, str_credential, int_status, int_created_by, dat_created_date)
VALUES (1, 'Test@1234', 1, 1, now());