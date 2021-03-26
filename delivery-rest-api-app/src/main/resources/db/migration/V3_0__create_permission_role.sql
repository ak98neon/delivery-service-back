DROP TABLE IF EXISTS permission_role CASCADE;
CREATE TABLE permission_role
(
    permission_id BIGSERIAL,
    FOREIGN KEY (permission_id) REFERENCES permission (id),
    role_id       BIGSERIAL,
    FOREIGN KEY (role_id) REFERENCES role (id)
);
