package edu.kh.music.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.music.board.model.dto.Board;

public interface EditBoardService {

	// 게시글 작성
	int boardInsert(Board inputBoard, List<MultipartFile> images) throws IllegalStateException, IOException;

	// 게시글 삭제
	int deleteBoard(Board board);

	// 게시글 수정
	int boardUpdate(Board inputBoard, List<MultipartFile> images, String deleteOrder)  throws IllegalStateException, IOException;


}
