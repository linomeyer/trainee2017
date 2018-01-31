import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VocalCounterTest {

  @Test
  public void test() throws Exception {
    String word = "HALLO MEIN NAME IST KISAN";

    int vocalCounter = VocalCounter.count(word);

    assertThat(vocalCounter, is(9));
  }

}
