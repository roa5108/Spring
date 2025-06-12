DROP TABLE IF EXISTS tbl_board;

CREATE TABLE tbl_board (
    no INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT,
    writer VARCHAR(50) NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tbl_board(title, content, writer)
VALUES
    ('테스트제목1','테스트내용1','user00'),
    ('테스트제목2','테스트내용2','user00'),
    ('테스트제목3','테스트내용3','user00'),
    ('테스트제목4','테스트내용4','user00'),
    ('테스트제목5','테스트내용5','user00');

SELECT * FROM tbl_board;