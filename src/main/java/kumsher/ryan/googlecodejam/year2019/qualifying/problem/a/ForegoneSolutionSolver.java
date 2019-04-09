package kumsher.ryan.googlecodejam.year2019.qualifying.problem.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

/*
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705
 */
public class ForegoneSolutionSolver {

  public static void main(String[] args) {
    ForegoneSolutionSolver solver = new ForegoneSolutionSolver();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfLines = in.nextInt();
    for (int i = 1; i <= numberOfLines; ++i) {
      int prize = in.nextInt();
      System.out.println("Case #" + i + ": " + solver.solve(prize));
    }
  }

  String solve(int prize) {
    int current = prize;
    while (current >= prize / 2 - 1) {
      int[] ints = toArray(current);
      if (hasFour(ints)) {
        reduce(ints);
      }
      current = toInt(ints);
      int difference = prize - current;
      if (!hasFour(difference)) {
        return "" + current + " " + difference;
      } else {
        current = current - (increase(difference) - difference);
      }
    }
    throw new IllegalArgumentException();
  }

  private boolean hasFour(int num) {
    return getIndexOfFour(num).isPresent();
  }

  private boolean hasFour(int[] ints) {
    return getIndexOfFour(ints).isPresent();
  }

  private Optional<Integer> getIndexOfFour(int num) {
    return getIndexOfFour(toArray(num));
  }

  private Optional<Integer> getIndexOfFour(int[] ints) {
    for (int i = 0; i < ints.length; i++) {
      if (ints[i] == 4) {
        return Optional.of(i);
      }
    }
    return Optional.empty();
  }

  private void reduce(int[] ints) {
    int indexOfFour = getIndexOfFour(ints).orElseThrow(IllegalArgumentException::new);
    ints[indexOfFour] = 3;
    for (int i = indexOfFour + 1; i < ints.length; i++) {
      ints[i] = 9;
    }
  }

  private int increase(int number) {
    int[] ints = toArray(number);
    int indexOfFour = getIndexOfFour(ints).orElseThrow(IllegalArgumentException::new);
    ints[indexOfFour] = 5;
    for (int i = indexOfFour + 1; i < ints.length; i++) {
      ints[i] = 0;
    }
    return toInt(ints);
  }

  private int toInt(int[] ints) {
    StringBuilder strInt = new StringBuilder();
    for (int current : ints) {
      strInt.append(current);
    }
    return Integer.parseInt(strInt.toString());
  }

  private int[] toArray(int current) {
    return Integer.toString(current).chars().map(c -> c - '0').toArray();
  }
}
