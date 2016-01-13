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

	private final int porta;

	public Server(int porta){
		this.porta = porta;
	}

	public static void main(String[] args) throws Exception {
		new Server(3000).executa();
	}

	public void executa() throws Exception{
		ServerSocket server = new ServerSocket(this.porta);
		Socket client = null; 

		while(true)	{
			client = server.accept();
			new AcceptClient(client);
		}

	}

}

final class AcceptClient extends Thread {

	private final InputStream input;
	private final OutputStream output;
	private final BufferedReader in;
	private final PrintStream out;
	private final Socket client;

	public AcceptClient(Socket client) throws Exception {
		this.input  = client.getInputStream();
		this.output = client.getOutputStream();
		this.in     = new BufferedReader(new InputStreamReader(input));
		this.out    = new PrintStream(output);
		this.client = client;
		this.start();
	}

	public void run() {
	
		while (true) {
			try {
				String msg = in.readLine();
				out.println(getList(msg));
				closeAll();
			} catch(Exception e){
				closeAll();
				return;
			}
		}
	}

	private void closeAll() {
		try {
			this.in.close();
			this.out.close();
			this.client.close();
		} catch(Exception e){
			return;
		}
	}

	private static final List<Integer> getList(String msg) {

		msg = msg.replace("]", "");
		msg = msg.replace("[", "");
		String[] arr = msg.split(",");

		List<Integer> intes = new ArrayList<>();
		int len = arr.length;

		for (int i = 0; i < len ; i++) {
			intes.add(Integer.parseInt(arr[i].trim()));
		}

		return  intes.stream().sorted().collect(Collectors.toList());
	}
}
