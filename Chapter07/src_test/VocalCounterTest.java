import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VocalCounterTest {

  @Test
  public void string_countVocals_numberOfVocals() throws Exception {
    String sentence = "HALLO MEIN NAME IST KISAN";

    int vocalCounter = VocalCounter.count(sentence);

    assertThat(vocalCounter, is(9));
  }

}
