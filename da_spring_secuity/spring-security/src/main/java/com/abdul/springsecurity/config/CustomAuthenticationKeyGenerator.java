package com.abdul.springsecurity.config;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;

public class CustomAuthenticationKeyGenerator implements AuthenticationKeyGenerator {
	private static final String CLIENT_ID = "client_id";
	private static final String SCOPE = "scope";
	private static final String USERNAME = "username";
	private static final String DEVICE_ID="device_id";

	Logger logger = LogManager.getLogger(CustomAuthenticationKeyGenerator.class);
	@Override
	public String extractKey(OAuth2Authentication authentication) {
		String extractKey="";
		try {
			Map<String, String> values = new LinkedHashMap<String, String>();
			OAuth2Request authorizationRequest = authentication.getOAuth2Request();
			if (!authentication.isClientOnly()) {
				values.put(USERNAME, authentication.getName());
			}
			values.put(CLIENT_ID, authorizationRequest.getClientId());
			if (authorizationRequest.getScope() != null) {
				values.put(SCOPE, OAuth2Utils
						.formatParameterList(authorizationRequest.getScope()));
			}
			String deviceId = authorizationRequest.getRequestParameters().get(DEVICE_ID);
			if (deviceId != null && !deviceId.isEmpty()) {
				values.put(DEVICE_ID, deviceId);
			}
			MessageDigest digest;
			
			digest = MessageDigest.getInstance("MD5");
		
			byte[] bytes = digest.digest(values.toString().getBytes("UTF-8"));
			extractKey= String.format("%032x", new BigInteger(1, bytes));
		}catch (Exception e) {
			logger.error("Exception in CustomAuthenticationKeyGenerator");
			e.printStackTrace();
		}
		return extractKey;
	}
}