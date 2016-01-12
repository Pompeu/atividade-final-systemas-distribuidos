package server.teste;


public class Main {
	
	
	public static void main(String[] args) throws Exception {
		
		Thread server = new Thread(() -> {
			try {
				Server.main();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Thread cliente = new Thread(() -> {
			try {
				Cliente.main();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		server.start();
		cliente.start();

	}
	
	
}
