package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Server {

	public static void main(String[] args) throws Exception {
		System.out.println("Init Server");
		ServerSocket server = new ServerSocket(3000);

		System.out.println("wating connection");

		Socket socket = server.accept();

		System.out.println("have connection");

		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);

		while (true) {
			String msg = in.readLine();
			
			if ("Fim".equals(msg)) {
				break;
			}
						
			out.println(getList(msg));
		}

		System.out.println("end");

		in.close();
		out.close();
		socket.close();
		server.close();

	}
	
	private static List<Integer> getList(String msg){
		
		msg = msg.replace("]","");
		msg = msg.replace("[","");
		String[] arr = msg.split(",");
		
		List<Integer> intes = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			intes.add(Integer.parseInt(arr[i].trim()));
		}
		
		return intes.stream()
			.sorted()
			.collect(Collectors.toList());
	}
}
