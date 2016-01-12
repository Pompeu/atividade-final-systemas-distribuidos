import java.rmi.RemoteException;
import java.util.List;

public interface Hello extends java.rmi.Remote {
	
	List<Integer> message(List<Integer> vector) throws RemoteException;;
}
