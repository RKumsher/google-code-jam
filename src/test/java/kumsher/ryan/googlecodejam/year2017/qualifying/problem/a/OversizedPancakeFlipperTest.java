package kumsher.ryan.googlecodejam.year2017.qualifying.problem.a;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class OversizedPancakeFlipperTest {

  private OversizedPancakeFlipper flipper = new OversizedPancakeFlipper();

  @Test
  public void sampleInputAndOutput() {
    flipper.solve("sample.in", "sample.out");
    List<String> actual = CodeJamFileUtils.readProblem("sample.out", 2017, "qualifying", "a");
    List<String> expected = CodeJamFileUtils.readProblem("sample-solution.out", 2017, "qualifying", "a");
    assertThat(actual, is(expected));
  }

  @Test
  public void smallInput() {
    flipper.solve("A-small-attempt0.in", "A-small-attempt0.out");
    List<String> actual = CodeJamFileUtils.readProblem("A-small-attempt0.out", 2017, "qualifying", "a");
    List<String> expected = CodeJamFileUtils.readProblem("A-small-attempt0-correct.out", 2017, "qualifying", "a");
    assertThat(actual, is(expected));
  }

  @Test
  public void largeInput() {
    flipper.solve("A-large.in", "A-large.out");
    List<String> actual = CodeJamFileUtils.readProblem("A-large.out", 2017, "qualifying", "a");
    List<String> expected = CodeJamFileUtils.readProblem("A-large-correct.out", 2017, "qualifying", "a");
    assertThat(actual, is(expected));
  }

}
