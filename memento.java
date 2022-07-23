package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import java.awt.*;
//this class return object parameters saved
public class memento {
    String type;
    Color col;
    int size;
    int horSpeed;
    int verSpeed;
    int x_front;
    int y_front;


        public memento(String type, int size,int x_front, int y_front, Color col,int horSpeed, int verSpeed){
            /**
             * constructor for animal parameters
             */
            this.type=type;
            this.size=size;
            this.x_front=x_front;
            this.y_front=y_front;
            this.col=col;
            this.horSpeed=horSpeed;
            this.verSpeed=verSpeed;
        }
    public memento(String type, int size,int x_front, int y_front){
        /**
         * constructor for planets parameters
         */
        this.type=type;
        this.size=size;
        this.x_front=x_front;
        this.y_front=y_front;
        this.col=Color.GREEN;

    }
    public String get_type(){return type;}
    public Color get_Colorr(){return col;}
    public int get_horSpeed(){return horSpeed;}
    public int get_verSpeed(){return verSpeed;}
    public int get_x_front(){return x_front;}
    public int get_y_front(){return y_front;}
    public int get_size(){return size;}
}
