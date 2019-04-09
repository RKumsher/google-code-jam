package kumsher.ryan.googlecodejam.year2019.qualifying.problem.b;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class YouCanGoYouOwnWaySolverTest {

  private YouCanGoYouOwnWaySolver solver = new YouCanGoYouOwnWaySolver();

  @Test
  public void whenSe_ReturnsEs() {
    assertThat(solver.solve("SE"), is("ES"));
  }

  @Test
  public void whenEesssese_ReturnsEesssese() {
    assertThat(solver.solve("EESSSESE"), is("SSEEESES"));
  }
}