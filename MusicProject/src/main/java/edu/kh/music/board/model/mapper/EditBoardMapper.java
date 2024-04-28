package edu.kh.music.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.dto.BoardImg;

@Mapper
public interface EditBoardMapper {

	// 게시글 작성
	int boardInsert(Board inputBoard);

	// 게시글 모두 삽입
	int insertUploadList(List<BoardImg> uploadList);

}
