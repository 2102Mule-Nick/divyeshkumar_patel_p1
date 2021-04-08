package com.freelancer.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelancer.dao.SkillDao;
import com.freelancer.exception.SkillDoesNotExist;
import com.freelancer.pojo.Skills;

@WebService(endpointInterface = "com.freelancer.ws.SkillsService",serviceName = "skillsServiceImpl")
public class SkillsServiceImpl implements SkillsService  {

	private SkillDao skillDao;
	
	@Autowired
	public void setSkillDao(SkillDao skillDao) {
		this.skillDao = skillDao;
	}

	//creates a new skill in the DB
	@Override
	public Skills createSkill(String skillName) {
	return skillDao.addSkill(skillName);
		
	}

	//retrieves skills info by the name of the skill
	@Override
	public Skills getSkillByName(String skillName) throws SkillDoesNotExist {
	Skills skill = skillDao.readSkillByName(skillName);
	
	if(skill==null) {
		throw new SkillDoesNotExist();
	}
		return skill;
	}

	
}
