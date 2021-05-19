package com.atb.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class KeyKeeper {

	private static Cipher cipher;
	
	public static void init() {
		KeyGenerator kg;
		try {
			kg = KeyGenerator.getInstance("AES");

			kg.init(new SecureRandom(new byte[] { 3, 5, 7 }));
			final SecretKey key = kg.generateKey();
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			System.out.println("Specified Padding does not exist");
		} catch (InvalidKeyException e) {
			System.out.println("Specified key is invalid");
		}
	}

	public static Cipher getCipher() {
		return cipher;
	}
	
}
