package kumsher.ryan.googlecodejam.year2019.qualifying.problem.a;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ForegoneSolutionSolverTest {

  private ForegoneSolutionSolver solver = new ForegoneSolutionSolver();

  @Test
  public void when4_Returns3And1() {
    assertThat(solver.solve(4), is("3 1"));
  }

  @Test
  public void when940_Returns939And1() {
    assertThat(solver.solve(940), is("939 1"));
  }

  @Test
  public void when4444_Returns3939And505() {
    assertThat(solver.solve(4444), is("3939 505"));
  }

  @Test
  public void when444444444_Returns393939393And50505051() {
    assertThat(solver.solve(444444444), is("393939393 50505051"));
  }
}