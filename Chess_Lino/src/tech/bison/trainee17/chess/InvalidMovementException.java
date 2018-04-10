package tech.bison.trainee17.chess;

public class InvalidMovementException extends Exception {
  private static final long serialVersionUID = 1L;

  public InvalidMovementException() {
    super();
  }

  public InvalidMovementException(String string) {
    super(string);
  }

}
