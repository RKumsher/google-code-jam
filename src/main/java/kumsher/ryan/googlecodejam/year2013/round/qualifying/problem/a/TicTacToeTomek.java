package kumsher.ryan.googlecodejam.year2013.round.qualifying.problem.a;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class TicTacToeTomek {

  private static final String O_WON = "O won";
  private static final String X_WON = "X won";
  private static final String DRAW = "Draw";
  private static final String NOT_COMPLETED = "Game has not completed";
  private static boolean draw;

  public static void main(String[] args) throws IOException {
    List<String> inputLines = CodeJamFileUtils.readProblem("A-large.in", 2013, "qualifying", "a");
    int numOfTestCases = Integer.parseInt(inputLines.remove(0));
    System.out.println(numOfTestCases);
    System.out.println(inputLines);

    List<String> outputLines = Lists.newArrayList();

    for (int i = 0; i < numOfTestCases; i++) {
      int startIndex = i * 5;
      draw = true;
      char[][] board = new char[4][4];
      board[0] = inputLines.get(startIndex + 0).toCharArray();
      board[1] = inputLines.get(startIndex + 1).toCharArray();
      board[2] = inputLines.get(startIndex + 2).toCharArray();
      board[3] = inputLines.get(startIndex + 3).toCharArray();

      String gameResult = getGameStatus(board);
      String outputLine = "Case #" + (i + 1) + ": " + gameResult;
      outputLines.add(outputLine);
    }
    CodeJamFileUtils.writeSolution("generated-output.txt", 2013, "qualifying", "a", outputLines);
  }

  private static String getGameStatus(char[][] board) {
    String gameStatus;
    if ((gameStatus = checkHorizontalLines(board)) != null) return gameStatus;
    if ((gameStatus = checkVerticalLines(board)) != null) return gameStatus;
    if ((gameStatus = checkDiagonalLines(board)) != null) return gameStatus;
    if (draw) {
      return DRAW;
    }
    return NOT_COMPLETED;
  }

  private static String checkHorizontalLines(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      int total = 0;
      total += getSpaceValue(board[i][0]);
      total += getSpaceValue(board[i][1]);
      total += getSpaceValue(board[i][2]);
      total += getSpaceValue(board[i][3]);
      String lineStatus = getLineStatus(total);
      if (lineStatus != null) {
        return lineStatus;
      }
    }
    return null;
  }

  private static String getLineStatus(int total) {
    if (total == 4 || total == 103) {
      return X_WON;
    }
    if (total == 40 || total == 130) {
      return O_WON;
    }
    return null;
  }

  private static int getSpaceValue(char c) {
    switch (c) {
      case 'X':
        return 1;
      case 'O':
        return 10;
      case 'T':
        return 100;
      case '.':
        draw = false;
        return 0;
    }
    return 0;
  }

  private static String checkVerticalLines(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      int total = 0;
      total += getSpaceValue(board[0][i]);
      total += getSpaceValue(board[1][i]);
      total += getSpaceValue(board[2][i]);
      total += getSpaceValue(board[3][i]);
      String lineStatus = getLineStatus(total);
      if (lineStatus != null) {
        return lineStatus;
      }
    }
    return null;
  }

  private static String checkDiagonalLines(char[][] board) {
    int total = 0;
    total += getSpaceValue(board[0][0]);
    total += getSpaceValue(board[1][1]);
    total += getSpaceValue(board[2][2]);
    total += getSpaceValue(board[3][3]);
    String lineStatus = getLineStatus(total);
    if (lineStatus != null) {
      return lineStatus;
    }

    total = 0;
    total += getSpaceValue(board[0][3]);
    total += getSpaceValue(board[1][2]);
    total += getSpaceValue(board[2][1]);
    total += getSpaceValue(board[3][0]);
    return getLineStatus(total);
  }
}
