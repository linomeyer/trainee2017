import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringSortTest {
  @Test
  public void test() throws Exception {
    String str1 = "Lino";
    String str2 = "Lars";
    String str3 = "Luca";

    String[] sortedStrings = StringSort.sort(str1, str2, str3);

    assertThat(sortedStrings[0], is("Lars"));
    assertThat(sortedStrings[1], is("Lino"));
    assertThat(sortedStrings[2], is("Luca"));
  }
}
