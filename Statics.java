import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Math;
import java.util.IntSummaryStatistics;

public class Statics {

	public static void main(String args[]) throws Exception{

		final String fileName = args[0];
		final Stream<String> stream = Files.lines(Paths.get(fileName));
		List<Integer> list = stream.map(Integer::parseInt).collect(Collectors.toList());
		//todo gerar json das estaticas
		println(statics(list));
		println(median(list));
		println(desvioPadrao(list));
	}

	static<T> void println(T arg) { System.out.println(arg); }

	static IntSummaryStatistics statics (List<Integer> list) {
		return list.stream().mapToInt(n -> n).summaryStatistics();
	}

	static double median(List<Integer> list) {
		int esq = 0;
		int dir = list.size()-1;
		int meio;
		meio=(esq+dir)/2;
		return list.get(meio);
	}

	static long total(List<Integer> list) {
		return list
			.stream() 
			.mapToInt(n -> n)
			.sum();
	}

	static double desvioPadrao(List<Integer> list) {
		double avg = statics(list).getAverage();
		long size = list.size() ;

		int somatorio = list.stream()
			.map(v	-> v - (int)avg)
			.map(v	-> v * v)
			.mapToInt(v -> v)
			.sum();
		return Math.sqrt(((double)1 / (size -1)) * somatorio);
	}

}
