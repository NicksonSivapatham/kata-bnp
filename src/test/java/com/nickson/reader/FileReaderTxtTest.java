package com.nickson.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileReaderTxtTest {

	@Test
	void testReadFile() throws IOException {
		FileReaderTxt reader = new FileReaderTxt();
		List<String> expectedLines = List.of("Hello", "This is a", "test");
		
		List<String> lines = reader.readFile("src/test/resources/inputForFileReaderTxt.txt");
		
		assertEquals(expectedLines, lines);
	}

}
