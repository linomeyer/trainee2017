package tech.bison.trainee17.collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class ListQuizTest {

  @Test
  public void quiz_AskQuestionForQuestion_cancelQuizWithWrongAnswer() {
    ArrayList<Question> corectAnswers;
    int amountOfCcorrectAnswers = (int) (Math.random() * 11);

    corectAnswers = ListQuiz.askQuestions(amountOfCcorrectAnswers);

    assertThat(corectAnswers.size(), is(amountOfCcorrectAnswers));
  }
}
