import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class HelloImpl implements Hello {

	public static void main(String... args) {
		try {
			HelloImpl obj = new HelloImpl();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);	
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("H", stub);
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public List<Integer> message(List<Integer> list) throws RemoteException {
		return list.stream()
				.sorted()
				.collect(Collectors.toList());
	}
}
