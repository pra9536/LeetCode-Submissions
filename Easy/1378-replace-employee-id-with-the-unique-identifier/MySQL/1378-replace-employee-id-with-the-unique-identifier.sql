# Write your MySQL query statement below

-- SELECT u.unique_id, n.name
-- FROM Employees n
-- LEFT JOIN EmployeeUNI u
-- ON u.id = n.id;

SELECT u.unique_id, n.name
FROM EmployeeUNI u
RIGHT JOIN Employees n
ON u.id = n.id;

