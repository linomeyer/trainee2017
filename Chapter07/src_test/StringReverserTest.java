import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringReverserTest {

  @Test
  public void string_reverse_stringBackwards() {
    String sentence = "Hallo ich heisse Kisan";

    String sentenceBackwards = StringReverser.reverse(sentence);

    assertThat(sentenceBackwards, is("nasiK essieh hci ollaH"));
  }
}
