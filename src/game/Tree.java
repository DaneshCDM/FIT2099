package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import java.util.Random;

public class Tree extends Ground {
    TreeTypes treeState;
    int tickcount;
    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
        treeState=TreeTypes.SPROUT;
        tickcount=0;
    }

    public int getTick() {
        return tickcount;
    }

    @Override
    public void tick(Location location) {
        if (treeState==TreeTypes.DEAD){
            return;
        }

        //create random double for chance
        Random random=new Random();
        double probability=random.nextDouble();
        this.tickcount+=1;

        if (tickcount<=10){ //sprout
            sprout(probability,location);
        } else if (tickcount<=20){ //sapling
            sapling(probability,location);
            treeState=TreeTypes.SAPLING;
            super.setDisplayChar('t');
        } else { //mature
            mature(probability,location);
            treeState=TreeTypes.MATURE;
            super.setDisplayChar('T');
        }
    }

    public void sprout(double probability, Location location){
        if (probability<=0.1 & !location.containsAnActor()){ //10% chance to spawn goomba
            location.addActor(new Goomba());
        }
    }

    public void sapling(double probability, Location location){
        if (tickcount>10 & tickcount<=20){ //sapling stage
            treeState=TreeTypes.SAPLING;
            if (probability<=0.1){ //10% chance to spawn $20 coin
                //todo location.addItem(new Coin());
            }
        }
    }

    public void mature(double probability, Location location){
        if (this.tickcount>=20){ //mature stage
            treeState=TreeTypes.MATURE;
            if (probability<=0.15 & !location.containsAnActor()){ //15% chance to spawn koopa
                //todo location.addActor(new Koopa());
            }

            if (this.tickcount%5==0){ //turn tiles around it
                //for i in location.getExits.getDestination().getground() returns the ground type of the exits
            }

            if (probability<=0.2){ //chance to wither
                treeState=TreeTypes.DEAD;
                super.setDisplayChar('.');
            }
        }
    }
}
