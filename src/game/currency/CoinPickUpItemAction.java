package game.currency;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;

public class CoinPickUpItemAction extends PickUpItemAction {

    private final Coin coin;


    /**
     * Constructor.
     *
     * @param coin the item to pick up
     */
    public CoinPickUpItemAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }



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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin;
    }
}
