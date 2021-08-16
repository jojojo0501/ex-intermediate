package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム情報を操作するサービス.
 * @author kanekojota
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 *チーム情報を全件取得する.
	 * @return 全チームの情報
	 */
	public List<Team> showList(){
		return teamRepository.findAll();
	}
}
