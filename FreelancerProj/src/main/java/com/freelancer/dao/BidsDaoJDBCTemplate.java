package com.freelancer.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.freelancer.dao.mapper.BidsRowMapper;
import com.freelancer.dao.mapper.ProjectRowMapper;
import com.freelancer.pojo.Bids;
import com.freelancer.pojo.Project;

@Repository
public class BidsDaoJDBCTemplate implements BidsDao {

	private JdbcTemplate jdbcTemplate;

	private ProjectRowMapper projectRowMapper;

	private BidsRowMapper bidsRowMapper;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setProjectRowMapper(ProjectRowMapper projectRowMapper) {
		this.projectRowMapper = projectRowMapper;
	}

	@Autowired
	public void setBidsRowMapper(BidsRowMapper bidsRowMapper) {
		this.bidsRowMapper = bidsRowMapper;
	}

	@Override
	public Bids createBid(Bids bids) {
	String sql="insert into bids (project_id,user_id, amt, message) values (?,?,?,?)";
	KeyHolder keyHolder = new GeneratedKeyHolder();
	
	jdbcTemplate.update(connection ->{
		PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1,bids.getProjectId());
		ps.setInt(2,bids.getUserId());
		ps.setInt(3,bids.getAmount());
		ps.setString(4, bids.getMessage());
		return ps;
		
	},keyHolder);
	bids.setBidId((int) keyHolder.getKeys().get("bid_id"));
		return bids;
	}

	@Override
	public Bids getBidByID(int id) {
		String sql = "select * from bids where bid_id = ?";
		List<Bids> bidList = jdbcTemplate.query(sql, bidsRowMapper,id);
		
		String sql2="select * from freelancer_bids b join freelancer_projects fp on b.project_id = fp.project_id where b.bid_id =?";
		
		Bids bids = bidList.get(0);
		List<Project> projectList= jdbcTemplate.query(sql2, projectRowMapper,id);
		bids.setProjects(projectList);
		
		
		return bids;
	}

	@Override
	public void removeBid(int id) {
		String sql = "delete from freelancer_bids where bid_id =?";
		jdbcTemplate.update(sql,id);

	}

	@Override
	public void updateCart(Bids bids) {
	

	}

	@Override
	public Bids addProjectToBid(Bids bids, Project project, int amt, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bids> getAllBids() {
		String sql = "select * from freelancer_bids";
		List<Bids> bidList = jdbcTemplate.query(sql, bidsRowMapper);
		String sql2="select * from freelancer_bids b join freelancer_projects fp on b.project_id = fp.project_id where b.bid_id =?";
bidList.forEach((bid)->{
	List<Project> projectList= jdbcTemplate.query(sql2, projectRowMapper,bid.getBidId());
	bid.setProjects(projectList);
});


		return bidList;
	}

}
