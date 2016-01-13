import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ServicoImpl implements Servico {

	public static void main(String... args) {
		try {
			ServicoImpl obj = new ServicoImpl();
			Servico stub = (Servico) UnicastRemoteObject.exportObject(obj, 0);	
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("H", stub);
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public int[] message(int[] ints) throws RemoteException {
		return Arrays.stream(ints)
			.sorted()
			.toArray();
	}	
}
