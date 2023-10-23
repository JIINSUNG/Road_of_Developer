package com.ssafy.board.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	

	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
    @PostMapping("/write")
    public String write(BoardDto boardDto, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        boardDto.setUserId(memberDto.getUserId());
        logger.debug("write boardDto : {}", boardDto);
        boardService.writeArticle(boardDto);
        redirectAttributes.addAttribute("pgno", "1");
        redirectAttributes.addAttribute("key", "");
        redirectAttributes.addAttribute("word", "");

        return "redirect:/article/list";
    }
	
    @GetMapping("/list")
    public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {

        if(!map.containsKey("pgno")) {
            map.put("pgno", "1");
        }
        if(!map.containsKey("key")) {
            map.put("key", "");
        }
        if(!map.containsKey("word")) {
            map.put("word", "");
        }

        List<BoardDto> list = boardService.listArticle(map);
        System.out.println("map = " + map);
        System.out.println("list = " + list);
        PageNavigation pageNavigation = boardService.makePageNavigation(map);
        System.out.println("pageNavigation = " + pageNavigation);
        ModelAndView mav = new ModelAndView();
        mav.addObject("articles", list);
        mav.addObject("navigation", pageNavigation);
        mav.addObject("pgno", map.get("pgno"));
        mav.addObject("key", map.get("key"));
        mav.addObject("word", map.get("word"));
        mav.setViewName("board/list");

        return mav;
    }
    
    // view 구현하기
    @GetMapping("/view")
	public String view(int articleNo, Model model) throws Exception {
		logger.info("searchBook.................................");
		logger.info("요청데이타 isbn : {}", articleNo);
		BoardDto boardDto = boardService.getArticle(articleNo);
		logger.info("search Book:{}", boardDto);
		model.addAttribute("article", boardDto);
		return "/board/view";
	}
    // 수정 구현하기 
    // modify로 간다음에 다시 view로 오는거? 
	@GetMapping("/modify")
	public String modify(int articleNo, Model model) throws Exception {
		logger.info("searchBook.................................");
		logger.info("요청데이타 isbn : {}", articleNo);
		BoardDto boardDto = boardService.getArticle(articleNo);
		logger.info("search Book:{}", boardDto);
		model.addAttribute("article", boardDto);
		return "/board/modify";
	}
	
	@GetMapping("/delete")
	public String modify(int articleNo) throws Exception 
	{
		logger.info("삭제할 책의 isbn : {}", articleNo);
		boardService.deleteArticle(articleNo);
        return "redirect:/article/list";
	}
	
    
    
}
