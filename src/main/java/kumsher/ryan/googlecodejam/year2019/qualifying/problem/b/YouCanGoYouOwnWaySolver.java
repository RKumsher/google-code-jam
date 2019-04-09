package kumsher.ryan.googlecodejam.year2019.qualifying.problem.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705
 */
public class YouCanGoYouOwnWaySolver {

  public static void main(String[] args) {
    YouCanGoYouOwnWaySolver solver = new YouCanGoYouOwnWaySolver();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfLines = in.nextInt();
    for (int i = 1; i <= numberOfLines; ++i) {
      in.nextInt();
      String directions = in.next();
      System.out.println("Case #" + i + ": " + solver.solve(directions));
    }
  }

  String solve(String directions) {
    char[] chars = directions.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      chars[i] = chars[i] == 'S' ? 'E' : 'S';
    }
    return new String(chars);
  }
}
