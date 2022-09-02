package app.game;

import java.util.ArrayList;

import app.game.graphics.Board;
import app.game.pawns.BasePawn;
import app.game.pawns.Bishop;
import app.game.pawns.King;
import app.game.pawns.Knight;
import app.game.pawns.PawnColors;
import app.game.players.Player;

public class GameManager {
	private Game game;
	private Player currentPlayer;
	
	public GameManager() {
		this.game = new Game();
		this.game.getPlayers()[0] = new Player("John", PawnColors.BLACK);
		this.game.getPlayers()[1] = new Player("Doe", PawnColors.WHITE);
		Player playerOne = this.game.getFirstPlayer();
		Player playerTwo = this.game.getSecondPlayer();
		playerOne.addPawn(new King(3,0));
		playerOne.addPawn(new Bishop(4,0));
		playerTwo.addPawn(new King(3,7));
		this.currentPlayer = playerOne;
	}
	
	public void startGame() {
		this.popPawns();
	}
	
	public void nextRound() {
		
	}
	
	public void popPawns() {
		Board board = this.game.getBoard();
		ArrayList<BasePawn> playerOnePawns = this.game.getFirstPlayer().getPawns();
		ArrayList<BasePawn> playerTwoPawns = this.game.getSecondPlayer().getPawns();
		for(BasePawn pawns : playerOnePawns) {
			board.addPawn(pawns);
		}
		for(BasePawn _pawns : playerTwoPawns) {
			board.addPawn(_pawns);
		}
		this.game.getBoard().displayBoard();
	}
}
