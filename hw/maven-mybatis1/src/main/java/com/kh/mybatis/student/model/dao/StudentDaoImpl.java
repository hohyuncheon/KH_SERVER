package com.kh.mybatis.student.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.student.model.vo.Student;

//4번째
public class StudentDaoImpl implements StudentDao {

	@Override
	public int insertStudent(SqlSession session, Student student) {
		// statement : namespace.queryTagId
		return session.insert("student.insertStudent", student);
	}

	@Override
	public int insertStudentMap(SqlSession session, Map<String, Object> student) {
		
		return session.insert("student.insertStudentMap", student);
	}

	
	
	//한행을 리턴할땐 selectone 여러행은 list
	@Override
	public int selectStudentCount(SqlSession session) {
		
		return session.selectOne("student.selectStudentCount");
	}

	@Override
	public Student selectOneStudent(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudent", no);
	}

	
	/*
	 * Map<String, Object>
	 * - 컬렴명:String
	 * - 컬럼값:Object
	 */
	
	@Override
	public Map<String, Object> selectOneStudentMap(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudentMap", no);
	}

	
	
	
	
	//update
	@Override
	public int updateStudent(SqlSession session, Student student) {
		return session.update("student.updateStudent", student);
	}

	
	//delete
	@Override
	public int deleteStudent(SqlSession session, Student student) {
		return session.delete("student.deleteStudent", student);
	}
	
	
	
	
	
	
	
	
	
}
