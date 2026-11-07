WITH data AS (
SELECT 
    machine_id,
    process_id,
    MAX(CASE WHEN activity_type = 'start' THEN timestamp END) AS start,
    MAX(CASE WHEN activity_type = 'end' THEN timestamp END) AS end
FROM Activity
GROUP BY machine_id, process_id
)
SELECT 
    machine_id,  
    round(avg(end - start), 3) AS processing_time
FROM data
GROUP BY machine_id;

