package com.example.jpaboard.service;

import java.util.List;

import com.example.jpaboard.domain.Board;
import com.example.jpaboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;

	@Override
	@Transactional
	public void register(Board board) throws Exception {
		repository.save(board);
	}

	@Override
	@Transactional(readOnly = true)
	public Board read(Long boardNo) throws Exception {
		return repository.getOne(boardNo);
	}

	@Override
	@Transactional
	public void modify(Board board) throws Exception {
		Board boardEntity = repository.getOne(board.getBoardNo());

		boardEntity.setTitle(board.getTitle());
	}

	@Override
	@Transactional
	public void remove(Long boardNo) throws Exception {
		repository.deleteById(boardNo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Board> list() throws Exception {
		return repository.findAll(Sort.by(Direction.DESC, "boardNo"));
	}
	
}
