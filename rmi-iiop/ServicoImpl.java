import javax.rmi.PortableRemoteObject;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class ServicoImpl extends PortableRemoteObject implements Servico {

	public ServicoImpl() throws java.rmi.RemoteException {
		super(); 
	}

	@Override
	public int[] message(int[] list) throws java.rmi.RemoteException {
		return Arrays.stream(list)
			.sorted()
			.toArray();
	}
}
