package org.zerock.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService=TodoService.INSTANCE;
    }

    @Test
    public void testRegister()throws Exception{
        TodoDTO todoDTO=TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .build();


        log.info("--------------------------");//테스트 코드의 log4j2 설정 확인
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
