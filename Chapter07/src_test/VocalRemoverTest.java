import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VocalRemoverTest {
  @Test
  public void testName() throws Exception {
    String sentence = "Mein Name ist Kisan";

    String vocalRemover = VocalRemover.remove(sentence);

    assertThat(vocalRemover, is("M__n N_m_ _st K_s_n"));
  }
}
