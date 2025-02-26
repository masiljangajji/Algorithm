-- 코드를 작성해주세요


SELECT i.item_id,i.item_name,i.rarity
FROM item_info i
JOIN item_tree t ON i.item_id = t.item_id
JOIN item_info f ON f.item_id = t.parent_item_id
WHERE f.rarity = 'RARE'
ORDER BY i.item_id DESC

-- 업그레이드 가능 = 자식이 있다 ITEM_ID	ITEM_NAME	RARITY	PRICE	ITEM_ID	PARENT_ITEM_ID


# 0	ITEM_A	RARE	10000	0	null
# 1	ITEM_B	RARE	9000	1	0
# 2	ITEM_C	LEGEND	11000	2	0
# 3	ITEM_D	RARE	10000	3	1
# 4	ITEM_E	RARE	12000	4	1