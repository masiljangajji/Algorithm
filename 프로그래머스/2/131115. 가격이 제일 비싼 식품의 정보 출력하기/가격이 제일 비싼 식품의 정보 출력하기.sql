-- 코드를 입력하세요
SELECT product_id,product_name,product_cd,category,price
FROM food_product
WHERE price = (SELECT max(price) FROM food_product)
