package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

/**
 * チーム情報を操作するコントローラー.
 * @author kanekojota
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	/**
	 * 全チーム一覧を表示する.
	 * @param model 全チーム一覧をリクエストスコープに格納する
	 * @return チームリスト一覧ページへフォワード
	 */
	@RequestMapping("/list")
	public String showList(Model model) {
		model.addAttribute("teamList", teamService.showList());
		return "team-list";
	}
}
