package com.atb.encryption;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.crypto.CipherInputStream;

public class EncryptedFileReader {

	private CipherInputStream input = null;
	private FileInputStream fileInput = null;
	private BufferedReader reader = null;
	private InputStreamReader inputStreamReader = null;

	public EncryptedFileReader(String fileName) {

		try {
			fileInput = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		input = new CipherInputStream(fileInput, KeyKeeper.getCipher());

		inputStreamReader = new InputStreamReader(input);
		reader = new BufferedReader(inputStreamReader);
	}

	public void downloadTransactionReport() throws IOException {
		String line = reader.readLine();
		//while( line != null) {
		//	reader.readLine();
			System.out.println("Line : " + line);
		//}
	}

	public void close() {
		try {
			if (fileInput != null) {
				fileInput.close();
			}
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
