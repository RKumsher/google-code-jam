package kumsher.ryan.googlecodejam.year2017.qualifying.problem.b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.collect.Lists;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class TidyNumbers {

  void solve(String inputFileName, String outputFileName) {
    List<String> outputLines = Lists.newArrayList();
    List<Long> inputLines = getInputLines(inputFileName);
    inputLines.stream()
            .map(this::getLargestTidyNumber)
    .forEach(tidyNumber -> {
      outputLines.add("Case #" + (outputLines.size() + 1) + ": " + tidyNumber);
    });
    System.out.println(outputLines);
    CodeJamFileUtils.writeSolution(outputFileName, 2017, "qualifying", "b", outputLines);
  }

  private Long getLargestTidyNumber(Long number) {
    for (long current = number; current > 0; current--) {
      List<Integer> ints = Arrays.stream(ArrayUtils.toObject(Long.toString(current).toCharArray()))
              .map(Object::toString)
              .map(Integer::parseInt)
              .collect(Collectors.toList());
      if (isTidy(ints)) {
        return current;
      }
      current = adjust(ints);
    }
    throw new IllegalArgumentException();
  }

  private Long adjust(List<Integer> ints) {
    int min = 0;
    for (int i = 0; i < ints.size(); i++) {
      Integer current = ints.get(i);
      if (current < min) {
        for (int j = i; j < ints.size(); j++) {
          ints.set(j, 0);
        }
        Character[] characters = ints.stream()
                .map(integer -> Integer.toString(integer).charAt(0))
                .toArray(Character[]::new);
        return Long.parseLong(new String(ArrayUtils.toPrimitive(characters)));
      }
      min = current;
    }
    throw new IllegalArgumentException();
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

  private List<Long> getInputLines(String inputFileName) {
    List<String> inputLines = CodeJamFileUtils.readProblem(inputFileName, 2017, "qualifying", "b");
    Integer.parseInt(inputLines.remove(0));
    return inputLines.stream()
            .map(Long::valueOf)
            .collect(Collectors.toList());
  }

}
