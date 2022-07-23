package q3;
//ofri rom:208891804
//avigail shekasta:209104314
//this class include the factory method
public class PlantFactory implements AbstractSeaFactory {
    @Override
    public Object produceSeaCreature(String type) {
        /**
         * this method belong to abstract sea factory interface and override here the method produce creature according to the string type parameter
         */
        if(type=="Zostera")
            return new Zostera();
        else if(type=="Laminaria")
            return new Laminaria();
        return null;
    }
}
