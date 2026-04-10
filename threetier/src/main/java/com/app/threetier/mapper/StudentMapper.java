package com.app.threetier.mapper;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /* 학생 추가 */
    public void insert(StudentVO studentVO);

    /* 학생 전체 조회 */
    public List<StudentDTO> selectAll();

    /* 학생 단일 조회 */
    // (회사마다 사바사) 단일 조회 Optional은 DAO에서 자바 객체 지향으로 바꾸고 나서 사용된다
    // Mapper는 RDB중심으로 설계되어 자바 객체로 사용이 잘 되진 않는다.
    // [강사님 피셜 : Optional은 서비스에서 감싼다]
    public StudentDTO select(Long id);

    /* 학생 정보 수정 */
    public void update(StudentVO studentVO);

    /*학생 정보 삭제*/
    public void delete(Long id);

}
