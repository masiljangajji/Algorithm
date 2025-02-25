-- 코드를 작성해주세요


SELECT count(*) AS COUNT  
FROM ecoli_data 
WHERE genotype & 0b10 = 0
AND genotype & (0b1|0b100) != 0;