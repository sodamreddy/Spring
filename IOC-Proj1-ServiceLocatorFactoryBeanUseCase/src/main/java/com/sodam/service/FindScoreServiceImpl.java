package com.sodam.service;

import com.sodam.external.ICCScoreComp;


public class FindScoreServiceImpl implements FindScoreService {
	private ICCScoreComp extComp;

	public FindScoreServiceImpl(ICCScoreComp extComp) {
		this.extComp = extComp;
	}

	@Override
	public String findScore(int matchId) throws Exception {
			String score =null;
			score=extComp.getScore(matchId);
		return score;
	}

}
