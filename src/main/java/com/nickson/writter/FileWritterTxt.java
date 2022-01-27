package com.nickson.writter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FileWritterTxt implements FileWritter{

	@Override
	public void write(String pathFile, List<String> lines) throws IOException {
		File file =  new File(pathFile);
		
		try (Writer writer = new FileWriter(file)) {
			for (String line : lines) {
				writer.write(line);
				writer.write("\n");
			}
		} catch (IOException e) {
			throw e;
		}	
	}

}
