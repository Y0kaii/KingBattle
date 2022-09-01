package app.game.pawns;

import app.game.weapons.Weapon;

public class Queen extends BasePawn{

	/**
	 * 
	 * @param health
	 * @param armor
	 * @param weapon
	 * @param model
	 */
	public Queen(int health, int armor, Weapon weapon, String model) {
		super(175, 25, weapon, "♕");
	}

}
