import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//Client class sends messages to servers of other nodes.
	public class client{
    	
		Socket clientSocket;
		
		public client(String host,int port,Ciphermessage cm) throws java.net.ConnectException,IOException
		{
			try 
			{
				clientSocket = new Socket(host,port);
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				out.writeObject(cm);
				out.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}