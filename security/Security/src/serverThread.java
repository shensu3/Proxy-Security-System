import java.io.*;
import java.net.*;


/**Server class starts this serverThread class when a new client joins the server.
 * All actions when a new message is received from a child node is done here.*/
public class serverThread extends Thread{
	
	Socket socket = null;
    
	public serverThread(Socket socket) {
        this.socket = socket;
    }
	
    public void run()
    {
    	//Listen for messages in the socket.
    	try(ObjectInputStream in = new ObjectInputStream(socket.getInputStream()))
    	{
    		Ciphermessage input;
    		//Reads the message sent from a neighbor.
    		while((input = (Ciphermessage) in.readObject())!=null)
	    	{	
    			Plainmessage plain = new Plainmessage(input.prefix,security.decrypt(input.message,website.key));
    			if(plain.message.startsWith("Browse"));
    			{
    				File file = new File("books");
    				String temp[] = file.list();
    				StringBuilder sb=new StringBuilder();
    				for(int i=0;i<temp.length;i++)
    					sb.append(temp[i]+" ");
    				System.out.println(sb);
    			}
    			
	    	}
    			
    	}
    	catch(IOException io)
    	{
    	}
    	catch (Exception e) 
    	{
	        	e.printStackTrace();
	    }
    }
    
}