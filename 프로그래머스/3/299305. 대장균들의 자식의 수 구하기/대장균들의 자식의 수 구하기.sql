-- 코드를 작성해주세요


-- f.id,count(*) AS child_count

# SELECT p.id AS parent_id , count(*) AS child_count
# FROM ecoli_data p
# LEFT JOIN ecoli_data c ON c.parent_id = p.id
# GROUP BY p.id

# count(*) AS child_count

SELECT p.id  , count(c.id) AS child_count
FROM ecoli_data p
LEFT JOIN ecoli_data c ON c.parent_id = p.id
GROUP BY p.id
