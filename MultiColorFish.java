package q3;

public class MultiColorFish extends Fish{
    public MultiColorFish( int size,int DISTANCE_EAT, int horSpeed, int verSpeed, int col,int f) {
        super( size,DISTANCE_EAT, horSpeed, verSpeed, col,f);
    }

    public String getAnimalName() {
        return "MultiColorFish";
    }
    public void eatInc() {
        if(getDISTANCE_EAT()==getEatCount())
            changeColor();
        super.eatInc();
    }
}
