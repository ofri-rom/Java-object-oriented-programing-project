package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import javax.swing.*;

public class Singleton {
    private static Singleton instance = null;
    ImageIcon img;
    private Singleton(){
        /**
         * private constructor
         */
        img=new ImageIcon("src/q3/worm-removebg-preview.png");
    }
    public static Singleton getInstance( ) {
        /**
         * this method check if the instance is null if it null we call the private constructor if not we return the already init instance
         */
        if(instance == null)
            instance = new Singleton();
        return instance; }
}
