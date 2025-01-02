package 게시판.Service;

import java.util.List;

/* 게시판 프로그램 - 기능 메소드 
 * 게시글 목록 
 * 게시글 조회
 * 게시글 등록
 * 게시글 수정
 * 게시글 삭제
 */
public interface BoardService {
	
	//게시글 목록 (컬렉션으로 Board 전송객체를 반환할 수 있도록 작성!)
	List<Board> list();
	//게시글 조회(Board객체를 가지고 오기!)
	Board select(int no);
	//게시글 등록,데이터 베이스에 지정된 갯수를 반환!
	//Board 파일에 있는 내용을 insert함!
	int insert(Board board);
	//게시글 수정
	int update(Board board);
	//게시글 삭제
	int delete(int no);
}
