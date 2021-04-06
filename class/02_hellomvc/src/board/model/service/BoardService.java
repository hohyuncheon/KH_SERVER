package board.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.exception.BoardException;
import board.model.vo.Board;
import member.model.vo.Member;

public class BoardService {
	
	
	
	private BoardDao boardDao = new BoardDao();

	public List<Board> selectList(int start, int end) {
		Connection conn = getConnection();
		List<Board> list = boardDao.selectList(conn, start, end); // dao 요청
		close(conn); // 자원반납
		return list;
	}

	public int selectBoardCount() {
		Connection conn = getConnection();
		int totalContents = boardDao.selectBoardCount(conn);
		close(conn);
		return totalContents;
	}

	
	/*
	 * 첨부파일이 있는경우, attach객체를 attachment테이블에 등록한다.
	 * -board등록, attachment 등록은 하나의 트랜잭션으로 처리되어야 한다.
	 * - 하나의 Connection에 의해 처리되어야한다.
	 * 
	 */
	
	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = boardDao.insertBoard(conn, board);
			
			//생성된 board_no를 가져오기
			int boardNo = boardDao.selectLastBoardNo(conn);
			System.out.println("boardNo@service = " + boardNo);
			
			if(board.getAttach() != null) {
				//참조할 boardNo세팅
				board.getAttach().setBoardNo(boardNo);
				result = boardDao.insertAttachment(conn, board.getAttach());
			}
			commit(conn);
		} catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
			result = 0;
		} finally {			
			close(conn);
		}
		return result;
	}
	
}
