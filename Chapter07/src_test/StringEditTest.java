import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringEditTest {
  @Test
  public void testName() throws Exception {
    String sentence = "Mein Name ist Kisan";

    String vocalRemover = StringEdit.removeVocals(sentence);

    assertThat(vocalRemover, is("M__n N_m_ _st K_s_n"));
  }

  @Test
  public void string_reverse_stringBackwards() {
    String sentence = "Hallo ich heisse Kisan";

    String backwardsSentence = StringEdit.reverse(sentence);

    assertThat(backwardsSentence, is("nasiK essieh hci ollaH"));
  }

  @Test
  public void test() throws Exception {
    String str1 = "Lino";
    String str2 = "Lars";
    String str3 = "Luca";

    String[] sortedStrings = StringEdit.sort(str1, str2, str3);

    assertThat(sortedStrings[0], is("Lars"));
    assertThat(sortedStrings[1], is("Lino"));
    assertThat(sortedStrings[2], is("Luca"));
  }

}