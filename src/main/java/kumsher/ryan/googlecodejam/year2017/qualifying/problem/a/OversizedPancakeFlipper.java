package kumsher.ryan.googlecodejam.year2017.qualifying.problem.a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class OversizedPancakeFlipper {

  void solve(String inputFileName, String outputFileName) {
    List<String> outputLines = Lists.newArrayList();
    List<Pair<Integer, Boolean[]>> inputLines = getInputLines(inputFileName);
    inputLines.stream()
            .map(line -> calculateMinimumFlips(line))
            .forEach(flips -> {
              outputLines.add("Case #" + (outputLines.size() + 1) + ": " + flips);
            });
    System.out.println(outputLines);
    CodeJamFileUtils.writeSolution(outputFileName, 2017, "qualifying", "a", outputLines);
  }

  private List<Pair<Integer, Boolean[]>> getInputLines(String inputFileName) {
    List<String> inputLines = CodeJamFileUtils.readProblem(inputFileName, 2017, "qualifying", "a");
    Integer.parseInt(inputLines.remove(0));
    return inputLines.stream()
            .map(String::toCharArray)
            .map(ArrayUtils::toObject)
            .map(this::convertToBooleanArray)
            .collect(Collectors.toList());
  }

  private Pair<Integer, Boolean[]> convertToBooleanArray(Character[] chars) {
    Character[] ints = Arrays.stream(chars)
            .filter(Character::isDigit)
            .toArray(Character[]::new);
    int flipperSize = Integer.parseInt(new String(ArrayUtils.toPrimitive(ints)));

    Boolean[] booleans = Arrays.stream(chars)
            .filter(character -> character.equals('+') || character.equals('-'))
            .map(this::convertCharacterToBoolean)
            .toArray(Boolean[]::new);
    return new Pair<>(flipperSize, booleans);

  }

  private boolean convertCharacterToBoolean(Character c) {
    return c.equals('+');
  }

  private String calculateMinimumFlips(Pair<Integer, Boolean[]> line) {
    int flips = 0;
    for (int i = 0; i < line.getValue().length; i++) {
      if (!line.getValue()[i]) {
        flips++;
        line.getValue()[i] = !line.getValue()[i];
        for (int j = 1; j < line.getKey(); j++) {
          if (i + j > line.getValue().length - 1) {
            return "IMPOSSIBLE";
          }
          line.getValue()[i + j] = !line.getValue()[i + j];
        }
      }
    }
    System.out.println(flips);
    return Integer.toString(flips);
  }

}
