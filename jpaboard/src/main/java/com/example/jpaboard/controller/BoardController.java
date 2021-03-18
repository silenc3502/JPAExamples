package com.example.jpaboard.controller;

import com.example.jpaboard.domain.Board;
import com.example.jpaboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
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
