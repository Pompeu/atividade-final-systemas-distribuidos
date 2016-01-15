
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

	public static void main(String args[]) throws Exception {
		final String fileName = args[0];
		final Stream<String> stream = Files.lines(Paths.get(fileName));

		List<Number> list = stream
			.map(Double::parseDouble)
			.collect(Collectors.toList());

		println(new StaticWrapInt(fileName,list));

		stream.close();
	}

	static<T> void println(T arg) { System.out.println(arg); }

}
