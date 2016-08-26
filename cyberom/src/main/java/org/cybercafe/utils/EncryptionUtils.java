/**
 * 
 */
package org.cybercafe.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Bablu Rajbhar
 *
 *
 */
public class EncryptionUtils {

	public static String encrypt(String plainText) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(plainText.getBytes());
        return getEncryptedStringFromMessageDigest(md); 
	}

	private static String getEncryptedStringFromMessageDigest(
			MessageDigest md) {
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	
}
