-- 코드를 입력하세요

SELECT b.title,b.board_id,r.reply_id,r.writer_id,r.contents,date_format(r.created_date,"%Y-%m-%d") as created_date
FROM used_goods_board b
INNER JOIN used_goods_reply r ON r.board_id = b.board_id
WHERE b.created_date LIKE "2022-10%"
ORDER BY r.created_date ASC , b.title ASC


# 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회