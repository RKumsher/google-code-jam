package kumsher.ryan.googlecodejam.year2012.round.qualifying.problem.c;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class RecycledNumbers {

  private static final String INPUT_FILE = "C-large.in";

  public static void main(String[] args) {
    List<String> inputLines = CodeJamFileUtils.readProblem(INPUT_FILE, 2012, "qualifying", "c");
    Integer.parseInt(inputLines.remove(0));
    List<String> outputLines = Lists.newArrayList();
    for (int k = 0; k < inputLines.size(); k++) {
      System.out.println("line # " + (k + 1));
      String line = inputLines.get(k);
      int separator = line.indexOf(' ');
      int a = Integer.valueOf(line.substring(0, separator));
      int b = Integer.valueOf(line.substring(separator + 1));
      Set<String> matches = Sets.newHashSet();
      for (int currentNumber = a; currentNumber < b; currentNumber++) {
        String stringA = String.valueOf(currentNumber);
        for (int j = 1; j < stringA.length(); j++) {
          String begin = stringA.substring(j);
          String end = stringA.substring(0, j);
          int generatedNumToCheck = Integer.valueOf(begin + end);
          if (generatedNumToCheck <= b && generatedNumToCheck >= a
                  && generatedNumToCheck != currentNumber
                  && generatedNumToCheck > currentNumber) {
            matches.add(currentNumber + " - " + generatedNumToCheck);
          }
        }
      }
      outputLines.add("Case #" + (k + 1) + ": " + matches.size());
    }
    System.out.println(outputLines);
    CodeJamFileUtils.writeSolution("generated-recycled-numbers-output.txt", 2012, "qualifying", "c", outputLines);
  }

}
