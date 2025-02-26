-- 코드를 작성해주세요

SELECT DISTINCT d.id,d.email,d.first_name,d.last_name  
FROM developers d
JOIN skillcodes s ON s.code & d.skill_code !=0
WHERE s.name IN ('Python','C#')
ORDER BY d.id ASC;