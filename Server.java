import java.net.*;
import java.io.*;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket server = null;
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;

		try
		{
			server = new ServerSocket(81);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}

		System.out.println("Server started!");
		try
		{
			client = server.accept();
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(),true);
			out.println("height");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}

		String output;
		String input;

		String code;
		int height = 0;
		int weight = 0;
		double bmi = 0;
		double pointer = 0;
		double totalPointer = 0;
		double totalbmi = 0;
		int totalSubject = 0;

		do
		{
			output = in.readLine();
			System.out.println("Client: "+output);
			//System.out.println(output.substring(0,1));
			if((output.substring(0,2)).equals("he"))
			{
				height = Integer.valueOf(output.substring(2));
				System.out.println("height: "+height);
				out.println("weight");
			}
			else if((output.substring(0,2)).equals("we"))
			{
				weight = Integer.valueOf(output.substring(2));
				System.out.println("weight "+weight);
				out.println("another");
			}
			
			else if(output.equals("another"))
			{
				totalSubject++;
//			totalCreditHour += creditHour;

				bmi = weight/height*height ;
				totalPointer += bmi;

				out.println("height");
			}
			else if(output.equals("no"))
			{
				//totalSubject++;
				//totalCreditHour += creditHour;
//totalbmi = totalPointer/totalCreditHour;

			totalSubject++;
//			totalCreditHour += creditHour;

				bmi = weight/height*height ;
					totalPointer += bmi;
				System.out.println("BMI "+bmi);
				
				out.println("Your BMI: "+ bmi );
			}
		}
		while(output != null);

		server.close();
		client.close();
		in.close();
	}
}