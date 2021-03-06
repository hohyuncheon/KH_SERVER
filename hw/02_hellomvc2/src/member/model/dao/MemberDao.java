package member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static common.JDBCTemplate.*;

import member.model.service.MemberService;
import member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Member selectOne(Connection conn, String memberId) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//미완성 쿼리문 값대입
			pstmt.setString(1, memberId);
			//쿼리문실행
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberRole(rset.getString("member_role"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return member;

	}
	
	
	/**
	 * 회원추가
	 */
	public int insertMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
		
		try {
			//PreparedStatment객체 생성, 미완성 쿼리 값대입
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,m.getMemberId());
			pstmt.setString(2,m.getPassword());
			pstmt.setString(3,m.getMemberName());
			pstmt.setString(4,m.getMemberRole()); //상수 MemberRole,기본값 U
			pstmt.setString(5,m.getGender());
			pstmt.setDate(6,m.getBirthday());
			pstmt.setString(7,m.getEmail());
			pstmt.setString(8,m.getPhone());
			pstmt.setString(9,m.getAddress());
			pstmt.setString(10,m.getHobby());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	
	//회원정보 수정
	
	public int updateMember(Connection conn, Member member) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = prop.getProperty("updateMember");
			int result = 0;
			System.out.println(query + "이게쿼리");
//			update member set password =?, where member_name = ?, birthday = ?, email =?,  phone =?, address =?, gender =?, hobby =?, where member_id = ?
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member.getPassword());
				pstmt.setString(2, member.getMemberName());
				pstmt.setDate(3, member.getBirthday());
				pstmt.setString(4, member.getEmail());
				pstmt.setString(5, member.getPhone());
				pstmt.setString(6, member.getAddress());
				pstmt.setString(7, member.getGender());
				pstmt.setString(8, member.getHobby());
				pstmt.setString(9, member.getMemberId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}



	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
}