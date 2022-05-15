package game.Ground;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class Teleportation extends Action {

    WarpPipe teledestination;
    WarpPipe teledeparture;

    public Teleportation(WarpPipe destination, WarpPipe departure) {
        this.teledestination = destination;
        this.teledeparture = departure;
    }

    public WarpPipe getTeledestination() {
        return teledestination;
    }

    public void setTeledestination(WarpPipe teledestination) {
        this.teledestination = teledestination;
    }

    public WarpPipe getTeledeparture() {
        return teledeparture;
    }

    public void setTeledeparture(WarpPipe teledeparture) {
        this.teledeparture = teledeparture;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, this.teledestination.getLocation());
        this.teledestination.destination = this.teledeparture; // to allow travel back to the last/previous pipe that teleported you before
        return actor + " teleports to " + this.teledestination;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports to " + this.teledestination;
    }
}
