package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.currency.CoinWallet;

/**
 * Class representing the Player.
 */
public class Player extends Actor  {

	private final Menu menu = new Menu();
	public static boolean resetchecker;

	// Player Starts with a Coin Wallet
	public static CoinWallet playerCoinWallet = new CoinWallet();



	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		resetchecker=true;

		this.addItemToInventory(playerCoinWallet);

		// Testing SpeakAction
//		this.addItemToInventory(new Wrench());
//		this.addCapability(Status.INVINCIBLE);


	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		/**
		 * reset ability
		 * @author Seow Zheng Hao
		 */
		if (resetchecker){
			actions.add(new ResetAction());
		}

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	public CoinWallet getPlayerCoinWallet() {
		return playerCoinWallet;
	}

	public void setPlayerCoinWallet(CoinWallet playerCoinWallet) {
		this.playerCoinWallet = playerCoinWallet;
	}
}
