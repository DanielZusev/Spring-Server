package acs.converter;

import acs.UserId;
import acs.boundary.UserBoundary;
import acs.data.UserEntity;

public class UserEntityConverter {
	
	public UserBoundary fromEntity(UserEntity userEntity) {
		UserId userId;
		
		if(userEntity.getUserId() != null) 
		{
			String[] userIdPart = userEntity.getUserId().split("@@");
			userId = new UserId(userIdPart[0], userIdPart[1]);
		}
		else
			userId = null;
		
		
		return new UserBoundary(
				userEntity.getRole(),
				userEntity.getUserName(),
				userId,
				userEntity.getAvatar());	
	}
	
	public UserEntity toEntity(UserBoundary userBoundary) {
		
		UserEntity userEntity = new UserEntity();
		
		if(userBoundary.getUserId() != null) 
			userEntity.setUserId(userBoundary.getUserId().getDomain() + "@@" + userBoundary.getUserId().getEmail());
		else
			userEntity.setUserId("@@");
		
		userEntity.setUserName(userBoundary.getUserName());
		userEntity.setAvatar(userBoundary.getAvatar());
		userEntity.setRole(userBoundary.getRole());
		
		return new UserEntity();
	}

}