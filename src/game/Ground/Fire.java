package game.Ground;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;

public class Fire extends Ground{
    int duration;
    public static Boolean pipe=false;
    /**
     * Constructor.
     *
     */
    public Fire() {
        super('v');
        duration=3;
    }

    @Override
    public void tick(Location location){
        if (duration>0){
            duration-=1;
        } else{
            location.setGround(new Dirt());
        }
    }

}
