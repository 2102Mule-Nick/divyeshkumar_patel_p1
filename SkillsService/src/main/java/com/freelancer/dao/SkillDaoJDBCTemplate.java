package com.freelancer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.freelancer.pojo.Skills;


@Repository
public class SkillDaoJDBCTemplate implements SkillDao {

	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcInsert simpleJdbcInsert;

	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setSimpleJdbcInsert(SimpleJdbcInsert simpleJdbcInsert) {
		this.simpleJdbcInsert = simpleJdbcInsert;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Skills readSkillByName(String skillName) {
		String sql = "select * from skills where skill_name=?";
		List<Skills> skillList = jdbcTemplate.query(sql,
				(rs, id) -> new Skills(rs.getInt("skills_id"), rs.getString("skill_name")), skillName);

		if (skillList.size() > 0) {
			return skillList.get(0);
		}

		return null;
	}

	@Override
	public Skills addSkill(String skillName) {
		if (simpleJdbcInsert == null) {
			simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("skills")
					.usingGeneratedKeyColumns("skills_id");

		}
		Map<String, Object> fields = new HashMap<>();
		fields.put("skill_name", skillName);
		return new Skills((int)simpleJdbcInsert.executeAndReturnKey(fields), skillName);

	}

}
