/**
 * 
 */
package org.cybercafe.service;

import org.springframework.util.Base64Utils;

/**
 * @author Bablu
 *
 */
public class JWTServiceImpl implements JWTService {
	
	private static final String ALGORITHM = "HS256";
	
	private static final String HEADER = "typ: " + "'JWT'" + "alg : '" + ALGORITHM + "'";  

	@Override
	public String encode(String payload, String secret) {
		String jwt = base64Encode(HEADER) + "." + base64Encode(payload);
		return  jwt;
	}
	
	private String base64Encode(String input){
		return Base64Utils.encodeToString(input.getBytes());
	}
	
	

}
