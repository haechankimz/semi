package edu.kh.music.board.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.music.board.model.dto.Board;

public interface EditBoardService {

	// 게시글 작성
	int boardInsert(Board inputBoard, List<MultipartFile> images) throws IllegalStateException, IOException;

}
