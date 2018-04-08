package kumsher.ryan.googlecodejam.year2013.round.qualifying.problem.c;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class FairAndSquare {

	// private static final BigInteger MAX_NUMBER = new
	// BigInteger("1000000000000000");
	private static final BigInteger MAX_NUMBER = BigInteger
			.valueOf(1000000000000000L);

	public static void main(String[] args) throws IOException {
		File outputFile = new File("fair-and_square-generated-output.txt");
		File inputFile = new File("sample-fair-and-square.in");
		List<String> inputLines = FileUtils.readLines(inputFile);
		int numOfTestCases = Integer.parseInt(inputLines.remove(0));
		// System.out.println(numOfTestCases);
		// System.out.println(inputLines);

		List<BigInteger> fairAndSquares = populateFairAndSquares();

		List<String> outputLines = Lists.newArrayList();

		for (int i = 0; i < numOfTestCases; i++) {
			String line = inputLines.get(i);
			BigInteger a = new BigInteger(line.substring(0, line.indexOf(" ")));
			BigInteger b = new BigInteger(line.substring(line.indexOf(" ") + 1));
			int totalFairAndSquares = 0;
			for (BigInteger fairAndSquare : fairAndSquares) {
				if (fairAndSquare.compareTo(a) < 0)
					continue;
				if (fairAndSquare.compareTo(a) >= 0
						&& fairAndSquare.compareTo(b) <= 0)
					totalFairAndSquares++;
				if (fairAndSquare.compareTo(b) > 0)
					break;
			}
			String outputLine = "Case #" + (i + 1) + ": " + totalFairAndSquares;
			outputLines.add(outputLine);
		}
		FileUtils.writeLines(outputFile, outputLines);
		System.out.println(outputLines);
	}

	private static List<BigInteger> populateFairAndSquares() {
		List<BigInteger> fairAndSquares = Lists.newArrayList();
		for (BigInteger i = BigInteger.ONE; i.compareTo(MAX_NUMBER) < 0; i = i.add(BigInteger.ONE)) {
			char[] charArray = i.toString().toCharArray();
			Integer firstNum = Integer.valueOf(charArray[0]);
			if (!(firstNum == 1 || firstNum == 4 || firstNum == 9)) {
				if (firstNum < 4) {
					char[] newNum = new char[charArray.length];
					Arrays.fill(newNum, '0');
					newNum[0] = 4;
					i = new BigInteger(String.valueOf(newNum));
					continue;
				}
				if (firstNum < 9) {
					char[] newNum = new char[charArray.length];
					Arrays.fill(newNum, '0');
					newNum[0] = 9;
					i = new BigInteger(String.valueOf(newNum));
					continue;
				}
			}
			if (isPalindrome(i)) {
				BigInteger square = i.pow(2);
				if (isPalindrome(square)) {
					fairAndSquares.add(square);
					System.out.println(square + ", " + i);
				}
			}
		}
		return fairAndSquares;
	}

	private static boolean isPalindrome(BigInteger bigInteger) {
		String stringValue = bigInteger.toString();
		return stringValue.equals(StringUtils.reverse(stringValue));
	}

	public static boolean isPalindrome(int number) {
		int original = number;
		int reverse = 0;
		while (number > 0) {
			int digit = number % 10;
			number = number / 10;
			reverse = reverse * 10 + digit;
		}
		return reverse == original;
	}

}
