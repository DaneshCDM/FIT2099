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

        int balance = 0;
        int deduct = 0;
        int remainingBalance = 0;
        String result = "You don't have enough coins!";

        for(int i = 0; i < actor.getInventory().size(); i++){

            if(actor.getInventory().get(i) instanceof CoinWallet){
                balance = ((CoinWallet) actor.getInventory().get(i)).displayWalletBalance();
            }
        }

        if(balance >= price){
            actor.addItemToInventory(tradeItem);

            int k = ((CoinWallet) actor.getInventory().get(0)).getHashMap().size() + 1;
            while(deduct < price){
                if(actor.getInventory().get(0) instanceof CoinWallet){

                    if (((CoinWallet) actor.getInventory().get(0)).getHashMap().get(k)!= null){
                        deduct += ((CoinWallet) actor.getInventory().get(0)).getHashMap().get(k).getValue();
                        ((CoinWallet) actor.getInventory().get(0)).getHashMap().remove(k);
                    }
                }
                k--;
            }

            remainingBalance = balance - deduct;
            System.out.println("Player's remaining Wallet Balance is: " + "$" + remainingBalance);
            result = actor + " has purchased " + tradeItem + " for " + "$" + price;
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Buy " + tradeItem + " for " + "$" + price;
    }




}
