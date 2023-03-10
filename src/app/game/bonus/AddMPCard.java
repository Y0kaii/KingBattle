package app.game.bonus;

import app.game.Game;
import app.game.pawns.BasePawn;

public class AddMPCard implements ICard{

	@Override
	public String getEffect() {
		return "Vous octroie un PA de plus pour ce tour.";
	}

	@Override
	public void use(Game game) {
		game.getCurrentPlayer().setAP(game.getCurrentPlayer().getAP()+1);
	}
}
