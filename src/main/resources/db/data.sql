insert into authority (name)
values ('USER'),
       ('ADMIN');

insert into grade (name)
values ('NEWBIE'),
       ('VIP');

insert into member (grade_id, username, email, password, nickname)
values (1, 'newbie01', 'newbie01@example.com', '$2a$10$83fxp4rnR7BRdekypMgXUupNGpn/SAqHxehjdan6/PlTAX.expvwq', '새싹01'),
       (1, 'newbie02', 'newbie02@example.com', '$2a$10$NKT99HAozo5IGjrcU8mDFuMLaVvI56x.qWUVbD.VoxB4FPo.zczka', '새싹02'),
       (1, 'newbie03', 'newbie03@example.com', '$2a$10$Fu7CNOypCtwFbUlI9EjRre/ANELu55wsSSxBf0/MIP1XJEBeL7IYS', '새싹03'),
       (2, 'vip01',    'vip01@example.com',    '$2a$10$SE5CUDzPX0NlKsYCG7aVKuBti5tWfxmtiixMEqMCQqsBmuZpezVDK', '우수01'),
       (2, 'vip02',    'vip02@example.com',    '$2a$10$adeBH0lOCIQOyT9fF8/JaOqZftnLVJ.DkcPed9YKv6ZnjlVEeP1Bu', '우수02'),
       (2, 'vip03',    'vip03@example.com',    '$2a$10$f43fg9hujjbEVTh5gbHzK.DaOijxlpmgwE1JEPSE0kyzWgeRfHL/G', '우수03'),
       (2, 'admin',    'admin@example.com',    '$2a$10$/tXi8IaYqKPcGqJDE8gd9.k/BkHmNfrPQEJ.LKQSPPaZ4fF/IPM/u', '어드민');

insert into member_authority (member_id, authority_id)
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 1),
       (7, 2);
