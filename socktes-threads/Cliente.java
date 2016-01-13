
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;

public class Cliente {

	public static void main() throws Exception {

		Socket socket = new Socket("localhost", 3000);

		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);

		int i = 0;
		while (true) {
			long init = System.currentTimeMillis();
			String msg = Arrays.toString(getVector());

			if (i > 0) {
				out.println("Fim");
				break;
			}else { 
				++i;
				out.println(msg);
			}

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

	public static final int[] getVector() {
		int[] ints = new int[10000];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = (int) (Math.random() * 10001);
		}
		return ints;
	}

}
