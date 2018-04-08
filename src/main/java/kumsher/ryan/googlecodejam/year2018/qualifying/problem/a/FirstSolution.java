package kumsher.ryan.googlecodejam.year2018.qualifying.problem.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

/*
 * https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard
 */
public class FirstSolution {

  enum Instruction {
    CHARGE,
    SHOOT
  }

  void solve(String inputFileName, String outputFileName) {
    List<String> inputLines = getInputLines(inputFileName);
    List<String> outputLines = Lists.newArrayList();
    inputLines.stream()
            .map(this::solve)
            .forEach(swaps -> outputLines.add("Case #" + (outputLines.size() + 1) + ": " + swaps));
    CodeJamFileUtils.writeSolution(outputFileName, 2018, "qualifying", "a", outputLines);
  }

  private List<String> getInputLines(String inputFileName) {
    List<String> inputLines = CodeJamFileUtils.readProblem(inputFileName, 2018, "qualifying", "a");
    inputLines.remove(0); // Don't care about the number of test cases (line 1)
    return inputLines;
  }

  @VisibleForTesting
  String solve(String inputLine) {
    Character[] input = ArrayUtils.toObject(inputLine.toCharArray());
    int shield = getShieldLevel(input);
    List<Instruction> instructions = convertToInstructions(input);
    if (getShootCount(instructions) > shield) {
      return "IMPOSSIBLE";
    }
    return "" + calculateNumberOfSwapsRequired(shield, instructions);
  }

  private int getShieldLevel(Character[] chars) {
    Character[] ints = Arrays.stream(chars).filter(Character::isDigit).toArray(Character[]::new);
    return Integer.parseInt(new String(ArrayUtils.toPrimitive(ints)));
  }

  private List<Instruction> convertToInstructions(Character[] inputLine) {
    return Arrays.stream(inputLine)
            .filter(Character::isLetter)
            .map(c -> c.equals('C') ? Instruction.CHARGE : Instruction.SHOOT)
            .collect(Collectors.toList());
  }

  private long getShootCount(List<Instruction> instructions) {
    return instructions.stream().filter(instruction -> instruction == Instruction.SHOOT).count();
  }

  private int calculateNumberOfSwapsRequired(int shield, List<Instruction> instructions) {
    instructions = removeTrailingCharges(instructions);
    int swapCount = 0;
    while (getDamage(instructions) > shield) {
      instructions = moveLastChargeRight(instructions);
      swapCount++;
    }
    return swapCount;
  }

  private int getDamage(List<Instruction> instructions) {
    int beamPower = 1;
    int damage = 0;
    for (Instruction instruction : instructions) {
      if (instruction == Instruction.SHOOT) {
        damage += beamPower;
      } else {
        beamPower = beamPower * 2;
      }
    }
    return damage;
  }

  private List<Instruction> removeTrailingCharges(List<Instruction> instructions) {
    int lastShootIndex = instructions.lastIndexOf(Instruction.SHOOT);
    return instructions.subList(0, lastShootIndex + 1);
  }

  private List<Instruction> moveLastChargeRight(List<Instruction> instructions) {
    int lastChargeIndex = instructions.lastIndexOf(Instruction.CHARGE);
    Collections.swap(instructions, lastChargeIndex, lastChargeIndex + 1);
    return removeTrailingCharges(instructions);
  }

}
