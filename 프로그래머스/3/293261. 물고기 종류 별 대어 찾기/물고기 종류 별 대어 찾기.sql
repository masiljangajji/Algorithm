-- 코드를 작성해주세요

SELECT i.id , n.fish_name,i.length AS length
FROM fish_info i
JOIN fish_name_info n on i.fish_type = n.fish_type
WHERE i.length = (
    SELECT max(length)
    FROM fish_info
    WHERE fish_type = i.fish_type
)
ORDER BY i.id ASC;


