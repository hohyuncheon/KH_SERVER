package com.kh.mybatis.student.model.service;

import java.util.Map;

import com.kh.mybatis.student.model.vo.Student;

public interface StudentService {

	int insertStudent(Student student);

	int insertStudentMap(Map<String, Object> student);

	int selectStudentCount();

	Student selectOneStudent(int no);

	Map<String, Object> selectOneStudentMap(int no);

	int updateStudent(Student student);

	int deleteStudent(Student student);

}
