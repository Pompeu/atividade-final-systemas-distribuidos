
import static java.util.stream.Collectors.toList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class Parser {

	public static void main(String args[]) throws Exception {
		String path = args.length > 0 ? args[0] : "../results";
		Files
			.walk(Paths.get(path))
			.filter(Files::isRegularFile)
			.map(f -> f.toString())
			//remove arquivos com extençao da lista
			.filter(f -> !f.matches(".*?\\.[a-z]{1,4}"))
			.collect(toList())
			.forEach(p -> {
				try {
					List<Number> list = Files
						.lines(Paths.get(p))
						.map(Double::parseDouble)
						.collect(toList());
						
						OutputStream os = new FileOutputStream(p.split("/")[2]+".json");	
						os.write(new StaticWrap(p,list).toString().getBytes());
						os.flush();
						os.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			});

	}

	static<T> void println(T arg) { System.out.println(arg); }

}
