package q3;
//ofri rom:208891804
//avigail shekasta:209104314
// an abstract class that represent the sea planets
public abstract class Immobile implements SeaCreature{
    String name;


    public Immobile(String name){
        /**
         * Immobile class constructor
         */
        this.name=name;
    }

    public abstract void set_obj(int size,int x,int y);
    public String get_name(){return name;}
    public abstract int get_size();
    public abstract int get_x();
    public abstract int get_y();
    public abstract memento saveStateToMemento();
    public abstract void getStateFromMemento(memento m);


}
