package org.zerock.w1.todo.service;

import org.zerock.w1.todo.dto.TodoDTO;
import com.sun.tools.javac.comp.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    /*register()의 경우는 새로운 TodoDTO 객체를 입력받아 확인할 수 있는 것을 목표로 작성*/
    public void register(TodoDTO todoDTO){
        System.out.println("DEBUG................"+todoDTO);
    }

    /*getList()는 10개의 TodoDTO 객체를 만들어서 반환하도록 작성*/
    public List<TodoDTO> getList(){
        List<TodoDTO> todoDTOS=IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto=new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.."+i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());
        return todoDTOS;
    }

    public TodoDTO get(Long tno){
        TodoDTO dto=new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }
}
