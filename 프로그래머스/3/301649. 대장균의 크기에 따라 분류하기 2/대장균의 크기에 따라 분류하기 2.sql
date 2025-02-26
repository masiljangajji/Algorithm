-- 코드를 작성해주세요

SELECT id,
    CASE 
        WHEN rank() over(ORDER BY size_of_colony DESC)/count(*) over() <= 0.25 THEN 'CRITICAL'
        WHEN rank() over(ORDER BY size_of_colony DESC)/count(*) over() <= 0.5 THEN 'HIGH'
        WHEN rank() over(ORDER BY size_of_colony DESC)/count(*) over() <= 0.75 THEN 'MEDIUM'
        WHEN rank() over(ORDER BY size_of_colony DESC)/count(*) over() <= 1 THEN 'LOW'
    END AS colony_name
FROM ecoli_data
ORDER BY id;
