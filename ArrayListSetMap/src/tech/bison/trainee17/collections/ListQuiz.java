package tech.bison.trainee17.collections;

import java.util.ArrayList;

public class ListQuiz {
  public ListQuiz() {
  }

  public static ArrayList<Question> askQuestions(int amountOfCcorrectAnswers) {
    int[] wins = { 5_000, 10_000, 15_000, 20_000, 30_000, 50_000, 100_000, 250_000, 500_000, 1_000_000 };
    String[] questions = { "films", "sports", "money", "music", "geography", "nature", "history", "technology", "maths",
        "literature" };
    ArrayList<Question> corectAnswers = new ArrayList<Question>();

    for (int i = 0; i <= amountOfCcorrectAnswers; i++) {
      corectAnswers.add(new Question(questions[i], wins[i]));
    }
    return corectAnswers;
  }

}
