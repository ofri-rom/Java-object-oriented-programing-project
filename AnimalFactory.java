package q3;
//ofri rom:208891804
//avigail shekasta:209104314
//this class include the factory method
public class AnimalFactory implements AbstractSeaFactory{
    @Override
    public Swimmable produceSeaCreature(String type) {
        /**
         * this method belong to abstract sea factory interface and override here the method produce creature according to the string type parameter
         */
        if(type=="Fish")
            return new Fish();
        else if(type=="Jellyfish")
            return new Jellyfish();
        return null;
    }
}
