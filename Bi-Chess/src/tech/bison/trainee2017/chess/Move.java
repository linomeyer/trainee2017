package tech.bison.trainee2017.chess;

import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;

public class Move {
  final Piece piece;
  final Piece capturedPiece;
  final Movement movement;

  private Move(Piece piece, Piece capturedPiece, Movement movement) {
    this.piece = piece;
    this.capturedPiece = capturedPiece;
    this.movement = movement;
  }

  public static Move movePiece(Chessboard chessboard, Movement movement)
      throws InvalidMoveException, InvalidSquareException, WhiteBeginsException {
    return movePiece(chessboard, movement, null);
  }

  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove)
      throws InvalidMoveException, InvalidSquareException, WhiteBeginsException {
    Square start = movement.start;

    try {
      if (lastMove == null && chessboard.getPiece(start).color.equals(Color.BLACK)) {
        throw new WhiteBeginsException();
      }

      Piece pieceToMove = chessboard.getPiece(start);

      boolean isAValidMove = pieceToMove.isAValidMove(movement);

      if (isAValidMove) {
        try {
          if (pieceToMove.hasSameColor(chessboard.getPiece(movement.end))) {
            throw new InvalidMoveException();
          } else {
            Piece capturedPiece = chessboard.movePiece(movement);
            return new Move(pieceToMove, capturedPiece, movement);
          }
        } catch (NullPointerException e) {
          Piece capturedPiece = chessboard.movePiece(movement);
          return new Move(pieceToMove, capturedPiece, movement);
        }
      } else {
        throw new InvalidMoveException();
      }
    } catch (NullPointerException e) {
      throw new InvalidMoveException();
    }
  }

}