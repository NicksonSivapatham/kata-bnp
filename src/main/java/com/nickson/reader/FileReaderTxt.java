package com.nickson.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderTxt implements FileReader{
	
	@Override
	public List<String> readFile(String pathFile) throws IOException {
		Path path = Paths.get(pathFile);
		try (Stream<String> input = Files.lines(path))   {
			return input.collect(Collectors.toList());
		} catch (IOException e) {
			throw e;
		}
	}

}
