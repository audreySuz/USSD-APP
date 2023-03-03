package com.drey.ussdapp.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PropertySourceResolver {


	@Value("${ussdapp.admin.authKey}")
	private String vasAdminAuthKey;

	@Value("${agent.user.authKey}")
	private String agentUserAuthKey;
}
