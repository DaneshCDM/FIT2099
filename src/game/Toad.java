package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magicalitems.PowerStar;
import game.magicalitems.SuperMushroom;

import java.util.HashMap;

public class Toad extends Actor {

    private static final String NAME = "Toad";
    private static final Character DISPLAY_CHARACTER = 'O';
    private static final int HIT_POINTS = 1;
    private final HashMap<Item, Integer> shopHashMap = new HashMap<Item, Integer>();

    private static final int POWER_STAR_COST = 600;
    private static final int SUPER_MUSHROOM_COST = 400;
    private static final int WRENCH_COST = 200;

    /**
     * Constructor.
     */
    public Toad() {
        super(NAME, DISPLAY_CHARACTER, HIT_POINTS);
        this.shopHashMap.put(new Wrench(), WRENCH_COST);
        this.shopHashMap.put(new SuperMushroom("SuperMushroom", '^', false), SUPER_MUSHROOM_COST);
        this.shopHashMap.put(new PowerStar("PowerStar", '*', false), POWER_STAR_COST);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList newActions = new ActionList(new SpeakAction(this)); //TODO: add speak action
//        for (Item shopItem: this.shopHashMap.keySet()) {
//            int cost = this.shopHashMap.get(shopItem);
//            newActions.add(new TradeAction(ware, cost));
//        }

        return newActions;
    }

}
