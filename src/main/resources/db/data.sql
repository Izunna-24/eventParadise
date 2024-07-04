truncate table organizer cascade;
truncate table event cascade;


insert into organizer(id,email,name, password, time_created) values
(400,'phatliar1@email.com', 'event company','password','2024-07-03T15:03:03.792009700'),
(401,'phatliar2@email.com', 'event company','password','2024-07-03T15:03:03.792009700'),
(402,'phatliar3@email.com', 'event company','password','2024-07-03T15:03:03.792009700'),
(403,'phatliar4@email.com', 'event company','password','2024-07-03T15:03:03.792009700'),
(404,'phatliar5@email.com', 'event company','password','2024-07-03T15:03:03.792009700');


insert into event(id,name, description,organizer_id, start_time,category,end_time, time_created) values
(200,'Tamerri festival', 'frenzy gathering of strangers',400,'2024-07-03T15:03:03.792009700','CONFERENCE','2024-07-03T15:03:03.792009700','2024-07-03T15:03:03.792009700'),
(201,'Tamerri festival', 'frenzy gathering of strangers',401,'2024-07-03T15:03:03.792009700','CONCERT','2024-07-03T15:03:03.792009700','2024-07-03T15:03:03.792009700'),
(202,'Tamerri festival', 'frenzy gathering of strangers',402,'2024-07-03T15:03:03.792009700','CONFERENCE','2024-07-03T15:03:03.792009700','2024-07-03T15:03:03.792009700'),
(203,'Tamerri festival', 'frenzy gathering of strangers',403,'2024-07-03T15:03:03.792009700','WORKSHOP','2024-07-03T15:03:03.792009700','2024-07-03T15:03:03.792009700'),
(204,'Tamerri festival', 'frenzy gathering of strangers',404,'2024-07-03T15:03:03.792009700','WORKSHOP','2024-07-03T15:03:03.792009700','2024-07-03T15:03:03.792009700');
