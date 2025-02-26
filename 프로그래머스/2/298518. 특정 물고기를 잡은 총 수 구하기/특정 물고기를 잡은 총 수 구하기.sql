-- 코드를 작성해주세요


SELECT count(*) AS fish_count
FROM fish_info fi
JOIN fish_name_info fn ON fi.fish_type = fn.fish_type
WHERE fn.fish_name IN ('BASS','SNAPPER');
