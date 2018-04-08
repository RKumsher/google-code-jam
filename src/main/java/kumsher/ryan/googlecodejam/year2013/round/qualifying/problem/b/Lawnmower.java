package kumsher.ryan.googlecodejam.year2013.round.qualifying.problem.b;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

public class Lawnmower {

	public static void main(String[] args) throws IOException {
		File outputFile = new File("lawnmower-generated-output.txt");
		File inputFile = new File("B-large.in");
//		File inputFile = new File("sample-lawnmower.in");
		List<String> inputLines = FileUtils.readLines(inputFile);
		int numOfTestCases = Integer.parseInt(inputLines.remove(0));

		List<String> outputLines = Lists.newArrayList();
		for (int i = 0; i < numOfTestCases;) {
			String line = inputLines.get(i);
			int n = Integer.valueOf(line.substring(0, line.indexOf(" ")));
			int m = Integer.valueOf(line.substring(line.indexOf(" ") + 1));
			int[][] yard = new int[n][m];
			for (int j = 0; j < n; j++) {
				Scanner scanner = new Scanner(inputLines.get(i + j + 1));
				for (int k = 0; k < m; k++) {
					yard[j][k] = scanner.nextInt();
				}
			}
			i = i + n + 1;
			numOfTestCases = numOfTestCases + n;
//			printYard(yard);
//			System.out.println();
			String isPossible = isPossible(yard) ? "YES" : "NO";
//			System.out.println();
//			System.out.println();
//			System.out.println();

			String outputLine = "Case #" + (outputLines.size() + 1) + ": "
					+ isPossible;
			outputLines.add(outputLine);
		}

		FileUtils.writeLines(outputFile, outputLines);
//		System.out.println(outputLines);
	}

	private static boolean isPossible(int[][] yard) {
		int[][] workingYard = new int[yard.length][yard[0].length];
		for (int i = 0; i < yard.length; i++) {
			int[] row = yard[i];

			int max = 0;
			for (int j = 10; j > 0; j--) {
				if (ArrayUtils.contains(row, j)) {
					fillHorizontalRow(workingYard[i], j);
					max = j;
					break;
				}
			}

			for (int j = 1; j < max; j++) {
				for (int k = 0; k < row.length; k++) {
					if (row[k] == j) {
						fillVerticalRow(workingYard, k, j);
					}
				}}
			}
//		printYard(workingYard);
		return Arrays.deepEquals(workingYard, yard);
	}

	private static void fillHorizontalRow(int[] row, int value) {
		for (int i = 0; i < row.length; i++) {
			if (row[i] == 0 || row[i] > value) {
				row[i] = value;
			}
		}
	}

	private static void fillVerticalRow(int[][] yard, int index, int value) {
		for (int[] row : yard) {
			if (row[index] == 0 || row[index] > value) {
				row[index] = value;
			}
		}
	}

	private static String printYard(int[][] yard) {
		for (int[] is : yard) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		return null;
	}

}
