package pawns;

import weapons.Weapon;

public class Pawn extends BasePawn{

	/**
	 * 
	 * @param health
	 * @param armor
	 * @param weapon
	 * @param model
	 */
	public Pawn(int health, int armor, Weapon weapon, char model) {
		super(50, 0, weapon, '♗');
	}

}