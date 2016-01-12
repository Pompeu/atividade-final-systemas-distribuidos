import java.rmi.Remote;
import java.util.List;

public interface HelloInterface extends java.rmi.Remote {
   public List<Integer> message(List<Integer> from ) throws java.rmi.RemoteException;
}
