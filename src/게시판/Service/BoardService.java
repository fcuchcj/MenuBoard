package 게시판.Service;
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
	//게시글 조회
}
