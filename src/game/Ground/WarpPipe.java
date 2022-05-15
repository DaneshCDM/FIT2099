package game.Ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;

public class WarpPipe extends Ground implements Resettable {

    String map;
    Location location;
    WarpPipe destination;
    WarpPipe departure = this;

    public WarpPipe(String map) {
        super('C');
        this.map = map;
        this.registerInstance();
    }

    public WarpPipe(WarpPipe destination) {
        super('C');
        this.destination = destination;
        this.registerInstance();
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if (location.containsAnActor() == true) {
            actions.add(new Teleportation(destination, departure));
        }
        return actions;
    }

    @Override
    public void tick(Location location) {
        this.location = location;
        super.tick(location);
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public WarpPipe getDestination() {
        return destination;
    }

    public void setDestination(WarpPipe destination) {
        this.destination = destination;
    }

    public WarpPipe getDeparture() {
        return departure;
    }

    public void setDeparture(WarpPipe departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "WarpPipe is on " + map;
    }

    @Override
    public void resetInstance() {}

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
