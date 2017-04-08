package kumsher.ryan.googlecodejam.common;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CodeJamFileUtils {

  public static List<String> readProblem(String fileName, int year, String round, String problem) {
    return readLines(getFileName(fileName, year, round, problem));
  }

  public static List<String> readLines(String fileName) {
    try {
      File inputFile = new File(fileName);
      List<String> inputLines = FileUtils.readLines(inputFile, Charset.defaultCharset());
      return inputLines;
    } catch (IOException ex) {
      throw new UncheckedIOException(ex);
    }
  }

  public static void writeSolution(String fileName, int year, String round, String problem,
          List<String> outputLines) {
    writeLines(getFileName(fileName, year, round, problem), outputLines);
  }

  private static String getFileName(String fileName, int year, String round, String problem) {
    return "src/main/resources/" + year + "/" + round + "/" + problem + "/" + fileName;
  }

  public static void writeLines(String fileName, List<String> outputLines) {
    try {
      FileUtils.writeLines(new File(fileName), outputLines);
    } catch (IOException ex) {
      throw new UncheckedIOException(ex);
    }
  }
}
