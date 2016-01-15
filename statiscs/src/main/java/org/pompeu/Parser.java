package org.pompeu;

import static java.util.stream.Collectors.toList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.io.OutputStream;
import java.io.FileOutputStream;

import org.pompeu.wraps.StaticWrap;

public class Parser {

	public static void main(String args[]) throws Exception {
		String path = args[0];

		Files
			.walk(Paths.get(path))
			.filter(Files::isRegularFile)
			.map(f -> f.toString())
			//remove arquivos com extençao da lista
			.filter(f -> !f.matches(".*?\\.[a-z]{1,4}"))
			.collect(toList())
			.forEach(p -> {
				try {
					String title = p.split("/")[2];
					OutputStream os = new FileOutputStream(title+".json");	
					os.write(new StaticWrap(title,getList(p)).toString().getBytes());
					os.flush();
					os.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			});

	}

	static List<Number> getList(String path) throws Exception {
		return Files
			.lines(Paths.get(path))
			.map(Double::parseDouble)
			.collect(toList());
	}

	static<T> void println(T arg) { System.out.println(arg); }

}
