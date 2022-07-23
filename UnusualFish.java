package q3;

public class UnusualFish extends Fish{
    private int factor;
    public UnusualFish(int size,int DISTANCE_EAT, int horSpeed, int verSpeed, int col,int factor,int f) {
        super(size,DISTANCE_EAT, horSpeed,  verSpeed, col,f);
        this.factor=factor;
    }

    public String getAnimalName() {
        return "UnusualFish";
    }
    public int getFactor() {
        return factor;
    }
    public void setFactor(int factor) {
        this.factor = factor;
    }
    public int getSize(){
        return factor*super.getSize();
    }
}
