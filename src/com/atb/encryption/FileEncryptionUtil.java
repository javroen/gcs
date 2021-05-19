package com.atb.encryption;

import java.io.IOException;

public class FileEncryptionUtil {
	
	public static void main(String argss[]) {
		KeyKeeper.init();
		
		EncryptedFileWriter writer = new EncryptedFileWriter("transactionreport.csv");
		
		writer.appendTransactionToFile("bla bla bla bla bla bla bla");
		writer.close();
		
		EncryptedFileReader reader = new EncryptedFileReader("transactionreport.csv");
		try {
			reader.downloadTransactionReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.close();
	}
	
}
