import java.rmi.RemoteException;
import java.util.List;

public interface Servico extends java.rmi.Remote {
	int[] message(int[] ints) throws RemoteException;;
}
