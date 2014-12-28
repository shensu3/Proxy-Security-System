import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class website {

	/**
	 * @param args
	 */
public static int port = 6000;	
public static Key key;	


/*keygen();
byte [] temp = encrypt("Hello World");
System.out.println(temp);
System.out.println(decrypt(temp));	
*/

public static void main(String[] args) 
{
	Scanner in = new Scanner (System.in);
	System.out.println("Enter the port number you want to listen on");
	port = in.nextInt();
	server s1 = new server();
	s1.start();
	key = security.getSecretKey();  
	try{
	client c = new client("127.0.0.1",6000,new Ciphermessage("Browse","Browse"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
