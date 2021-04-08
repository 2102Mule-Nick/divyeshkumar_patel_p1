package com.freelancer.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.freelancer.exception.SkillDoesNotExist;
import com.freelancer.pojo.Skills;

@WebService
public interface SkillsService {

	@WebMethod
	public Skills createSkill(String skillName);

	@WebMethod
	public Skills getSkillByName(String skillName) throws SkillDoesNotExist;

}
