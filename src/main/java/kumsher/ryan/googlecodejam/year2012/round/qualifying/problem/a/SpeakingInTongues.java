package kumsher.ryan.googlecodejam.year2012.round.qualifying.problem.a;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SpeakingInTongues {
  private static final String inputFileName = "A-small-attempt0.in";

  public static void main(String[] args) throws IOException {
    SpeakingInTongues main = new SpeakingInTongues();
    Map<Character, Character> characterMappingsArray = main
            .createCharacterMappingsArray();
    main.buildOutputFile(characterMappingsArray);
  }

  public Map<Character, Character> createCharacterMappingsArray()
          throws IOException {
    File inputFile = new File("sample-input.txt");
    List<String> inputLines = FileUtils.readLines(inputFile);
    int numOfTestCases = Integer.parseInt(inputLines.remove(0));
    System.out.println(numOfTestCases);
    System.out.println(inputLines);

    File outputFile = new File("sample-output.txt");
    List<String> outputLines = FileUtils.readLines(outputFile);
    System.out.println(outputLines);

    Map<Character, Character> mappings = Maps.newHashMap();
    for (int i = 0; i < inputLines.size(); i++) {
      String inputLine = inputLines.get(i);
      char[] inputCharArray = inputLine.toCharArray();
      String outputLine = outputLines.remove(0);
      outputLine = outputLine.substring("Case #".length()
              + String.valueOf(i).length() + ": ".length());
      char[] outputCharArray = outputLine.toCharArray();
      System.out.println(inputLine);
      System.out.println(outputLine);
      for (int j = 0; j < inputCharArray.length; j++) {
        char inputChar = inputCharArray[j];
        char outputChar = outputCharArray[j];
        mappings.put(inputChar, outputChar);
      }
    }
    mappings.put('z', 'q');
    mappings.put('q', 'z');

    System.out.println(mappings);
    System.out.println(mappings.keySet().size());
    return mappings;
  }

  private void buildOutputFile(
          Map<Character, Character> characterMappingsArray)
          throws IOException {
    File outputFile = new File("generated-output.txt");
    outputFile.createNewFile();
    File inputFile = new File(inputFileName);
    List<String> inputLines = FileUtils.readLines(inputFile);
    List<String> outputLines = Lists.newArrayList();
    int numOfTestCases = Integer.parseInt(inputLines.remove(0));
    for (int i = 0; i < numOfTestCases; i++) {
      String inputLine = inputLines.get(i);
      char[] inputCharArray = inputLine.toCharArray();
      char[] outputCharArray = new char[inputCharArray.length];
      for (int j = 0; j < inputCharArray.length; j++) {
        Character inputChar = inputCharArray[j];
        outputCharArray[j] = characterMappingsArray.get(inputChar);
      }
      String outputLine = "Case #" + (i + 1) + ": "
              + new String(outputCharArray);
      outputLines.add(outputLine);
    }
    FileUtils.writeLines(outputFile, outputLines);
  }

}
