package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class CareTaker {
    //here the objects of memento are saved for restore theme later
    public static ArrayList <memento> moment = new ArrayList<>();

    public void add(memento Memento ){
        /**
         * this method add memento object to the list
         */
        moment.add(Memento);
    }
    public memento get(int i){
        /**
         * this method return memento object from the list
         */
        return moment.get(i);
    }
}
