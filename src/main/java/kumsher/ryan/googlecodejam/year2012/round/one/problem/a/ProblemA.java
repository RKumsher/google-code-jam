package kumsher.ryan.googlecodejam.year2012.round.one.problem.a;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;

public class ProblemA {
	private static final String INPUT_FILE = "a-small.in";
	private static final String OUTPUT_FILE = "a-small.out";

	public static void main(String[] args) throws IOException {
		List<String> outputLines = Lists.newArrayList();
		List<String> inputLines = readLines();
		for (String inputLine : inputLines) {

		}

		writeLines(outputLines);
	}

	public static List<String> readLines() throws IOException {
		File inputFile = new File(INPUT_FILE);
		List<String> inputLines = FileUtils.readLines(inputFile);
		Integer.parseInt(inputLines.remove(0));
		return inputLines;
	}

	public static void writeLines(List<String> outputLines) throws IOException {
		FileUtils.writeLines(new File(OUTPUT_FILE), outputLines);
	}

}
