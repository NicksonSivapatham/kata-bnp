package com.nickson.reader;

import java.io.IOException;
import java.util.List;

public interface FileReader {
	public List<String> readFile(String path) throws IOException;
}
