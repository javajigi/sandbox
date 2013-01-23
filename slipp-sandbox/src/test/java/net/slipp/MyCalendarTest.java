package net.slipp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

public class MyCalendarTest {
  @Test
  public void getHour() throws Exception {
    Calendar now = Calendar.getInstance();
    now.set(Calendar.HOUR_OF_DAY, 11);
    MyCalendar calendar = new MyCalendar(now);
    assertThat(calendar.getHour(), is(new Hour(11)));
  }
}