package backOffice.dao;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */

public class Aes 
{
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException 
	{
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	
	public static SecretKey getKeyFromPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException 
	{    
		 SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		 KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		 SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");  
		 return secret;
    }
	
	public static IvParameterSpec generateIv() 
	{
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	
	public static String encrypt(String algorithm, String input, SecretKey key,IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,BadPaddingException, IllegalBlockSizeException 
	{	    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    byte[] cipherText = cipher.doFinal(input.getBytes());
		    return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public static String decrypt(String algorithm, String cipherText, SecretKey key,IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,InvalidAlgorithmParameterException, InvalidKeyException,BadPaddingException, IllegalBlockSizeException 
	{  
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		    return new String(plainText);
	}
	public static SecretKey convertStringToSecretKeyto(String encodedKey) {
	    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
	    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
	    return originalKey;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException 
	{
		String input = "baeldung";
	    SecretKey key = convertStringToSecretKeyto("jjIvaramatserSpecIvParameterSpecIvParameterSpecIvParameterSpecIvParameterSpecIvParameterSpecIvParameterSpecencoIvParameterSpecIvParameterSpecIvParameterSpecIvParameterSpec");
		String algorithm="AES/CBC/PKCS5Padding";
		IvParameterSpec ivParameterSpec=generateIv();
		String plainText = encrypt(algorithm, "GqbjXwXSqA6NyN3kVbVNqg==", key, ivParameterSpec);
		System.out.println(plainText);
			
	}
}

