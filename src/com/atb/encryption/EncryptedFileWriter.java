package com.atb.encryption;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.crypto.CipherOutputStream;

public class EncryptedFileWriter {
	

	private CipherOutputStream output     = null;
	private FileOutputStream   fileOutput = null;
	private PrintWriter pw = null;
	
	public EncryptedFileWriter(String fileName) {
		try {
			fileOutput = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output = new CipherOutputStream(fileOutput, KeyKeeper.getCipher());
	    pw = new PrintWriter(output);
	}
	
	public void appendTransactionToFile(String transaction) {
		System.out.println("transaction : " + transaction);
		pw.write(transaction);
		pw.flush();

	}
	
	public void close() {
		try {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
			if (fileOutput != null) {
				fileOutput.flush();
				fileOutput.close();
			}
			if (output != null) {
				output.flush();
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
