package in.nitish.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import in.nitish.service.EncService;

@Service
public class EncServiceImpl implements EncService {

	@Override
	public String encrypt(String data) {

		try {
			// Generate a random 16-byte key (128 bits)
			String secretKey = "abcdefghijklmnop";
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

			// Generate a random 16-byte initialization vector (IV)
			String initializationVector = "1234567890123456";
			IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector.getBytes("UTF-8"));
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return data;
		}

	}

	@Override
	public String decrypt(String data) {

		try {
			System.out.println("=== Inside try ===");

			// Generate a random 16-byte key (128 bits)
			String secretKey = "abcdefghijklmnop";
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

			// Generate a random 16-byte initialization vector (IV)
			String initializationVector = "1234567890123456";
			IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector.getBytes("UTF-8"));

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE,secretKeySpec, ivParameterSpec);
			byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(data));
			return new String(decryptedBytes, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
			return data;
		}

		
	}

}
