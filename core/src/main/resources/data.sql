
INSERT INTO person (id, first_name, last_name, email, phone, picture_url)
VALUES
    (9, 'Tom', 'Anderson', 'tom.anderson@example.com', '9999999999', 'images/alexandr-podvalny-tE7_jvK-_YU-unsplash.jpg'),
    (10, 'Sarah', 'Johnson', 'sarah.johnson@example.com', '8888888888', 'images/ashkan-forouzani-IXSgwfBGnCg-unsplash.jpg'),
    (11, 'David', 'Williams', 'david.williams@example.com', '7777777777', 'images/bruno-rodrigues-279xIHymPYY-unsplash.jpg'),
    (12, 'Jennifer', 'Brown', 'cc@tt.com"', '6666666666',  'images/cezar-sampaio-9b3-H6kaiUI-unsplash.jpg'),
    (13, 'Michael', 'Jones', 'jamie@test.com', '9093944443',  'images/doctor-2337835_1280.jpg'),
    (14, 'Emily', 'Davis', 'emily.davis@example.com', '5555555555', 'images/gift-habeshaw-95PAa3Vfjeg-unsplash.jpg'),
    (15, 'Daniel', 'Miller', 'daniel.miller@example.com', '4444444444', 'images/mark-williams-5hvWQ5Xuji4-unsplash.jpg'),
    (16, 'Ava', 'Wilson', 'ava.wilson@example.com', '3333333333', 'images/national-cancer-institute-kooSjlL8LnQ-unsplash.jpg'),
    (17, 'Sophia', 'Taylor', 'sophia.taylor@example.com', '2222222222', 'images/pexels-antoni-shkraba-5215017.jpg'),
    (18, 'James', 'Anderson', 'james.anderson@example.com', '1111111111', 'images/pexels-tima-miroshnichenko-5452201.jpg'),
    (19, 'Olivia', 'Smith', 'olivia.smith@example.com', '0000000000', 'images/pexels-tima-miroshnichenko-5407206.jpg'),
    (20, 'Benjamin', 'Brown', 'benjamin.brown@example.com', '9999999999', 'images/linkedin-sales-solutions-pAtA8xe_iVM-unsplash.jpg'),
    (21, 'Lisa', 'Johnson', 'lisa.johnson@example.com', '8888888888', 'images/national-cancer-institute-lTZUfrst5fM-unsplash.jpg'),
    (22, 'Mark', 'Smith', 'mark.smith@example.com', '7777777777', 'images/pexels-antoni-shkraba-5215017.jpg'),
    (23, 'John', 'Doe', 'john.doe@example.com', '6666666666', 'images/siednji-leon-lnlSIsiSjjc-unsplash.jpg'),
    (24, 'Jane', 'Doe', 'jane.doe@example.com', '5555555555', 'images/steward-masweneng-uIvjLq_q5g8-unsplash.jpg'),
    (25, 'Bob', 'Johnson', 'bob.johnson@example.com', '4444444444', 'images/tima-miroshnichenko-5452201.jpg'),
    (26, 'Alice', 'Brown', 'alice.brown@example.com', '3333333333', 'images/pexels-anna-shvets-4225880.jpg'),
    (27, 'David', 'Miller', 'david.miller@example.com', '2222222222', 'images/michael-amadeus-oidJ1WGkIeY-unsplash.jpg'),
    (28, 'Emily', 'Davis', 'emily.davis@example.com', '1111111111', 'images/muhammad-hicham--3HE32KRqJs-unsplash.jpg'),
    (29, 'Michael', 'Jones', 'michael.jones@example.com', '0000000000', 'images/masao-mask-PmSR52VQ2SE-unsplash.jpg'),
    (30, 'Sophia', 'Taylor', 'sophia.taylor@example.com', '9999999999', 'images/doctor-2337835_1280.jpg')
    ON DUPLICATE KEY UPDATE id=VALUES(id);








INSERT INTO doctor (person_id, specialization, hospital_name, department_name) VALUES
                                                                                   (9,'Cardiology', 'City Hospital', 'Cardiology Department'),
                                                                                   (10,'Dermatology', 'General Hospital', 'Dermatology Department'),
                                                                                   (11,'Neurology', 'East Coast Hospital', 'Neurology Department'),
                                                                                   (12,'Oncology', 'Southwest Hospital', 'Oncology Department'),
                                                                                   (13,'Orthopedics', 'Northwest Hospital', 'Orthopedics Department'),
                                                                                   (14,'Pediatrics', 'West Coast Hospital', 'Pediatrics Department'),
                                                                                   (15,'Psychiatry', 'Central Hospital', 'Psychiatry Department'),
                                                                                   (16,'Radiology', 'East Coast Hospital', 'Radiology Department'),
                                                                                   (17,'Surgery', 'Southwest Hospital', 'Surgery Department'),
                                                                                   (18,'Urology', 'Northwest Hospital', 'Urology Department'),
                                                                                   (19,'Cardiology', 'West Coast Hospital', 'Cardiology Department'),
                                                                                   (20,'Dermatology', 'Central Hospital', 'Dermatology Department'),
                                                                                   (21, 'Neurology', 'East Coast Hospital', 'Neurology Department'),
                                                                                   (22, 'Oncology', 'Southwest Hospital', 'Oncology Department'),
                                                                                   (23, 'Orthopedics', 'Northwest Hospital', 'Orthopedics Department'),
                                                                                   (24, 'Pediatrics', 'West Coast Hospital', 'Pediatrics Department'),
                                                                                   (25, 'Psychiatry', 'Central Hospital', 'Psychiatry Department'),
                                                                                   (26, 'Radiology', 'East Coast Hospital', 'Radiology Department'),
                                                                                   (27, 'Surgery', 'Southwest Hospital', 'Surgery Department'),
                                                                                   (28, 'Urology', 'Northwest Hospital', 'Urology Department'),
                                                                                   (29, 'Cardiology', 'West Coast Hospital', 'Cardiology Department'),
                                                                                   (30, 'Dermatology', 'Central Hospital', 'Dermatology Department')
ON DUPLICATE KEY UPDATE person_id=VALUES(person_id);

INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (1, 'MONDAY'),
                                                             (1, 'TUESDAY'),
                                                             (1, 'WEDNESDAY'),
                                                             (1, 'THURSDAY'),
                                                             (1, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (2, 'MONDAY'),
                                                             (2, 'TUESDAY'),
                                                             (2, 'WEDNESDAY'),
                                                             (2, 'THURSDAY'),
                                                             (2, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (3, 'MONDAY'),
                                                             (3, 'TUESDAY'),
                                                             (3, 'WEDNESDAY'),
                                                             (3, 'THURSDAY'),
                                                             (3, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (4, 'MONDAY'),
                                                             (4, 'TUESDAY'),
                                                             (4, 'WEDNESDAY'),
                                                             (4, 'THURSDAY'),
                                                             (4, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (5, 'MONDAY'),
                                                             (5, 'TUESDAY'),
                                                             (5, 'WEDNESDAY'),
                                                             (5, 'THURSDAY'),
                                                             (5, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (6, 'MONDAY'),
                                                             (6, 'TUESDAY'),
                                                             (6, 'WEDNESDAY'),
                                                             (6, 'THURSDAY'),
                                                             (6, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (7, 'MONDAY'),
                                                             (7, 'TUESDAY'),
                                                             (7, 'WEDNESDAY'),
                                                             (7, 'THURSDAY'),
                                                             (7, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (8, 'MONDAY'),
                                                             (8, 'TUESDAY'),
                                                             (8, 'WEDNESDAY'),
                                                             (8, 'THURSDAY'),
                                                             (8, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (9, 'MONDAY'),
                                                             (9, 'TUESDAY'),
                                                             (9, 'WEDNESDAY'),
                                                             (9, 'THURSDAY'),
                                                             (9, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (10, 'MONDAY'),
                                                             (10, 'TUESDAY'),
                                                             (10, 'WEDNESDAY'),
                                                             (10, 'THURSDAY'),
                                                             (10, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (11, 'MONDAY'),
                                                             (11, 'TUESDAY'),
                                                             (11, 'WEDNESDAY'),
                                                             (11, 'THURSDAY'),
                                                             (11, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (12, 'MONDAY'),
                                                             (12, 'TUESDAY'),
                                                             (12, 'WEDNESDAY'),
                                                             (12, 'THURSDAY'),
                                                             (12, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (13, 'MONDAY'),
                                                             (13, 'TUESDAY'),
                                                             (13, 'WEDNESDAY'),
                                                             (13, 'THURSDAY'),
                                                             (13, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (14, 'MONDAY'),
                                                             (14, 'TUESDAY'),
                                                             (14, 'WEDNESDAY'),
                                                             (14, 'THURSDAY'),
                                                             (14, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (15, 'MONDAY'),
                                                             (15, 'TUESDAY'),
                                                             (15, 'WEDNESDAY'),
                                                             (15, 'THURSDAY'),
                                                             (15, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (16, 'MONDAY'),
                                                             (16, 'TUESDAY'),
                                                             (16, 'WEDNESDAY'),
                                                             (16, 'THURSDAY'),
                                                             (16, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (17, 'MONDAY'),
                                                             (17, 'TUESDAY'),
                                                             (17, 'WEDNESDAY'),
                                                             (17, 'THURSDAY'),
                                                             (17, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (18, 'MONDAY'),
                                                             (18, 'TUESDAY'),
                                                             (18, 'WEDNESDAY'),
                                                             (18, 'THURSDAY'),
                                                             (18, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (19, 'MONDAY'),
                                                             (19, 'TUESDAY'),
                                                             (19, 'WEDNESDAY'),
                                                             (19, 'THURSDAY'),
                                                             (19, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (20, 'MONDAY'),
                                                             (20, 'TUESDAY'),
                                                             (20, 'WEDNESDAY'),
                                                             (20, 'THURSDAY'),
                                                             (20, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (21, 'MONDAY'),
                                                             (21, 'TUESDAY'),
                                                             (21, 'WEDNESDAY'),
                                                             (21, 'THURSDAY'),
                                                             (21, 'FRIDAY');
INSERT INTO doctor_availability (doctor_id, day_of_week) VALUES
                                                             (22, 'MONDAY'),
                                                             (22, 'TUESDAY'),
                                                             (22, 'WEDNESDAY'),
                                                             (22, 'THURSDAY'),
                                                             (22, 'FRIDAY');





INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 1);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 2);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 3);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 4);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 5);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 6);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 7);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 8);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 9);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 10);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 11);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 12);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 13);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 14);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 15);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 16);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 17);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 18);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 19);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 20);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 21);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 22);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 23);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 24);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 25);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 26);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 27);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 28);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 29);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 30);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 31);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 32);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 33);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 34);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 35);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 36);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 37);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 38);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 39);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 40);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 41);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 42);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 43);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 44);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 45);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 46);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 47);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 48);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 49);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 50);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 51);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 52);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 53);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 54);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 55);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 56);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 57);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 58);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 59);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 60);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 61);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 62);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 63);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 64);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 65);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 66);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 67);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 68);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 69);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 70);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 71);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 72);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 73);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 74);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 75);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 76);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 77);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 78);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 79);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 80);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 81);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 82);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 83);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 84);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 85);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 86);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 87);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 88);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 89);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 90);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 91);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 92);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 93);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 94);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 95);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 96);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 97);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 98);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 99);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 100);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 101);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 102);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 103);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 104);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 105);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:00:55', '2024-03-11 09:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 09:30:55', '2024-03-11 10:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:00:55', '2024-03-11 10:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 10:30:55', '2024-03-11 11:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:00:55', '2024-03-11 11:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 11:30:55', '2024-03-11 12:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:00:55', '2024-03-11 12:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 12:30:55', '2024-03-11 13:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:00:55', '2024-03-11 13:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 13:30:55', '2024-03-11 14:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:00:55', '2024-03-11 14:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 14:30:55', '2024-03-11 15:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:00:55', '2024-03-11 15:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 15:30:55', '2024-03-11 16:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:00:55', '2024-03-11 16:30:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-11 16:30:55', '2024-03-11 17:00:55', false, 106);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:00:55', '2024-03-12 09:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 09:30:55', '2024-03-12 10:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:00:55', '2024-03-12 10:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 10:30:55', '2024-03-12 11:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:00:55', '2024-03-12 11:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 11:30:55', '2024-03-12 12:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:00:55', '2024-03-12 12:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 12:30:55', '2024-03-12 13:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:00:55', '2024-03-12 13:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 13:30:55', '2024-03-12 14:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:00:55', '2024-03-12 14:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 14:30:55', '2024-03-12 15:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:00:55', '2024-03-12 15:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 15:30:55', '2024-03-12 16:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:00:55', '2024-03-12 16:30:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-12 16:30:55', '2024-03-12 17:00:55', false, 107);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:00:55', '2024-03-13 09:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 09:30:55', '2024-03-13 10:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:00:55', '2024-03-13 10:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 10:30:55', '2024-03-13 11:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:00:55', '2024-03-13 11:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 11:30:55', '2024-03-13 12:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:00:55', '2024-03-13 12:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 12:30:55', '2024-03-13 13:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:00:55', '2024-03-13 13:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 13:30:55', '2024-03-13 14:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:00:55', '2024-03-13 14:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 14:30:55', '2024-03-13 15:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:00:55', '2024-03-13 15:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 15:30:55', '2024-03-13 16:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:00:55', '2024-03-13 16:30:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-13 16:30:55', '2024-03-13 17:00:55', false, 108);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:00:55', '2024-03-14 09:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 09:30:55', '2024-03-14 10:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:00:55', '2024-03-14 10:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 10:30:55', '2024-03-14 11:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:00:55', '2024-03-14 11:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 11:30:55', '2024-03-14 12:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:00:55', '2024-03-14 12:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 12:30:55', '2024-03-14 13:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:00:55', '2024-03-14 13:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 13:30:55', '2024-03-14 14:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:00:55', '2024-03-14 14:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 14:30:55', '2024-03-14 15:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:00:55', '2024-03-14 15:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 15:30:55', '2024-03-14 16:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:00:55', '2024-03-14 16:30:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-14 16:30:55', '2024-03-14 17:00:55', false, 109);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:00:55', '2024-03-15 09:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 09:30:55', '2024-03-15 10:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:00:55', '2024-03-15 10:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 10:30:55', '2024-03-15 11:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:00:55', '2024-03-15 11:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 11:30:55', '2024-03-15 12:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:00:55', '2024-03-15 12:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 12:30:55', '2024-03-15 13:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:00:55', '2024-03-15 13:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 13:30:55', '2024-03-15 14:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:00:55', '2024-03-15 14:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 14:30:55', '2024-03-15 15:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:00:55', '2024-03-15 15:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 15:30:55', '2024-03-15 16:00:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:00:55', '2024-03-15 16:30:55', false, 110);
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id) VALUES (0, '2024-03-15 16:30:55', '2024-03-15 17:00:55', false, 110);


























