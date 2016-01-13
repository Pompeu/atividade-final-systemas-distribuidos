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

public class Client {

	public static void  main( String args[] ) {
		Context ic;
		Object objref;
		Servico servico;
		final long init = System.currentTimeMillis();

		try {
			ic = new InitialContext();

			objref = ic.lookup("Service");

			servico = (Servico) PortableRemoteObject.narrow(objref, Servico.class);
			servico.message(getVector());
			System.out.println(System.currentTimeMillis() - init);
		} catch( Exception e ) {
			System.err.println( "Exception " + e + "Caught" );
			e.printStackTrace( );
			return;
		}
	}

	static final int[] getVector() {
		int[] ints = new int[10000];
		for (int i = 0; i < 10000; i++) {
			ints[i] = (int) (Math.random() * 10000);
		}
		return ints;
	}
}
