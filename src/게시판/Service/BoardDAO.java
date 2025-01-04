package 게시판.Service;


import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import 게시판.DAO.JDBConnection;
/*데이터 접근 객체
 * - 게시글 데이터를 접근
 */
public class BoardDAO extends JDBConnection {
	/*데이터 목록
	 * @return
	 */
	public List<Board> list() {
		//게시글 목록을 담을 컬렉션 객체 생성
		List<Board> boardList =  new ArrayList<Board>();
		//SQL작성
		String sql = "SELECT *"
				+"FROM board";
		
		try {
			//1. SQL명령어 실행 할 객체를 생성 - Statement (stmt)
			stmt = con.createStatement();
			//2.이 객체로부터 SQL실행 요청 -> 결과 ResultSet (rs)
			rs=stmt.executeQuery(sql);
			 //3. 조회된 결과를 받아와서 리스트(boardList)에다가 결과 담기!
			while(rs.next()) {  // next() : 실행결과의 다음 데이터를 가져옴!
				Board board = new Board();
				//결과 데이터 가져오기
				//rs.getXXX("컬럼명") : 해당 컬럼의 데이터를 반환!
				board.setNO(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getTimestamp("reg_date"));
				board.setUpdDate(rs.getTimestamp("upd_date"));
				
				//게시글 목록 추가
				boardList.add(board);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 //4. 게시글 목록 반환
		 
		return null;
	}
	//데이터 조회 select
	public Board select(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

}
