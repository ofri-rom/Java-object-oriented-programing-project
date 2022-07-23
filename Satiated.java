package q3;
//ofri rom:208891804
//avigail shekasta:209104314
public class Satiated implements HungerState{
    boolean flag=true;

    @Override
    public  void doaction(Swimmable i) {
        /**
         * this method is make the fish run all over the aquarium when its satiated
         */
        i.swim();
    }
}
