/* ユーザーマスタ */
INSERT INTO demo_user (
                       user_id
                      ,password
                      ,user_name
                      ,birthday
                      ,age
                      ,gender
                      ,department_id
                      ,role
) VALUES ('0001','passw0rd','demoUser01','1991-09-06',30,1,1,'ROLE_ADMIN')
;

/* 部署マスタ */
INSERT INTO demo_department (
                             department_id
                            ,department_name
) VALUES (1,'System management department')
       ,(2,'sales department')
;