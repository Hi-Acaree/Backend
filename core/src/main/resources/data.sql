INSERT INTO person (id, first_name, last_name, email, phone, picture_url) VALUES
                                                                              (9, 'Tom', 'Anderson', 'tom.anderson@example.com', '9999999999', 'https://acaree-s3-bucket.s3.amazonaws.com/images/ahmed-nishaath-cm1FcKUDPd4-unsplash.jpg'),
                                                                              (10, 'Jerry', 'Smith', 'jerry.smith@example.com', '8888888888', 'https://acaree-s3-bucket.s3.amazonaws.com/images/amirreza-jamshidbeigi-_4ifSWfBWss-unsplash.jpg'),
                                                                              (11, 'John', 'Doe', 'john.doe@example.com', '7777777777', 'https://acaree-s3-bucket.s3.amazonaws.com/images/arsowibowo-L-dx-tOL-VU-unsplash.jpg'),
                                                                              (12, 'Jane', 'Doe', ' Jane.Doe@example.com', '6666666666', 'https://acaree-s3-bucket.s3.amazonaws.com/images/ashkan-forouzani-DPEPYPBZpB8-unsplash.jpg'),
                                                                              (13, 'Bob', 'Johnson', 'bob.johnson@example.com', '5555555555', 'https://acaree-s3-bucket.s3.amazonaws.com/images/ashkan-forouzani-IXSgwfBGnCg-unsplash.jpg'),
                                                                              (14, 'Alice', 'Brown', 'alice.brown@example.com', '4444444444', 'https://acaree-s3-bucket.s3.amazonaws.com/images/ashkan-forouzani-l-NIPb-9Njg-unsplash.jpg'),
                                                                              (15, 'David', 'Garcia', 'david.garcia@example.com', '3333333333', 'https://acaree-s3-bucket.s3.amazonaws.com/images/bruno-rodrigues-279xIHymPYY-unsplash.jpg'),
                                                                              (16, 'Emily', 'Miller', 'emily.miller@example.com', '2222222222', 'https://acaree-s3-bucket.s3.amazonaws.com/images/cdc-_N7I1JyPYJw-unsplash.jpg'),
                                                                              (17, 'Frank', 'Wilson', 'frank.wilson@example.com', '1111111111', 'https://acaree-s3-bucket.s3.amazonaws.com/images/dalton-ngangi-ZCztndOWdjs-unsplash.jpg'),
                                                                              (18, 'Sarah', 'Lee', 'sarah.lee@example.com', '0000000000', 'https://acaree-s3-bucket.s3.amazonaws.com/images/cezar-sampaio-9b3-H6kaiUI-unsplash.jpg'),
                                                                              (19, 'Mark', 'Taylor', 'mark.taylor@example.com', '9999999999', 'https://acaree-s3-bucket.s3.amazonaws.com/images/doctor-2337835_1280.jpg'),
                                                                              (20, 'Lisa', 'Garcia', 'lisa.garcia@example.com', '8888888888', 'https://acaree-s3-bucket.s3.amazonaws.com/images/gift-habeshaw-95PAa3Vfjeg-unsplash.jpg');
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
                                                                                   (20,'Dermatology', 'Central Hospital', 'Dermatology Department');
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