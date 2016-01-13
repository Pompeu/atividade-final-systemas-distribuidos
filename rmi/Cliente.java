import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {

	private Cliente() {
	}

	public static void main(String... args) {
		long init = System.currentTimeMillis();
		try {
			Registry registry = LocateRegistry.getRegistry(1099);
			Servico stub = (Servico) registry.lookup("H");

			int[] list = stub.message(getVector());
			System.out.println(System.currentTimeMillis() - init);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	final static int[] getVector() {
		int[] ints = new int[10000];
		for (int i = 0; i < 10000; i++) {
			ints[i] = (int) (Math.random() * 10001);
		}
		return ints;
	}

}
