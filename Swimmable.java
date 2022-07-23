package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import java.awt.*;
import java.util.Vector;
import java.util.concurrent.CyclicBarrier;

public abstract class Swimmable extends Thread implements SeaCreature,Cloneable, MarineAnimal {
    protected int horSpeed;
    protected int verSpeed;
    protected int f;
    private Vector<Listener>list=new Vector<Listener>();

    Listener aqua_panel;

    public Swimmable( ){
        /**
         * constructor
         */
        aqua_panel=AquaFrame.Panel;
        horSpeed=0;
        verSpeed=0;
    }
    public Swimmable(int horSpeed, int verSpeed,int f){
        /**
         * constructor with parameters
         */

        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        this.f=f;
    }
    public void registerObserver(Listener i){list.add(i);}
    public  synchronized void unregisterObserver(Listener i){
        list.remove(i);
    }
     void notifyObserver(String msg){
        for (Listener i:list)
            i.update(msg);
     }
    // declaration of abstract method
    public int getHorSpeed(){return horSpeed;}
    public int getVerSpeed(){return verSpeed;}
    public int getf(){return f;}
    

    public abstract int get_x_front();
    public abstract int get_y_front();
    public abstract Color get_Color();
    public abstract Color gettColor();
    public void setHorSpeed(int horSpeed) {
        this.horSpeed = horSpeed;
    }
    public void setVerSpeed(int verSpeed) {
        this.verSpeed = verSpeed;
    }
    public abstract void setColor(Color color) ;
    public abstract String getAnimalName();
    public abstract int getEatCount();
    public abstract int getSize();
    public abstract int getx_dir();
    public abstract String getColor();
    public abstract int getColorInt();
    public abstract void eatInc();
    public abstract void run();
    public abstract String to_string();
    public abstract void set_x_dir(int x);


    public abstract void swim();
    public abstract void swim_after_worm();
    public abstract void setx_front(int x_front);
    public abstract void sety_front(int y_front);
    public abstract void drawAnimal(Graphics g);
    public abstract void setSuspend();
    public abstract void setColo(Color col);
    public abstract void setResume();
    public abstract memento saveStateToMemento();
    public abstract void getStateFromMemento(memento m);

    public abstract void set_obj(int size,int DISTANCE_EAT,int horSpeed,int verSpeed,int col,int f);


    @Override
    public abstract Swimmable clone() ;


}
