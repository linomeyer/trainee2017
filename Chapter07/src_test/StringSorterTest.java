import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringSorterTest {

  @Test
  public void threeStrings_sort_threeStringsSorted() throws Exception {
    String[] words = { "Lino", "Lars", "Luca" };

    String[] sortedStrings = StringSorter.sort(words);

    assertThat(sortedStrings[0], is("Lars"));
    assertThat(sortedStrings[1], is("Lino"));
    assertThat(sortedStrings[2], is("Luca"));
  }

  @Test
  public void fiveStrings_sort_fiveStringsSorted() throws Exception {
    String[] words = { "Silvan", "Lars", "Reto", "Luca", "Lino" };

    String[] sortedStrings = StringSorter.sort(words);

    assertThat(sortedStrings[0], is("Lars"));
    assertThat(sortedStrings[1], is("Lino"));
    assertThat(sortedStrings[2], is("Luca"));
    assertThat(sortedStrings[3], is("Reto"));
    assertThat(sortedStrings[4], is("Silvan"));
  }
}