package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import member.model.dao.MemberDao;
import member.model.vo.Member;
public class MemberService {

	private MemberDao memberDao = new MemberDao();

	
	public static final String MEMBER_ROLE = "U";
	public static final String ADMIN_ROLE = "A";
	
	
	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		Member member = memberDao.selectOne(conn, memberId);
		close(conn);
		return member;
	}
	
	
	
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.insertMember(conn, member);
		if(result > 0) 
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}



	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.updateMember(conn, member);
		if(result > 0) 
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}



	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = memberDao.deleteMember(conn, memberId);
		if (result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}



	public List<Member> selectList() {
		Connection conn = getConnection();
		List<Member> list = memberDao.selectList(conn); // dao 요청
		close(conn); // 자원반납
		return list;
	}
	
	//페이징구현
	public List<Member> selectList(int start, int end) {
		Connection conn = getConnection();
		List<Member> list = memberDao.selectList(conn, start, end); // dao 요청
		close(conn); // 자원반납
		return list;
	}


	//role 변경
	public int updateMemberRole(Member member) {
		Connection conn = getConnection();
		int result = memberDao.updateMemberRole(conn, member);
		if(result > 0) 
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}



	public List<Member> searchMember(Map<String, String> param) {
		Connection conn = getConnection();
		List<Member> list = memberDao.searchMember(conn ,param); // dao 요청
		close(conn); // 자원반납
		return list;
	}


	public int selectMemberCount() {
		Connection conn = getConnection();
		int totalContents = memberDao.selectMemberCount(conn);
		close(conn);
		return totalContents;
	}



	
}