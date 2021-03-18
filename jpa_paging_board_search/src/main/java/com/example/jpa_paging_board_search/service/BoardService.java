package com.example.jpa_paging_board_search.service;

import com.example.jpa_paging_board_search.domain.Board;
import com.example.jpa_paging_board_search.vo.PageRequestVO;

import java.util.List;

public interface BoardService {

	public void register(Board board) throws Exception;

	public Board read(Long boardNo) throws Exception;

	public void modify(Board board) throws Exception;

	public void remove(Long boardNo) throws Exception;

	public List<Board> list(PageRequestVO pageRequestVO) throws Exception;
	
}
