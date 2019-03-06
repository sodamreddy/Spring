package com.sodam.external;

public class ICCScoreComImpl implements ICCScoreComp {

	@Override
	public String getScore(int matchId) throws Exception {
		//returns match score based on match id
		if(matchId==1001) {
			return "IND VS AUS Score IND 140/1";
		}
		else if(matchId==1002) {
			return "SA VS WI Score SA 200/4";
		}
		else
			return "Invalid Match";
	}
	

}
