package kumsher.ryan.googlecodejam.year2012.round.one.problem.a;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class KingdomRush {
	private static final String INPUT_FILE = "B-small-attempt3.in";
	private static final String OUTPUT_FILE = "kingdom-rush-small.out";
	private static int testCases;

	public static void main(String[] args) throws IOException {
		List<String> outputLines = Lists.newArrayList();
		List<String> inputLines = readLines();

		int currentTestCase = 0;
		for (int i = 0; currentTestCase < testCases; i++) {
			currentTestCase++;
//			System.out.println(currentTestCase);
			int levels = Integer.parseInt(inputLines.get(i));
			List<String> levelLines = inputLines.subList(i + 1, i + levels + 1);
			Map<Integer, Integer> oneStarLevels = Maps.newHashMap();
			Map<Integer, Integer> twoStarLevels = Maps.newHashMap();
			for (int j = 0; j < levelLines.size(); j++) {
				String levelLine = levelLines.get(j);
				int seperator = levelLine.indexOf(' ');
				int easyLevelRequiredStars = Integer.valueOf(levelLine
						.substring(0, seperator));
				int hardLevelRequiredStars = Integer.valueOf(levelLine
						.substring(seperator + 1));
				oneStarLevels.put(j, easyLevelRequiredStars);
				twoStarLevels.put(j, hardLevelRequiredStars);
			}
			i = i + levels;
			outputLines.add("Case #" + currentTestCase + ": "
					+ solveProblem(oneStarLevels, twoStarLevels));
		}
		writeLines(outputLines);
	}

	private static String solveProblem(Map<Integer, Integer> oneStarLevels,
			Map<Integer, Integer> twoStarLevels) {
		int beatLevels = 0;
		int numOfStars = 0;

		while (!twoStarLevels.isEmpty()) {
			int beforeLevels = twoStarLevels.size();
			numOfStars = beatTwoStarLevels(oneStarLevels, twoStarLevels,
					numOfStars);
			int afterLevels = twoStarLevels.size();
			if (beforeLevels != afterLevels) {
				beatLevels = beatLevels + (beforeLevels - afterLevels);
				continue;
			}

			int beforeStars = numOfStars;
			numOfStars = beatOneStarLevel(oneStarLevels, twoStarLevels,
					numOfStars);
			if (beforeStars == numOfStars) {
				return "Too Bad";
			}
			beatLevels++;
		}

		return "" + beatLevels;
	}

	private static int beatTwoStarLevels(Map<Integer, Integer> oneStarLevels,
			Map<Integer, Integer> twoStarLevels, int numOfStars) {
		List<Integer> levelsToRemove = Lists.newArrayList();
		for (Integer levelNumber : twoStarLevels.keySet()) {
			int requiredStars = twoStarLevels.get(levelNumber);
			if (numOfStars >= requiredStars) {
				if (oneStarLevels.remove(levelNumber) == null) {
					numOfStars = numOfStars + 1;
				} else {
					numOfStars = numOfStars + 2;
				}
				levelsToRemove.add(levelNumber);
			}
		}
		for (Integer levelNumber : levelsToRemove) {
			twoStarLevels.remove(levelNumber);
		}
		return numOfStars;
	}

	private static int beatOneStarLevel(Map<Integer, Integer> oneStarLevels,
			Map<Integer, Integer> twoStarLevels, int numOfStars) {
		Integer levelToRemove = -1;
		for (Iterator<Entry<Integer, Integer>> levelIterator = oneStarLevels
				.entrySet().iterator(); levelIterator.hasNext();) {
			Entry<Integer, Integer> level = levelIterator.next();
			int levelNumber = level.getKey();
			int requiredStars = level.getValue();
			if (numOfStars >= requiredStars) {
				numOfStars = numOfStars + 1;
				levelToRemove = levelNumber;
				if (!twoStarLevels.containsKey(levelToRemove)) {
					System.out.println("ERROR");
				}
//				levelIterator.remove();
				break;
			}
		}
		if (levelToRemove != -1)
			oneStarLevels.remove(levelToRemove);
		return numOfStars;
	}

	public static List<String> readLines() throws IOException {
		List<String> inputLines = CodeJamFileUtils.readProblem(INPUT_FILE, 2012, "one", "a");
		testCases = Integer.parseInt(inputLines.remove(0));
		return inputLines;
	}

	public static void writeLines(List<String> outputLines) throws IOException {
		System.out.println(outputLines);
		CodeJamFileUtils.writeSolution(OUTPUT_FILE, 2012, "one", "a", outputLines);
	}
}
