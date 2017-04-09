package kumsher.ryan.googlecodejam.year2017.qualifying.problem.b;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class TidyNumbersTest {

  private TidyNumbers tidyNumbers = new TidyNumbers();

  @Test
  public void sampleInputAndOutput() {
    tidyNumbers.solve("sample.in", "sample.out");
    List<String> actual = CodeJamFileUtils.readProblem("sample.out", 2017, "qualifying", "b");
    List<String> expected = CodeJamFileUtils.readProblem("sample-solution.out", 2017, "qualifying", "b");
    assertThat(actual, is(expected));
  }

  @Test
  public void smallInput() {
    tidyNumbers.solve("B-small-attempt0.in", "B-small-attempt0.out");
    List<String> actual = CodeJamFileUtils.readProblem("B-small-attempt0.out", 2017, "qualifying", "b");
    List<String> expected = CodeJamFileUtils.readProblem("B-small-attempt0-correct.out", 2017, "qualifying", "b");
    assertThat(actual, is(expected));
  }

  @Test
  public void largeInput() {
    tidyNumbers.solve("B-large.in", "B-large.out");
    List<String> actual = CodeJamFileUtils.readProblem("B-large.out", 2017, "qualifying", "b");
    List<String> expected = CodeJamFileUtils.readProblem("B-large-correct.out", 2017, "qualifying", "b");
    assertThat(actual, is(expected));
  }

}
