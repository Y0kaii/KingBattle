package app.game.pawns;

import app.game.weapons.Weapon;

public class Knight extends BasePawn{

	/**
	 * 
	 * @param health
	 * @param armor
	 * @param weapon
	 * @param model
	 */
	public Knight(int health, int armor, Weapon weapon, String model) {
		super(150, 25, weapon, "♘");
	}

}