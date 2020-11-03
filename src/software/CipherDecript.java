package software;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;

import javax.crypto.Cipher;

public class CipherDecript {
	
	//java codes
	static {
		System.out.println("Enter the message:");
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		Signature.getInstance("SHA256withRSA");
		
		//Creating KeyPair generator object
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		
		//Initializing the key pair generator
		keyPairGen.initialize(2048);
		
		//Generate the pair of keys
		KeyPair pair = keyPairGen.generateKeyPair();
		
		//Getting the public key from the key pair
		PublicKey publicKey = pair.getPublic();
		
		//Creating a Cipher object
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		
		//Initializing a Cipher object
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		
		//Add data to the cipher
		byte[] input = scanner.nextLine().getBytes();
		cipher.update(input);
		
		//encrypting the data
		byte[] cipherText = cipher.doFinal();
		System.out.println("Encripted Message: ");
		System.out.println(new String(cipherText, "UTF8"));
		
		//Initializing the same cipher for decryption
		cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
		
		//Decrypting the text
		byte[] decipheredText = cipher.doFinal(cipherText);
		System.out.println("Decripted Message: ");
		System.out.println(new String(decipheredText));
	}
	
}
