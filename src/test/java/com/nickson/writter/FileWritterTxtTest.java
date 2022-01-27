package com.nickson.writter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.nickson.reader.FileReaderTxt;

class FileWritterTxtTest {

	@Test
	void testWrite() throws IOException {
		String pathFile = "src/test/resources/outputForFileWritterTxt.txt";
		FileWritterTxt writter = new FileWritterTxt();
		List<String> linesToWrite =List.of("This is a ", "Test");
		writter.write(pathFile, linesToWrite);
		
		FileReaderTxt reader = new FileReaderTxt();
		List<String> result = reader.readFile(pathFile);
		
		assertEquals(linesToWrite, result);
	}

}
