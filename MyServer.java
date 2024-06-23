import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server=new ServerSocket(1234);
			
			System.out.println("\n Server is waiting.... ");
			Socket client=server.accept();
			
			//System.out.println("\n Welcome client connected.... ");
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			Scanner scan=new Scanner(System.in);
			String msg="";
			
			while(!msg.equals("QUIT"))
			{
				System.out.print("\n Enter msg for client : ");
				msg=scan.nextLine();
				dos.writeUTF(msg); //unicode transform format;
				
				msg=dis.readUTF();
				System.out.println("\n Msg from client : "+msg);
			}
			dis.close();
			dos.close();
			client.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SERVER ERROR : "+e.getMessage());
		}
	}
}