package edu.kh.music.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.music.board.exception.BoardInserException;
import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.dto.BoardImg;
import edu.kh.music.board.model.mapper.EditBoardMapper;
import edu.kh.music.common.util.Utility;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor=Exception.class)
@RequiredArgsConstructor
@PropertySource("classpath:/config.properties")
public class EditBoardServiceImpl implements EditBoardService {

	private final EditBoardMapper mapper;
	
	@Value("${my.board.web-path}")
	private String webPath; 
	
	@Value("${my.board.folder-path}")
	private String folderPath;
	
	
	@Override
	public int boardInsert(Board inputBoard, List<MultipartFile> images) throws IllegalStateException, IOException {
		
		int result = mapper.boardInsert(inputBoard);
		
		if(result == 0) return 0;
		
		//-----------------------------------------------------------------
		
		int boardNo = inputBoard.getBoardNo();
		
		List<BoardImg> uploadList = new ArrayList<>();
		
		for(int i=0; i<images.size(); i++) {
			
			if(!images.get(i).isEmpty()) {
				
				String originalName = images.get(i).getOriginalFilename();
				String rename = Utility.fileRename(originalName);
				
				BoardImg img = BoardImg.builder()
								.imgOriginalName(originalName)
								.imgRename(rename)
								.imgPath(webPath)
								.boardNo(boardNo)
								.imgOrder(i)
								.uploadFile(images.get(i))
								.build();
				uploadList.add(img);
			}
			
		}
		
		if(uploadList.isEmpty()) {
			return boardNo;
		}
		//-----------------------------------------------------------------------
		result = mapper.insertUploadList(uploadList);
		
		
			if(result == uploadList.size()) {
				for( BoardImg img : uploadList) {
					img.getUploadFile().transferTo(new File(folderPath + img.getImgRename()));
				}
			}else {
				throw new BoardInserException("이미지가 정상 삽입되지 않음");
			}
		
		return boardNo;
	}
	
	
	// 게시글 삭제
	@Override
	public int deleteBoard(Board board) {
		return mapper.deleteBoard(board);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
