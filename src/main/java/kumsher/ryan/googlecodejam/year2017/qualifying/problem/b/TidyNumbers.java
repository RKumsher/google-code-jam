package kumsher.ryan.googlecodejam.year2017.qualifying.problem.b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

class TidyNumbers {

  void solve(String inputFileName, String outputFileName) {
    List<Long> inputLines = getInputLines(inputFileName);
    List<String> outputLines = Lists.newArrayList();
    inputLines
        .stream()
        .map(this::getLargestTidyNumber)
        .forEach(
            tidyNumber -> outputLines.add("Case #" + (outputLines.size() + 1) + ": " + tidyNumber));
    CodeJamFileUtils.writeSolution(outputFileName, 2017, "qualifying", "b", outputLines);
  }

  private List<Long> getInputLines(String inputFileName) {
    List<String> inputLines = CodeJamFileUtils.readProblem(inputFileName, 2017, "qualifying", "b");
    inputLines.remove(0); // Don't care about the number of test cases (line 1)
    return inputLines.stream().map(Long::valueOf).collect(Collectors.toList());
  }

  private Long getLargestTidyNumber(Long number) {
    for (long current = number; current > 0; current--) {
      List<Integer> ints = convertToInts(current);
      if (isTidy(ints)) {
        return current;
      }
      current = adjust(ints);
    }
    throw new IllegalArgumentException();
  }

  private List<Integer> convertToInts(long current) {
    return Arrays.stream(ArrayUtils.toObject(Long.toString(current).toCharArray()))
        .map(Object::toString)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private Long adjust(List<Integer> ints) {
    int min = 0;
    for (int i = 0; i < ints.size(); i++) {
      Integer current = ints.get(i);
      if (current < min) {
        for (int j = i; j < ints.size(); j++) {
          ints.set(j, 0);
        }
        return convertToLong(ints);
      }
      min = current;
    }
    throw new IllegalArgumentException();
  }

  private Long convertToLong(List<Integer> ints) {
    Character[] characters =
        ints.stream().map(integer -> Integer.toString(integer).charAt(0)).toArray(Character[]::new);
    return Long.parseLong(new String(ArrayUtils.toPrimitive(characters)));
  }

  private boolean isTidy(List<Integer> ints) {
    int min = 0;
    for (Integer current : ints) {
      if (current < min) {
        return false;
      }
      min = current;
    }
    return true;
  }
}
