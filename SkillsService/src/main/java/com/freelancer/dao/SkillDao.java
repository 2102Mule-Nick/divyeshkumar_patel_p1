package com.freelancer.dao;

import com.freelancer.pojo.Skills;

public interface SkillDao {
	
	public Skills readSkillByName(String skillName);
	
	public Skills addSkill(String skillName);

}
