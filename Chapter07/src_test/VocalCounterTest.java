import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VocalCounterTest {
  @Test
  public void sentenceWithUpercasesVocals_countVocals_numberOfVocals() throws Exception {
    String sentence = "HALLO MEIN NAME IST KISAN";

    int numberOfVocals = VocalCounter.count(sentence);

    assertThat(numberOfVocals, is(9));
  }

  @Test
  public void sentenceWithUppercasesAndLowercasesVocals_countVocals_numberOfVocals() throws Exception {
    String sentence = "Hallo Mein Name Ist Kisan";

    int numberOfVocals = VocalCounter.count(sentence);

    assertThat(numberOfVocals, is(9));
  }

  @Test
  public void sentenceWithLowercasesVocals_countVocals_numberOfVocals() throws Exception {
    String sentence = "hallo ich bins";

    int numberOfVocals = VocalCounter.count(sentence);

    assertThat(numberOfVocals, is(4));
  }
}
