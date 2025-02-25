-- 코드를 입력하세요
SELECT b.title,b.board_id,r.reply_id,r.writer_id,r.contents,date_format(r.created_date,'%Y-%m-%d')FROM used_goods_board b
JOIN used_goods_reply r ON b.board_id = r.board_id WHERE b.created_date Like '2022-10%'
ORDER BY r.created_date ASC , b.title ASC;



-- used_goods_board
-- used_goods_reply

-- USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문