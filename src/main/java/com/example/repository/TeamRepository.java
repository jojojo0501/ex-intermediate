package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * Teamsテーブルを操作するリポジトリ.
 * @author kanekojota
 *
 */
@Repository
public class TeamRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Team> TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);
	
	/**
	 * 全件検索を行う.
	 * @return 全チーム一覧
	 */
	public List<Team> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT id,league_name,team_name,headquarters,inauguration,history");
		sql.append(" FROM teams ORDER BY inauguration ASC;");
		List<Team> teamList = template.query(sql.toString(),TEAM_ROW_MAPPER);
		return teamList;
	}
}

