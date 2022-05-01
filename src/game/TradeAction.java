package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currency.CoinWallet;

public class TradeAction extends Action {

    private final Item tradeItem;
    private final int price;

    public TradeAction(Item tradeItem, int price) {
        this.tradeItem = tradeItem;
        this.price = price;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

//    @Override
//    public String execute(Actor actor, GameMap map) {
//
//        String insufficientCoins = "You don't have enough coins!";
//
//        for (int i = 0; i < actor.getInventory().size(); i++) {
//            if (actor.getInventory().get(i) instanceof CoinWallet) {
//
//            }
//
//        return null;
//    }

//    @Override
//    public String menuDescription(Actor actor) {
//        return null;
//    }









//    public class TradeAction extends Action {
//        private final Item tradeItem;
//        private final Coin price;
//
//        public TradeAction(Item tradeItem, Coin price) {
//            this.tradeItem = tradeItem;
//            this.price = price;
//        }
//
//        @Override
//        public String execute(Actor actor, GameMap map) {
//            String result = "You don't have enough coins!";
//
//            WorldBank worldBank = WorldBank.getInstance();
//            Coin actorBalance = worldBank.getBalance(actor, price.getCoinType());
//            if (actorBalance != null && actorBalance.getValue() >= price.getValue()) {
//                actor.addItemToInventory(tradeItem);
//                worldBank.spendCoin(actor, actorBalance);
//                result = actor + " has purchased " + tradeItem + " for " + price.getDisplayChar() + price.getValue() + ".";
//            }
//
//            return result;
//        }
//
//        @Override
//        public String menuDescription(Actor actor) {
//            return actor + " buys " + tradeItem.toString().split("-", 2)[0] + " (" + price.getDisplayChar() + price.getValue() + ")";
//        }


}
