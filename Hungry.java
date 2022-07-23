package q3;
//ofri rom:208891804
//avigail shekasta:209104314
public class Hungry implements HungerState{
    @Override
    public void doaction(Swimmable i) {
        /**
         * this method is make the fish run after the worm if it's hungry
         */
        if(Fish.food){
            i.swim_after_worm();
        }
        else
            i.swim();
    }
}
