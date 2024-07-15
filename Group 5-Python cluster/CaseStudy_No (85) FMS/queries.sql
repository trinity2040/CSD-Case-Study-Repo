-- Query 1:
SELECT COUNT(*) AS expiring_memberships
FROM Memberships
WHERE membership_expiry BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH);

-- Query 2:
SELECT trainer_id, name, contact_info, availability
FROM Trainers
WHERE specialty = 'Specific Specialty';

-- Query 3:
SELECT c.class_id, c.class_name, c.schedule, c.capacity
FROM Classes c
JOIN (
    SELECT class_id, COUNT(*) AS booked_slots
    FROM Attendance
    GROUP BY class_id
) a ON c.class_id = a.class_id
WHERE a.booked_slots >= c.capacity;

-- Query 4:
SELECT m.member_id, m.member_name, COUNT(a.attendance_id) AS attended_classes
FROM Attendance a
JOIN Memberships m ON a.member_id = m.membership_id
WHERE a.attendance_date BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND CURDATE()
GROUP BY a.member_id
ORDER BY attended_classes DESC
LIMIT 1;

-- Query 5:
SELECT c.class_id, c.class_name, c.schedule, c.capacity
FROM Classes c
JOIN Trainers t ON c.trainer_id = t.trainer_id
WHERE t.trainer_id = 1;
