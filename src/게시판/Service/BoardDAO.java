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
		//게시글 정보 객체 생성
		Board board = new Board();
		//SQL작성
		String sql = "SELECT *"
					+"FROM board"
					+"WHERE no =?"; //no가 ?인 데이터만 조회
		// = ? 이것은 조건을 부여하는 느낌!
		//데이터 조회하는 프로세스: SQL 실행 객체 생성 -> SQL 실행 요청 -> 조회결과 -> 반환
		try {
			//SQL 실행 객체 생성 - PreparedStatement (psmt)
			psmt = con.prepareStatement(sql);
			// ? 동적 피라미터 바인딩 
			// * psmt.setXXX(순서번호,매핑할 값);
			psmt.setInt(1,no);	//1번째 ? 피라미터에 매핑
			/* SELECT from board where no = ? 여기 문장의 
			 * ? 값에 no를 대입 (바인딩!)
			 */
			
			//SQL실행 요청
			rs=psmt.executeQuery();
			//조회 결과 1건 가져오기
			if(rs.next()) {
				board.setNO(rs.getInt("no"));
			}
		} catch (SQLException e) {
			
		}
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
