package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;

public class Cliente {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost", 3000);

		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);

		int i = 0;
		while (true) {
			long init = System.currentTimeMillis();
			String msg = Arrays.toString(getVector());

			if (i == 1) {
				out.println("Fim");
				break;
			}
			i++;

			out.println(msg);

			if ("Fim".equals(msg)) {
				break;
			}

			msg = in.readLine();
	
			System.out.println(System.currentTimeMillis() - init);
			
		}

		in.close();
		out.close();
		socket.close();

	}

	public static int[] getVector() {
		int[] ints = new int[10001];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = (int) (Math.random() * 10001);
		}
		return ints;
	}

}
