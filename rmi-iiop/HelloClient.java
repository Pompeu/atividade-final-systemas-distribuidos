import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import javax.rmi.*;
import java.util.Vector;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

public class HelloClient {

	public static void  main( String args[] ) {
		Context ic;
		Object objref;
		HelloInterface hi;
		long init = System.currentTimeMillis();

		try {
			ic = new InitialContext();

			objref = ic.lookup("HelloService");

			hi = (HelloInterface) PortableRemoteObject.narrow(
					objref, HelloInterface.class);
			hi.message(getVector());
			System.out.println(System.currentTimeMillis() - init);
		} catch( Exception e ) {
			System.err.println( "Exception " + e + "Caught" );
			e.printStackTrace( );
			return;
		}
	}

	static List<Integer> getVector() {
		List<Integer> ints = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			ints.add((int) (Math.random() * 10000));
		}
		return ints;
	}
}
