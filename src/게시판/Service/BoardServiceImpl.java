package 게시판.Service;

import java.util.List;

/* 게시판 기능 - 비즈니스 로직 클래스
 */
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO = new BoardDAO();
	
	@Override
	public List<Board> list() {
		/*게시글 목록에서는, DAO(data access object)를 통해서
		 * 게시글 목록 호출! => List<Board>형식으로 받아옴!
		 * 받아온 것을 게시글 목록 데이터로 반환!
		 */
		List<Board> boardList = boardDAO.list();
		//아직boardDAO.list는 정의 안 되었다!
		return null;
	}

	@Override
	public Board select(int no) {
		//1. 게시글 번호 no를 DB로 넘겨주고 게시글 정보 요청!
		Board board = boardDAO.select(no);
		//게시글 정보 반환
		return board;
	}

	//insert는 데이터 등록!
	public int insert(Board board) {
		//매개변수를 통해, 게시글 정보를 전달하여, Db에 데이터 등록 요청
		int result = boardDAO.insert(board);
		//반환된 값은 적용된 데이터 개수를 반환!
		/* result(결과) : 0 --> 데이터 등록 실패
		 * 				 1 --> 데이터 등록 성공
		 */
		if(result > 0) System.out.println("데이터 등록 성공!");
		else System.out.println("데이터 등록 실패!");
		//출력문이 1개일 때는 중괄호를 칠 필요가 없음!
		return result;
	}

	@Override
	public int update(Board board) {
		//매개변수를 통해, 게시글 정보를 전달하여, Db에 데이터 등록 요청
		int result = boardDAO.update(board);
		//반환된 값은 적용된 데이터 개수를 반환!
		/* result(결과) : 0 --> 데이터 등록 실패
		 * 				 1 --> 데이터 등록 성공
		 */
		if(result > 0) System.out.println("데이터 수정 성공!");
		else System.out.println("데이터 수정 실패!");
		//출력문이 1개일 때는 중괄호를 칠 필요가 없음!
		return result;
	}

	@Override
	public int delete(int no) {
		//매개변수를 통해, 게시글 정보를 전달하여, Db에 데이터 등록 요청
		//삭제는 객체가 다 안 넘어가고, 게시글 번호로 삭제 가능!
		int result = boardDAO.delete(no);
		//반환된 값은 적용된 데이터 개수를 반환!
		/* result(결과) : 0 --> 데이터 삭제 실패
		 * 				 1 --> 삭제 수정 성공
		 */
		if(result > 0) System.out.println("데이터 삭제 성공!");
		else System.out.println("데이터 삭제 실패!");
		//출력문이 1개일 때는 중괄호를 칠 필요가 없음!
		return result;
	}

}
