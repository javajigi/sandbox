package net.slipp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HourTest {
  @Test
  public void 오전() throws Exception {
    Hour hour = new Hour(11);
    assertThat(hour.getMessage(), is("오전"));
  }

  @Test
  public void 오후() throws Exception {
    Hour hour = new Hour(16);
    assertThat(hour.getMessage(), is("오후"));
  }
}