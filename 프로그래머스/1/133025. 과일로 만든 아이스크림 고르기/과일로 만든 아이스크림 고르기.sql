-- 코드를 입력하세요
SELECT f.flavor FROM first_half f INNER JOIN icecream_info i on f.flavor = i.flavor WHERE TOTAL_ORDER >= 3000 AND ingredient_type = 'fruit_based' ORDER BY TOTAL_ORDER DESC;



-- FIRST_HALF , 출하 번호 , 아이스크림 맛 , 총준문량
-- ICECREAM_INFO , 아이스크림 맛 , 아이스크럼 성분 타입 
-- 주 성분이 설탕이면 sugar_based , 과일이면 fruit_based 


