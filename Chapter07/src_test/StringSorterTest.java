import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringSorterTest {

  @Test
  public void threeStrings_sort_threeStringsSorted() throws Exception {
    String str1 = "Lino";
    String str2 = "Lars";
    String str3 = "Luca";
    String[] strings = { str1, str2, str3 };

    String[] sortedStrings = StringSorter.sort(strings);

    assertThat(sortedStrings[0], is("Lars"));
    assertThat(sortedStrings[1], is("Lino"));
    assertThat(sortedStrings[2], is("Luca"));
  }

  @Test
  public void fiveStrings_sort_threeStringsSorted() throws Exception {
    String str1 = "Silvan";
    String str2 = "Lars";
    String str3 = "Reto";
    String str4 = "Luca";
    String str5 = "Lino";
    String[] strings = { str1, str2, str3, str4, str5 };

    String[] sortedStrings = StringSorter.sort(strings);

    assertThat(sortedStrings[0], is("Lars"));
    assertThat(sortedStrings[1], is("Lino"));
    assertThat(sortedStrings[2], is("Luca"));
    assertThat(sortedStrings[3], is("Reto"));
    assertThat(sortedStrings[4], is("Silvan"));
  }
}