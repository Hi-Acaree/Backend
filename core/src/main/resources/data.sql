
INSERT INTO person (id, first_name, last_name, email, phone, picture_url) VALUES
                                                                              (9, 'Tom', 'Anderson', 'tom.anderson@example.com', '9999999999', '/images/alexandr-podvalny-tE7_jvK-_YU-unsplash.jpg'),
                                                                              (10, 'Sarah', 'Johnson', 'sarah.johnson@example.com', '8888888888', '/images/ashkan-forouzani-IXSgwfBGnCg-unsplash.jpg'),
                                                                                   (11, 'David', 'Williams', 'david.williams@example.com', '7777777777', '/images/bruno-rodrigues-279xIHymPYY-unsplash.jpg'),
                                                                                   (12, 'Jennifer', 'Brown', 'cc@tt.com"', '6666666666',  '/images/cezar-sampaio-9b3-H6kaiUI-unsplash.jpg'),
                                                                                   (13, 'Michael', 'Jones', 'jamie@test.com', '9093944443',  '/images/doctor-2337835_1280.jpg'),
                                                                                   (14, 'Emily', 'Davis', 'emily.davis@example.com', '5555555555', '/images/gift-habeshaw-95PAa3Vfjeg-unsplash.jpg'),
                                                                                   (15, 'Daniel', 'Miller', 'daniel.miller@example.com', '4444444444', '/images/mark-williams-5hvWQ5Xuji4-unsplash.jpg'),
                                                                                   (16, 'Ava', 'Wilson', 'ava.wilson@example.com', '3333333333', '/images/national-cancer-institute-kooSjlL8LnQ-unsplash.jpg'),
                                                                                   (17, 'Sophia', 'Taylor', 'sophia.taylor@example.com', '2222222222', '/images/pexels-antoni-shkraba-5215017.jpg'),
                                                                                   (18, 'James', 'Anderson', 'james.anderson@example.com', '1111111111', '/images/pexels-tima-miroshnichenko-5452201.jpg'),
                                                                                   (19, 'Olivia', 'Smith', 'olivia.smith@example.com', '0000000000', '/images/pexels-tima-miroshnichenko-5407206.jpg'),
                                                                                   (20, 'Benjamin', 'Brown', 'benjamin.brown@example.com', '9999999999', '/images/linkedin-sales-solutions-pAtA8xe_iVM-unsplash.jpg');




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
-- Insert DoctorAvailability data for a doctor with ID 1 (replace with actual doctor_id)
INSERT INTO doctor_availability (doctor_id, day_of_week)
VALUES
    (1, 'MONDAY'),
    (1, 'TUESDAY');


-- Assuming today is 2024-02-13, inserting time slots for the next Monday and Tuesday
INSERT INTO time_slot (version, start_time, end_time, is_booked, availability_id)
VALUES
    (0, '2024-02-19 09:00:00', '2024-02-19 10:00:00', FALSE, 1),
    (0, '2024-02-19 10:00:00', '2024-02-19 11:00:00', FALSE, 1),
    (0, '2024-02-20 09:00:00', '2024-02-20 10:00:00', FALSE, 2),
    (0, '2024-02-20 10:00:00', '2024-02-20 11:00:00', FALSE, 2);










