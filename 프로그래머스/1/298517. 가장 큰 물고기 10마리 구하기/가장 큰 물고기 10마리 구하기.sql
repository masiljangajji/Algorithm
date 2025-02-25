-- 코드를 작성해주세요

SELECT id AS ID ,length AS LENGTH 
FROM fish_info 
WHERE length IS NOT NULL 
ORDER BY length DESC , id ASC
Limit 10;