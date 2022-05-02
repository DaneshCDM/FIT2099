package game.currency;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 *  CoinPickUpItemAction manages pick up method for Coin
 *  @author Danesh Mariapan
 */
public class CoinPickUpItemAction extends Action {

    /**
     * Coin Object Attribute
     */
    private final Coin coin;

    /**
     * Constructor
     *
     * @param coin the item to pick up
     */
    public CoinPickUpItemAction(Coin coin) {
        this.coin = coin;
    }

    /**
     * Add our own Functionality - add coins to Wallet and display Balance
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String menu description
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        // Get location of Player
        map.locationOf(actor).removeItem(coin);

        // Check Inventory for Wallet
        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.getInventory().get(i) instanceof CoinWallet) {

                // Add Coin to Player's Wallet
                ((CoinWallet) actor.getInventory().get(i)).addCoin(coin);
                // Show Player's Current Wallet Balance
                ((CoinWallet) actor.getInventory().get(i)).displayWalletBalance();
            }
        }
        return menuDescription(actor);

    }

    /**
     *
     * @param actor The actor performing the action.
     * @return String description of Action taken place
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin;
    }

}
