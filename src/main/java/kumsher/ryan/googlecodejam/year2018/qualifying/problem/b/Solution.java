package kumsher.ryan.googlecodejam.year2018.qualifying.problem.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard/00000000000079cb
 */
public class Solution {

  public static void main(String[] args) {
    Solution solver = new Solution();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfProblems = in.nextInt();
    for (int i = 1; i <= numberOfProblems; ++i) {
      int intCount = in.nextInt();
      List<Integer> ints = new ArrayList<>(intCount);
      for (int j = 0; j < intCount; j++) {
        ints.add(in.nextInt());
      }
      System.out.println("Case #" + i + ": " + solver.solve(ints));
    }
  }

  String solve(List<Integer> ints) {
    sort(ints);
    for (int i = 0; i < ints.size() - 1; i++) {
      if (ints.get(i) > ints.get(i + 1)) {
        return "" + i;
      }
    }
    return "OK";
  }

  private void sort(List<Integer> ints) {
    boolean done = false;
    while (!done) {
      done = true;
      for (int i = 0; i < ints.size() - 2; i++) {
        if (ints.get(i) > ints.get(i + 2)) {
          done = false;
          Collections.swap(ints, i, i + 2);
        }
      }
    }
  }

}
