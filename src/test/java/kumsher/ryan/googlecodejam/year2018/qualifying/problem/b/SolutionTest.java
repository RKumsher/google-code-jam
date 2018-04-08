package kumsher.ryan.googlecodejam.year2018.qualifying.problem.b;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.Lists;

public class SolutionTest {

  private Solution solver = new Solution();

  @Test
  public void solve_56643_ReturnsOk() {
    assertThat(solver.solve(Lists.newArrayList(5, 6, 6, 4, 3)), is("OK"));
  }

  @Test
  public void solve_56843_ReturnsOk() {
    assertThat(solver.solve(Lists.newArrayList(5, 6, 8, 4, 3)), is("OK"));
  }

  @Test
  public void solve_897_ReturnsOne() {
    assertThat(solver.solve(Lists.newArrayList(8, 9, 7)), is("1"));
  }
}