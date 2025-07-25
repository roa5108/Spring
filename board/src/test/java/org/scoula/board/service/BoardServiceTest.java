package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardServiceTest {

    @Autowired
    private BoardService service;

    @Test
    public void getList() {
        for(BoardDTO board : service.getList()) {
            log.info(board);
        }
    }

    @Test
    void get() {
        log.info(service.get(1L));
    }

    @Test
    public void create() {
        BoardDTO board = new BoardDTO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user1");
        service.create(board);
        log.info("생성된 게시물의 번호 : " + board.getNo());
    }

    @Test
    public void update() {
        BoardDTO board = service.get(1L);
        board.setTitle("제목 수정합니다.");
        log.info("update RESULT : " + service.update(board));
    }

    @Test
    public void delete() {
        // 게시물 번호 존재 여부 확인 후 테스트
        log.info("delete RESULT : " + service.delete(2L));
    }
}