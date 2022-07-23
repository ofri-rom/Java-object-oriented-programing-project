package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import java.awt.*;
// the implement of the decorator pattern
public class MarineAnimalDecorator implements MarineAnimal{
    public MarineAnimal animal;

    public MarineAnimalDecorator(MarineAnimal animal){
        /**
         * this method assign the object we got to be from the interface type
         */
        this.animal=animal;
    }

    @Override
    public void PaintFish(Color col) {
        /**
         * by the type of our object we change his color via the implement of this interface in jellyfish class or fish class
         */
        animal.PaintFish(col);

    }



}
