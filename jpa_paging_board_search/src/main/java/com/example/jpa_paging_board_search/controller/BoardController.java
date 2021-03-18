package com.example.jpa_paging_board_search.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.jpa_paging_board_search.domain.Board;
import com.example.jpa_paging_board_search.service.BoardService;
import com.example.jpa_paging_board_search.vo.CodeLabelValue;
import com.example.jpa_paging_board_search.vo.PageRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Board board, RedirectAttributes rttr) throws Exception {
		service.register(board);

		rttr.addFlashAttribute("msg", "등록이 완료되었습니다.");
		
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("pgrq") PageRequestVO pageRequestVO, Model model) throws Exception {
		model.addAttribute("list", service.list(pageRequestVO));
		
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("n", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "Title"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("w", "Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "Title OR Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("cw", "Content OR Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tcw", "Title OR Content OR Writer"));

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(Long boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Long boardNo, RedirectAttributes rttr) throws Exception {
		service.remove(boardNo);

		rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(Long boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, RedirectAttributes rttr) throws Exception {
		service.modify(board);

		rttr.addFlashAttribute("msg", "수정이 완료되었습니다.");

		return "redirect:/board/list";
	}
	
}
