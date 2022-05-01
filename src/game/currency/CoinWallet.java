package game.currency;


import java.util.HashMap;

public class CoinWallet {

    /**
     * A HashMap, containing pair values of an Integer (noCoins) and the Coin Object
     * that was picked up by the Player
     */
    private HashMap<Integer, Coin> hashMap;
    private int noCoins;


    /**
     * CoinWallet zero-parameter Constructor
     */
    public CoinWallet(){
        this.hashMap = new HashMap<Integer, Coin>();
        this.noCoins = 0;
    }

    public void addCoin(){

    }



}
