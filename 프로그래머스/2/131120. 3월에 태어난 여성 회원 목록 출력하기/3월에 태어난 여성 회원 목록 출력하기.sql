-- 코드를 입력하세요
SELECT member_id,member_name,gender,date_format(date_of_birth,'%Y-%m-%d') AS date_of_birth
FROM member_profile
WHERE month(date_of_birth) = 03 
AND tlno IS NOT NULL 
AND gender = 'W' 
ORDER BY member_id ASC;

-- member_profile

