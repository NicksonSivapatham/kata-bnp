package com.nickson.writter;

import java.io.IOException;
import java.util.List;

public interface FileWritter {
	public void write(String pathFile, List<String> lines) throws IOException;
}
