package kumsher.ryan.googlecodejam.year2018.qualifying.problem.a;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kumsher.ryan.googlecodejam.common.CodeJamFileUtils;

public class FirstSolutionTest {

  private FirstSolution solver = new FirstSolution();

  @Test
  public void sampleInputAndOutput() {
    solver.solve("sample.in", "sample.out");
    List<String> actual = CodeJamFileUtils.readProblem("sample.out", 2018, "qualifying", "a");
    List<String> expected = CodeJamFileUtils.readProblem("sample-solution.out", 2018, "qualifying", "a");
    assertThat(actual, is(expected));
  }

  @Test
  public void smallInput() {
    solver.solve("A-small-attempt0.in", "A-small-attempt0.out");
    List<String> actual = CodeJamFileUtils.readProblem("A-small-attempt0.out", 2018, "qualifying", "a");
//    List<String> expected = CodeJamFileUtils.readProblem("A-small-attempt0-correct.out", 2018, "qualifying", "a");
//    assertThat(actual, is(expected));
  }

  @Test
  public void whenShootsGreaterThanSheild_ReturnsImpossible() {
    assertThat(solver.solve("1 SS"), is("IMPOSSIBLE"));
  }

  @Test
  public void whenNoSwapsRequired_ReturnsZero() {
    assertThat(solver.solve("2 CS"), is("0"));
  }

}