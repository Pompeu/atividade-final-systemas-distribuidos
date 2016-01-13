import java.rmi.Remote;
import java.util.List;

public interface Servico extends java.rmi.Remote {
   int[] message(int[] ints ) throws java.rmi.RemoteException;
}
