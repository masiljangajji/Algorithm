-- 코드를 작성해주세요
SELECT sum(price) AS total_price
FROM item_info
WHERE item_id in (SELECT item_id FROM item_info WHERE rarity = 'LEGEND');