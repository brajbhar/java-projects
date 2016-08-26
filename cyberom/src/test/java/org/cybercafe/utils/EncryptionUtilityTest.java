/**
 * 
 */
package org.cybercafe.utils;



import java.security.NoSuchAlgorithmException;

import org.cybercafe.AbstractRepositoryTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Bablu Rajbhar
 *
 */
public class EncryptionUtilityTest extends AbstractRepositoryTest{
	
	@Test
	public void testEncrypt() throws NoSuchAlgorithmException {
		String plainText = "plain";
		String expectedEncryptedText = "ac7938d40cfc2307e2bf325d28e7884e";
		String actualEncryptedText = EncryptionUtils.encrypt(plainText);
		Assert.assertEquals("Encrypted text not matching with expected", 
				expectedEncryptedText, actualEncryptedText);
		
	}
}
