/**
 * 
 */
package org.cybercafe.service;

/**
 * @author Bablu
 *
 */
public interface JWTService {
	public String encode(String payload, String secret);
}
