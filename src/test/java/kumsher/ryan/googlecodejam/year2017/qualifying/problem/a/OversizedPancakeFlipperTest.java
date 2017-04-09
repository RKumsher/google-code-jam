package kumsher.ryan.googlecodejam.year2017.qualifying.problem.a;

import static org.junit.Assert.*;

import org.junit.Test;

public class OversizedPancakeFlipperTest {

  private OversizedPancakeFlipper flipper = new OversizedPancakeFlipper();

  @Test
  public void sampleInputAndOutput() {
    flipper.solve("sample.in", "sample.out");
  }

  @Test
  public void smallInput() {
    flipper.solve("A-small-attempt0.in", "A-small-attempt0.out");
  }

  @Test
  public void largeInput() {
    flipper.solve("A-large.in", "A-large.out");
  }

}
