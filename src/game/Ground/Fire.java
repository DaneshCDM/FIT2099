package game.Ground;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;

public class Fire extends Ground implements Resettable {
    Boolean reset=false;
    int duration=3;
    public static Boolean pipe=false;
    /**
     * Constructor.
     *
     */
    public Fire() {
        super('v');
        this.registerInstance();
    }

    @Override
    public void tick(Location location){
        if (reset){
            location.setGround(new Dirt());
        }

        if (duration>0){
            duration-=1;
        } else{
            location.setGround(new Dirt());
        }
    }
    @Override
    public void resetInstance() {
        reset=true;
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
