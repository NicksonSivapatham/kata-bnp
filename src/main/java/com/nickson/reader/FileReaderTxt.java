package com.nickson.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReaderTxt implements FileReader{
	
	Logger logger = LoggerFactory.getLogger(FileReaderTxt.class);
	
	@Override
	public List<String> readFile(String pathFile) throws IOException {
		Path path = Paths.get(pathFile);
		try (Stream<String> input = Files.lines(path))   {
			return input.collect(Collectors.toList());
		} catch (IOException e) {
			logger.error("Error during reading file at {}", pathFile);
			throw e;
		}
	}

}
