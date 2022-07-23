package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import java.awt.*;

public class Laminaria extends Immobile{
    int size;
    int x;
    int y;
    public Color colorr = Color.GREEN;

    public Laminaria(int size,int x,int y){
        /**
         * constructor
         */
        super("Laminaria");
        this.size=size;
        this.x=x;
        this.y=y;
    }
    @Override
    public memento saveStateToMemento() {
        return new memento("Zostera",size,x, y);
    }

    @Override
    public void getStateFromMemento(memento m) {
        size=m.get_size();
        x=m.get_x_front();
        y=m.get_y_front();
        colorr=m.get_Colorr();

    }

    public void draw(Graphics g){
        /**
         * draw the planet on the panel
         */
        g.setColor(colorr);
        g.fillArc(x-size/20,y-size,size/10,size*4/5,0,360);
        g.fillArc(x-size*3/20,y-size*13/15,size/10,size*2/3,0,360);
        g.fillArc(x+size/20,y-size*13/15,size/10,size*2/3,0,360);
        g.drawLine(x,y,x,y-size/5);
        g.drawLine(x,y,x-size/10,y-size/5);
        g.drawLine(x,y,x+size/10,y-size/5);
    }

    @Override
    public void drawCreature(Graphics g) {
        /**
         * call the draw method via the interface
         */
        draw(g);
    }
    public Laminaria(){
        /**
         * super constructor
         */
        super("Laminaria");
    }
    @Override
    public void set_obj(int size, int x, int y) {
        /**
         * set the object parameters
         */
        name="Laminaria";
        this.size=size;
        this.x=x;
        this.y=y;

    }

    @Override
    public int get_size() {
        return size;
    }

    @Override
    public int get_x() {
        return x;
    }

    @Override
    public int get_y() {
        return y;
    }
}
