
import java.io.File;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class security {
	public static void keygen()
	{
	KeyGenerator generator;
	try{
	generator = KeyGenerator.getInstance("DES");
	generator.init(new SecureRandom());
	website.key = generator.generateKey();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public static byte[] encrypt(String message,Key key) 
	{
	// Get a cipher object.
	byte[] raw = null;
	try{
	Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	cipher.init(Cipher.ENCRYPT_MODE, key);

	// Gets the raw bytes to encrypt, UTF8 is needed for
	// having a standard character set
	byte[] stringBytes = message.getBytes("UTF8");

	// encrypt using the cypher
	raw = cipher.doFinal(stringBytes);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return raw;
	}
	public static String decrypt(byte[] raw, Key key) 
	{
		String clear =null;
		try
		{
	// Get a cipher object.
	Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	cipher.init(Cipher.DECRYPT_MODE, key);

	//decode the message
	byte[] stringBytes = cipher.doFinal(raw);

	//converts the decoded message to a String
	clear = new String(stringBytes, "UTF8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return clear;
	}
	public static Key getSecretKey()
	{
		Key key=null;
		try 
		{
		Path path = Paths.get("secretkey.txt");
		File file = new File("secretkey.txt");
		Scanner in = new Scanner(file);
		String pass = in.nextLine();
		byte[] encoded = pass.getBytes();
		key = new SecretKeySpec(encoded, 0, encoded.length, "DES");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return key;
	}

}
