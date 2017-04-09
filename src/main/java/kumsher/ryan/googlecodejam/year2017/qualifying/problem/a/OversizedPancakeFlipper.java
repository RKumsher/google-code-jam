package kumsher.ryan.googlecodejam.year2017.qualifying.problem.a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

class OversizedPancakeFlipper {

  void solve(String inputFileName, String outputFileName) {
    List<Pair<Integer, Boolean[]>> inputLines = getInputLines(inputFileName);
    List<String> outputLines = Lists.newArrayList();
    inputLines
        .stream()
        .map(this::calculateMinimumFlips)
        .forEach(flips -> outputLines.add("Case #" + (outputLines.size() + 1) + ": " + flips));
    CodeJamFileUtils.writeSolution(outputFileName, 2017, "qualifying", "a", outputLines);
  }

  private List<Pair<Integer, Boolean[]>> getInputLines(String inputFileName) {
    List<String> inputLines = CodeJamFileUtils.readProblem(inputFileName, 2017, "qualifying", "a");
    inputLines.remove(0); // Don't care about the number of test cases (line 1)
    return inputLines
        .stream()
        .map(String::toCharArray)
        .map(ArrayUtils::toObject)
        .map(this::convertToBooleanArray)
        .collect(Collectors.toList());
  }

  private Pair<Integer, Boolean[]> convertToBooleanArray(Character[] chars) {
    int flipperSize = getFlipperSize(chars);
    Boolean[] booleans =
        Arrays.stream(chars)
            .filter(character -> character.equals('+') || character.equals('-'))
            .map(this::convertCharacterToBoolean)
            .toArray(Boolean[]::new);
    return Pair.of(flipperSize, booleans);
  }

  private int getFlipperSize(Character[] chars) {
    Character[] ints = Arrays.stream(chars).filter(Character::isDigit).toArray(Character[]::new);
    return Integer.parseInt(new String(ArrayUtils.toPrimitive(ints)));
  }

  private boolean convertCharacterToBoolean(Character c) {
    return c.equals('+');
  }

  private String calculateMinimumFlips(Pair<Integer, Boolean[]> line) {
    int flips = 0;
    for (int i = 0; i < line.getRight().length; i++) {
      if (!line.getRight()[i]) {
        flips++;
        line.getRight()[i] = !line.getRight()[i];
        for (int j = 1; j < line.getLeft(); j++) {
          if (i + j > line.getRight().length - 1) {
            return "IMPOSSIBLE";
          }
          line.getRight()[i + j] = !line.getRight()[i + j];
        }
      }
    }
    return Integer.toString(flips);
  }
}
