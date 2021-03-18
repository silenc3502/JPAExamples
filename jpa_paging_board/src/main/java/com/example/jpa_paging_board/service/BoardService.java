package com.example.jpa_paging_board.service;

import com.example.jpa_paging_board.domain.Board;
import com.example.jpa_paging_board.vo.PageRequestVO;
import org.springframework.data.domain.Page;

public interface BoardService {

	public void register(Board board) throws Exception;

	public Board read(Long boardNo) throws Exception;

	public void modify(Board board) throws Exception;

	public void remove(Long boardNo) throws Exception;

	public Page<Board> list(PageRequestVO pageRequestVO) throws Exception;
	
}
