package com.nickson.writter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileWritterTxt implements FileWritter{

	private static Logger logger = LoggerFactory.getLogger(FileWritterTxt.class);
	
	@Override
	public void write(String pathFile, List<String> lines) throws IOException {
		logger.info("Writting to " + pathFile);
		File file =  new File(pathFile);
		
		try (Writer writer = new FileWriter(file)) {
			for (String line : lines) {
				writer.write(line);
				writer.write("\n");
			}
		} catch (IOException e) {
			logger.error("Error during writing file at {}", pathFile);
			throw e;
		}	
	}

}
