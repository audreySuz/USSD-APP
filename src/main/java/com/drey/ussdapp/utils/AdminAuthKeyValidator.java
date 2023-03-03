package com.drey.ussdapp.utils;

import com.drey.ussdapp.exceptions.ForbiddenException;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAuthKeyValidator {

	private final PropertySourceResolver propertySourceResolver;

	public boolean validateAdminAuthKey(String adminAuthKey) {
		if (adminAuthKey == null || StringUtils.isBlank(adminAuthKey)) {
			throw new ForbiddenException("Invalid USSD APP Admin Token");
		}

		if (adminAuthKey != null) {
			if (!adminAuthKey.trim().equalsIgnoreCase(propertySourceResolver.getVasAdminAuthKey())) {
				throw new ForbiddenException("Invalid USSD APP Admin Token");
			} else {
				return true;
			}
		}
		throw new ForbiddenException("Invalid USSD APP Admin Token");
	}

	public boolean validateUserAuthKey(String userAuthKey) {
		if (userAuthKey == null || StringUtils.isBlank(userAuthKey)) {
			throw new ForbiddenException("Invalid Agent User Authkey");
		}

		if (userAuthKey != null) {
			if (!userAuthKey.trim().equalsIgnoreCase(propertySourceResolver.getAgentUserAuthKey())) {
				throw new ForbiddenException("Invalid Agent User Authkey");
			} else {
				return true;
			}
		}
		throw new ForbiddenException("Invalid Agent User Authkey");
	}
}
