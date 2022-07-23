package q3;
import java.awt.*;
//ofri rom:208891804
//avigail shekasta:209104314
public class Zostera extends Immobile {
    int size;
    int x;
    int y;
    public Color colorr = Color.GREEN;

    public Zostera(int size,int x,int y){
        /**
         * constructor
         */
        super("Zostera");
        this.size=size;
        this.x=x;
        this.y=y;
    }
    public Zostera(){
        /**
         * call the super constructor for init the name
         */
        super("Zostera");
    }

    public void draw(Graphics g){
        /**
         * draw the sea planet on the panel
         */
        Graphics2D g2 = ( Graphics2D ) g ;
        g2.setStroke ( new BasicStroke ( 3 ) ) ;
        g2.setColor ( colorr ) ;
        g.drawLine ( x , y , x , y - size ) ;
        g.drawLine ( x - 2 , y , x - 10 , y - size * 9 / 10 ) ;
        g.drawLine ( x + 2 , y , x + 10 , y - size * 9 / 10 ) ;
        g.drawLine ( x - 4 , y , x - 20 , y - size * 4 / 5 ) ;
        g.drawLine ( x + 4 , y , x + 20 , y - size * 4 / 5 ) ;
        g.drawLine ( x - 6 , y , x - 30 , y - size * 7 / 10 ) ;
        g.drawLine ( x + 6 , y , x + 30 , y - size * 7 / 10 ) ;
        g.drawLine ( x - 8 , y , x - 40 , y - size * 4 / 7 ) ;
        g.drawLine ( x + 8 , y , x + 40 , y - size * 4 / 7 ) ;
        g2.setStroke ( new BasicStroke ( 1 ) ) ;
    }

    @Override
    public void drawCreature(Graphics g) {
        /**
         * call the draw method via the interface
         */
        draw(g);
    }

    @Override
    public void set_obj(int size, int x, int y) {
        /**
         *set this object parameters
         */
        name="Zostera";
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
}
