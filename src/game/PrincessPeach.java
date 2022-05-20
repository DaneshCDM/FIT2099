package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class PrincessPeach extends Actor {

    /**
     * Princess Peach Attributes
     */
    private static final String NAME = "Princess Peach";
    private static final Character DISPLAY_CHARACTER = 'P';
    private static final int HIT_POINTS = 1;

    /**
     * Constructor for Princess Peach
     */
    public PrincessPeach() {
        super(NAME, DISPLAY_CHARACTER, HIT_POINTS);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

}
