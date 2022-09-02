package app.game.pawns;

import app.game.graphics.Board;
import app.game.weapons.BaseWeapon;

public abstract class BasePawn {
	/**
	 * 
	 */
	// class attributes
	private int m_health;
	private int m_armor;
	private BaseWeapon m_weapon;
	private String m_model;
	private int m_x;
	private int m_y;
	private PawnColors m_color;
	
	
	// constrcutor(s)
	public BasePawn (int health, int armor, BaseWeapon weapon, String model, int x, int y, PawnColors color) {
		this.m_health = health;
		this.m_armor = armor;
		this.m_weapon = weapon;
		this.m_model = model;
		this.m_x = x;
		this.m_y = y;
		this.m_color = color;
	}
	
	public BasePawn (int health, int armor, BaseWeapon weapon, String model, int x, int y) {
		this(health, armor, weapon, model, x, y, PawnColors.BLACK);
	}
	
	// methods 
	
	public void setColor(PawnColors color) {
		this.m_color = color;
	}
	
	public int getX() { return this.m_x; }
	public int getY() { return this.m_y; }
	
	public void setX(int newX) { this.m_x = newX; }
	public void setY(int newY) { this.m_y = newY; }
	
	public String getColor() { return this.m_color.getColor(); }
	
	public boolean isDead() {
		return this.getHealth() <= 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHealth() {
		return m_health;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setHealth(int health) {
		this.m_health = health;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getArmor() {
		return m_armor;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setArmor(int armor) {
		this.m_armor = armor;
	}
	
	/**
	 * 
	 * @return
	 */
	public BaseWeapon getWeapon() {
		return m_weapon;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setWeapon(BaseWeapon weapon) {
		this.m_weapon = weapon;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getModel() {
		return m_model;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setModel(String model) {
		this.m_model = model;
	}
	
	public String toString() {
		return this.m_model;
	}
	
	public boolean attack(int x, int y, Board board) {
		boolean res = false;
		BasePawn pawnToAttack =  board.getPawn(x, y);
		// s'il y a un pion aux coordonnées prises en paramètres, il est possible de l'attaquer.
		if (pawnToAttack != null && this.rangeToAttack(pawnToAttack)) {
			// on affecte la différence entre les pvs du pion ciblé et des dégâts de l'arme du pion courant à la vie du pion ciblé.
			pawnToAttack.setHealth(Math.abs(pawnToAttack.getHealth() - this.getWeapon().getDamage()));
			// si un pion tombe à 0 pv, il meurt et supprimé du plateau de jeu.
			if (pawnToAttack.isDead()) {
				pawnToAttack = null;
			}
			res = true;
		}
		return res;
	}
	
	public boolean rangeToAttack(BasePawn pawnToAttack) {
		boolean isInRange = false;
		// Si le pion ciblé se situe dans la zone d'action du pion courant, alors le pion courant peut attaquer le pion ciblé
		if (Math.abs(this.getX() - pawnToAttack.getX()) <= this.getWeapon().getRange() || Math.abs(this.getY() - pawnToAttack.getY()) <= this.getWeapon().getRange()) {
			isInRange = true;
		}
		return isInRange;
	}
	
}
