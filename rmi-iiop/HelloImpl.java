import javax.rmi.PortableRemoteObject;
import java.util.List;
import java.util.stream.Collectors;


public class HelloImpl extends PortableRemoteObject implements HelloInterface {

	public HelloImpl() throws java.rmi.RemoteException {
		super(); 
	}

	@Override
	public List<Integer> message(List<Integer> list) throws java.rmi.RemoteException {
		return list.stream()
			.sorted()
			.collect(Collectors.toList());
	}

}
