package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.SpeakAction;
import game.TradeAction;
import game.Wrench;
import game.magicalitems.PowerStar;
import game.magicalitems.SuperMushroom;

import java.util.HashMap;

/**
 *  Toad class manages everything to do with Toad and the Shop Items/Trading
 *  @author Danesh Mariapan
 */
public class Toad extends Actor {

    /**
     * Toad Attributes
     */
    private static final String NAME = "Toad";
    private static final Character DISPLAY_CHARACTER = 'O';
    private static final int HIT_POINTS = 1;
    private final HashMap<Item, Integer> shopHashMap = new HashMap<Item, Integer>();

    private static final int POWER_STAR_COST = 600;
    private static final int SUPER_MUSHROOM_COST = 400;
    private static final int WRENCH_COST = 200;

    /**
     * Constructor for Toad
     */
    public Toad() {
        super(NAME, DISPLAY_CHARACTER, HIT_POINTS);
        this.shopHashMap.put(new Wrench(), WRENCH_COST);
        this.shopHashMap.put(new SuperMushroom(), SUPER_MUSHROOM_COST);
        this.shopHashMap.put(new PowerStar("PowerStar", '*', false), POWER_STAR_COST);
    }

    /**
     * Override playTurn method
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DoNothingAction()
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Override ActionList method
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList newActions = new ActionList(new SpeakAction(this));
        for (Item shopItem: this.shopHashMap.keySet()) {
            int cost = this.shopHashMap.get(shopItem);
            newActions.add(new TradeAction(shopItem, cost));
        }

        return newActions;
    }




}
