package kumsher.ryan.googlecodejam.year2018.qualifying.problem.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard
 */
public class Solution {

  enum Instruction {
    CHARGE,
    SHOOT
  }

  public static void main(String[] args) {
    Solution solver = new Solution();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfLines = in.nextInt();
    for (int i = 1; i <= numberOfLines; ++i) {
      int shield = in.nextInt();
      String input = in.next();
      System.out.println("Case #" + i + ": " + solver.solve(shield, input));
    }
  }

  private String solve(int shield, String input) {
    List<Instruction> instructions = convertToInstructions(input);
    if (getShootCount(instructions) > shield) {
      return "IMPOSSIBLE";
    }
    return "" + calculateNumberOfSwapsRequired(shield, instructions);
  }

  private List<Instruction> convertToInstructions(String inputLine) {
    return Arrays.stream(inputLine.chars().mapToObj(c -> (char) c).toArray(Character[]::new))
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
