-- 코드를 작성해주세요

SELECT id,
    CASE
        WHEN size_of_colony <= 100 THEN 'LOW'
        WHEN size_of_colony BETWEEN 101 AND 1000 THEN 'MEDIUM'
        WHEN size_of_colony > 1000 THEN 'HIGH'
        END AS SIZE
FROM ecoli_data
ORDER BY id ASC;