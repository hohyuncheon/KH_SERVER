package com.kh.mybatis.student.model.service;

import static com.kh.mybatis.common.MybatisUtils.getSqlSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.student.model.dao.StudentDao;
import com.kh.mybatis.student.model.dao.StudentDaoImpl;
import com.kh.mybatis.student.model.vo.Student;


//여기가두번째
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();

	@Override
	public int insertStudent(Student student) {
		//1. SqlSession 생성
		SqlSession session = getSqlSession();
		int result = 0;
		try {
			//2. dao 업무위임
			result = studentDao.insertStudent(session, student);
			//3. transaction 처리: SqlSession에 대해서 commit|rollback
			session.commit();
		} catch(Exception e) {
			session.rollback();
			throw e;
		} finally {
			//4. SqlSession 자원반납 
			session.close();
		}
		return result;
	}

	@Override
	public int insertStudentMap(Map<String, Object> student) {
		int result = 0;
		SqlSession session = getSqlSession();
		try {
			result = studentDao.insertStudentMap(session, student);
			session.commit();
			
		} catch (Exception e) {
			session.rollback();
			throw e;
		}finally {
			session.close();
		}
		
		return result;
	}

	//카운트기능
	@Override
	public int selectStudentCount() {
		
		SqlSession session = getSqlSession();
		int total = studentDao.selectStudentCount(session);
		session.close();
		
		return total;
	}

	//한명조회
	@Override
	public Student selectOneStudent(int no) {
		SqlSession session = getSqlSession();
		Student student = studentDao.selectOneStudent(session, no);
		session.close();
		
		return student;
	}

	
	
	@Override
	public Map<String, Object> selectOneStudentMap(int no) {
		SqlSession session = getSqlSession();
		Map<String, Object> student = studentDao.selectOneStudentMap(session, no);
		session.close();
		
		
		
		return student;
	}

	
	//update
	@Override
	public int updateStudent(Student student) {
		
		
		//1. SqlSession 생성
		SqlSession session = getSqlSession();
		int result = 0;
		try {
			//2. dao 업무위임
			result = studentDao.updateStudent(session, student);
			//3. transaction 처리: SqlSession에 대해서 commit|rollback
			session.commit();
		} catch(Exception e) {
			session.rollback();
			throw e;
		} finally {
			//4. SqlSession 자원반납 
			session.close();
		}
		return result;
	}

	
	//delete
	@Override
	public int deleteStudent(Student student) {
		
		//1. SqlSession 생성
		SqlSession session = getSqlSession();
		int result = 0;
		try {
			//2. dao 업무위임
			result = studentDao.deleteStudent(session, student);
			//3. transaction 처리: SqlSession에 대해서 commit|rollback
			session.commit();
		} catch(Exception e) {
			session.rollback();
			throw e;
		} finally {
			//4. SqlSession 자원반납 
			session.close();
		}
		return result;
	}
	
	
	
	
	
	
	

	
	
}
