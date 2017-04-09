package kumsher.ryan.googlecodejam.year2017.qualifying.problem.b;

import static org.junit.Assert.*;

import org.junit.Test;

public class TidyNumbersTest {

  private TidyNumbers tidyNumbers = new TidyNumbers();

  @Test
  public void sampleInputAndOutput() {
    tidyNumbers.solve("sample.in", "sample.out");
  }

  @Test
  public void smallInput() {
    tidyNumbers.solve("B-small-attempt0.in", "B-small-attempt0.out");
  }

  @Test
  public void largeInput() {
    tidyNumbers.solve("B-large.in", "B-large.out");
  }

}
