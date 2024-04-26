package edu.kh.music.board.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.music.board.model.mapper.EditBoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EditBoardServiceImpl implements EditBoardService {

	private final EditBoardMapper mapper;
}
