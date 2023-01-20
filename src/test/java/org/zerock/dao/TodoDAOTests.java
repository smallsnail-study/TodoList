package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {   // 모든 테스트 전에 TodoDAO타입의 객체를 생성한다.
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {   // TodoDAO에 작성한 getTime()이 정상 동작하는지 확인한다.
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title....")
                .dueDate(LocalDate.of(2023, 1, 19))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test   // 목록기능 구현 테스트
    public void testList() throws Exception {

        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test   // 특정번호(tno)의 데이터만 가져오는 조회 기능 구현 테스트
    public void testSelectOne() throws Exception {

        Long tno = 1L;  // 반드시 존재하는 번호를 이용, 존재하지 않는 번호의 글을 조회하면 예외발생

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    @Test   // 특정번호(tno)의 데이터 수정 기능 구현 테스트
    public void testUpdateOne() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023,1,19))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
