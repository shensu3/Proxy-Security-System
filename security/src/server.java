import java.net.ServerSocket;

/**Server class listens for clients and accepts when various clients from other classes
 * wants to send message to the server.*/
public class server extends Thread{
	
	ServerSocket serverSocket;
	
	public void run()
	{
		try{ 
			System.out.println("Started server");
			serverSocket = new ServerSocket(website.port);
			while(true){
				new serverThread(serverSocket.accept()).start();
			}
	    } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
	