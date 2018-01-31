import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringBackwardsTest {

  @Test
  public void string_reverse_stringBackwards() {
    String sentence = "Hallo ich heisse Kisan";

    String backwardsSentence = StringBackwards.reverse(sentence);

    assertThat(backwardsSentence, is("nasiK essieh hci ollaH"));
  }

}
