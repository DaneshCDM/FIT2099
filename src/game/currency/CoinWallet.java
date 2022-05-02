package game.currency;
import java.util.HashMap;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;


public class CoinWallet extends Item{

    /**
     * A HashMap, containing pair values of an Integer (noCoins) and the Coin Object
     * that was picked up by the Player
     */
    private HashMap<Integer, Coin> hashMap;
    private int noCoins;

    private static final String NAME = "Player Coin Wallet";
    private static final Character DISPLAY_CHARACTER = 'Q';
    private static final boolean PORTABLE = false;


    /**
     * CoinWallet zero-parameter Constructor
     */
    public CoinWallet(){
        super(NAME, DISPLAY_CHARACTER, PORTABLE);
        this.hashMap = new HashMap<Integer, Coin>();
        this.noCoins = 0;
    }

    public void addCoin(Coin newCoin){
        // Increase Coin count
        noCoins += 1;
        // Put the Coin into the HashMap
        hashMap.put(noCoins, newCoin);
    }

    public int displayWalletBalance(){
        int totalWalletBalance = 20;

        if(noCoins > 0){
            for(int i = 1; i < hashMap.size(); i++) {
                int ownedCoinValue = (getHashMap().get(i).getValue());
                totalWalletBalance += ownedCoinValue;
            }
        }

        System.out.println("Player's Current Total Wallet Balance is: " + "$" + totalWalletBalance + " \n"
                + "With a total of: " + getNoCoins() + " Coins, in Player's Wallet");
        return totalWalletBalance;
    }


    // Setters and Getters

    public HashMap<Integer, Coin> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Integer, Coin> hashMap) {
        this.hashMap = hashMap;
    }

    public int getNoCoins() {
        return noCoins;
    }

    public void setNoCoins(int noCoins) {
        this.noCoins = noCoins;
    }








//    @Override
//    public String execute(Actor actor, GameMap map) {
//        return this.displayWalletBalance();
//    }
//
//    @Override
//    public String menuDescription(Actor actor) {
//        return "b";
//    }
}
