import java.net.*;
import java.io.*;

public class Client
{
	public static void main(String[] args) throws IOException
	{
		Socket client = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try
		{
			client = new Socket("localhost",81);
			out = new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}
		catch(UnknownHostException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int height;
		int weight;
		boolean loop = true;

		String serverInput;
		String ans;
		boolean end = false;

		do
		{
			serverInput = in.readLine();

			//System.out.println("Server said: "+serverInput);

			if(serverInput.equals("height"))
			{
				System.out.print("Enter your height: ");
				height = Integer.valueOf(input.readLine());
				out.println("he"+height);
			}
			else if(serverInput.equals("weight"))
			{
				System.out.print("Enter your weight: ");
				weight = Integer.valueOf(input.readLine());
				out.println("we"+weight);
			}
			else if(serverInput.equals("another"))
			{
				System.out.print("Do you want to insert another height and weight? yes/no :");
				ans = input.readLine();

				if(ans.equals("yes"))
				{
					loop = true;
					out.println("another");
					System.out.println();
				}
				else
				{
					//loop = false;
					out.println("no");
				}
			}
			else
			{
				System.out.println(serverInput);
				loop = false;
			}
		}
		while(loop);

		//System.out.println(input.readLine());

		out.close();
		in.close();
		input.close();
		client.close();
	}
}