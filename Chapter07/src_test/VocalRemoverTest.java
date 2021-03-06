import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VocalRemoverTest {

  @Test
  public void string_removeVocals_stringWithoutVocals() throws Exception {
    String sentence = "Mein Name ist Kisan";

    String sentenceWithoutVocals = VocalRemover.remove(sentence);

    assertThat(sentenceWithoutVocals, is("Mn Nm st Ksn"));
  }
}
