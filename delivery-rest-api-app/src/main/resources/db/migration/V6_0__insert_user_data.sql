INSERT INTO permission (name)
VALUES ('can_create_user'),
       ('can_update_user'),
       ('can_read_user'),
       ('can_delete_user');

INSERT INTO role (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_SAFETY'),
       ('ROLE_AB_MANAGER'),
       ('ROLE_SC'),
       ('ROLE_MANAGER'),
       ('ROLE_SUPERVISOR'),
       ('ROLE_DRIVER'),
       ('ROLE_USER');

INSERT INTO permission_role (permission_id, role_id)
    (SELECT id, (SELECT id FROM role WHERE name = 'ROLE_ADMIN') FROM permission WHERE name = 'can_create_user');

INSERT INTO permission_role (permission_id, role_id)
    (SELECT id, (SELECT id FROM role WHERE name = 'ROLE_ADMIN') FROM permission WHERE name = 'can_read_user');

INSERT INTO permission_role (permission_id, role_id)
    (SELECT id, (SELECT id FROM role WHERE name = 'ROLE_ADMIN') FROM permission WHERE name = 'can_delete_user');

INSERT INTO permission_role (permission_id, role_id)
    (SELECT id, (SELECT id FROM role WHERE name = 'ROLE_ADMIN') FROM permission WHERE name = 'can_update_user');

INSERT INTO permission_role (permission_id, role_id)
        (SELECT id, (SELECT id FROM role WHERE name = 'ROLE_USER') FROM permission WHERE name = 'can_read_user');