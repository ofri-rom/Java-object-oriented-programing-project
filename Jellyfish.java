package q3;
//ofri rom:208891804
//avigail shekasta:209104314

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Jellyfish extends Swimmable{
    private int DISTANCE_EAT;
    private int size;
    private int col;
    private Color color;
    private int eatCount;
    private int x_front=575;
    private int y_front=225;
    private int x_dir;
    private int y_dir;
    static boolean sleep=false;
    static boolean food=false;
    HungerState State=new Satiated();
    double m;
    int num;



    public Jellyfish(int size,int DISTANCE_EAT,int horSpeed,int verSpeed,int col,int f){
        /**
         * parameters constructor
         */
        super(horSpeed,verSpeed,f);
        this.DISTANCE_EAT=DISTANCE_EAT;
        this.size=size;
        this.col=col;
        this.x_front=0;
        this.y_front=0;
        eatCount=0;
        x_dir=1;
        y_dir=1;
        color=gettColor();
    }
    @Override
    public String to_string() {
        return " שם: Jellyfish  " +" צבע: "+getColor()+" גודל: "+String.valueOf(size)+" כמות אוכל לגדילה: "+String.valueOf(DISTANCE_EAT)+" מהירות אופקית: "+String.valueOf(horSpeed)+" מהירות אנכית: "+String.valueOf(verSpeed);
    }

    @Override
    public void set_x_dir(int x) {
        x_dir=x;
    }
    boolean flag=true;
    @Override
    public void swim() {
        /**
         * when the fish is not hungry this method called in the satiate state
         */
        AquaFrame.Panel.repaint();
        if(x_dir==1){
            //ריצפה
            if(x_front<1100 && y_front>350){
                flag=true;
                x_front+=horSpeed;
                y_front-=verSpeed;

            }
            //תקרה
            else if(x_front<1100 && y_front<50){
                flag=false;
                x_front+=horSpeed;
                y_front+=verSpeed;

            }
            //קיר
            else if(x_front>1100 && y_front<350 &&y_front>50){
                x_dir=0;
                x_front+=horSpeed;
                y_front+=verSpeed;

            }
            //פינה למעלה
            else if(x_front>1100 && y_front<50){
                x_dir=0;
                flag=false;
                x_front-=horSpeed;
                y_front+=verSpeed;
            }
            //פינה למטה
            else if(x_front>1100 && y_front>350){
                x_dir=0;
                flag=true;
                x_front-=horSpeed;
                y_front-=verSpeed;

            }
            //תקין
            else {
                if (flag==true){
                    x_front+=horSpeed;
                    y_front-=verSpeed;
                }
                else {
                    x_front+=horSpeed;
                    y_front+=verSpeed;
                }
            }
        }
        //מקרה שנייייי
        else {
            //ריצפה
            if(x_front>90 && y_front>350){
                flag=true;
                x_front-=horSpeed;
                y_front-=verSpeed;

            }
            //תקרה
            else if(x_front>90 && y_front<50){
                flag=false;
                x_front-=horSpeed;
                y_front+=verSpeed;

            }
            //קיר
            else if(x_front<90 && y_front<350 &&y_front>50){
                x_dir=1;
                x_front+=horSpeed;
                y_front+=verSpeed;

            }
            //פינה למעלה
            else if(x_front<90 && y_front<50){
                x_dir=1;
                flag=false;
                x_front+=horSpeed;
                y_front+=verSpeed;

            }
            //פינה למטה
            else if(x_front<90 && y_front>350){
                x_dir=1;
                flag=true;
                x_front+=horSpeed;
                y_front-=verSpeed;

            }
            //תקין
            else {
                if (flag==true){
                    x_front-=horSpeed;
                    y_front-=verSpeed;
                }
                else {
                    x_front-=horSpeed;
                    y_front+=verSpeed;
                }

            }
        }
        try {
            sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void swim_after_worm() {
        /**
         * when the fish is hungry this method called in the do action method in hungry state
         */
        AquaFrame.Panel.repaint();
        if (x_front < 555) {
            x_dir = 1;
            y_front = (int) (m * (x_front ) - (m * 555) + 180);
            x_front += horSpeed;

        } else {
            x_dir = 0;
            y_front = (int) (m * (x_front ) - (m * 555) + 180);
            x_front -= horSpeed;

        }
        // if the fish close to the worm we call to callback in aqua panel
        if(y_front<=200 && y_front>=160 && x_front<=580 && x_front>=530){
            food=false;
            AquaPanel.food=false;
            AquaPanel.callback(this);
        }
        try {
            sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setx_front(int x_front) {
        this.x_front=x_front;
    }

    @Override
    public void sety_front(int y_front) {
        this.y_front=y_front;
    }

    @Override
    public void set_obj(int size, int DISTANCE_EAT, int horSpeed, int verSpeed, int col,int f) {
        /**
         * set object parameters
         */
        this.DISTANCE_EAT=DISTANCE_EAT;
        this.size=size;
        this.col=col;
        color=gettColor();
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        this.f=f;
    }
    public Jellyfish(){super(1,1,1);}

    @Override
    public int get_x_front() {
        return x_front;
    }

    @Override
    public int get_y_front() {
        return y_front;
    }

    @Override
    public Color get_Color() {
        return color;
    }

    public Jellyfish(Jellyfish obj){
        /**
         * copy constructor
         */
        DISTANCE_EAT=obj.DISTANCE_EAT;
        size=obj.size;
        col=obj.col;
        horSpeed=obj.horSpeed;
        verSpeed=obj.verSpeed;
        f=obj.f;
        x_dir=obj.x_dir;
        y_dir=obj.y_dir;
        x_front=obj.x_front;
        y_front=obj.y_front;
        color=obj.color;

    }

    @Override
    public String getAnimalName() {
        return "Jellyfish";
    }

    @Override
    public int getEatCount() {
        return eatCount;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getx_dir() {
        return x_dir;
    }

    @Override
    public String getColor() {
        String color[]={"Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink"};
        return color[col];
    }

    @Override
    public int getColorInt() {
        return col;
    }

    @Override
    public void eatInc() {
        if(DISTANCE_EAT==eatCount){
            size+=1;
            eatCount=0;
            DISTANCE_EAT+=1;
        }
        eatCount+=1;
    }
    //run method get from Threads class
    @Override
    public void run() {
        /**
         * the run method override from Threads
         */
        // init first local vars
        int  rando=(int) ((Math.random()*2));
        int f_temp=f;
        x_dir=rando;
        // the while true loop that make the fish move in the frame by roles
        while (true) {
            AquaFrame.Panel.repaint();
            if(f_temp==0){
                f_temp=f;
                State=new Hungry();
                notifyObserver(String.valueOf(this.getId()));
            }
            else
                f_temp--;
            // while for wait and notify
            while (sleep) {
                setSuspend();
            }

            // while loop the fishes swim to the worm
            while (food) {
                if(f_temp==0){
                    f_temp=f;
                    State=new Hungry();
                    notifyObserver(String.valueOf(this.getId()));
                    num=(575 - x_front);
                    if(num==0)
                        m = (180 - y_front)  ;
                    else
                        m = (180.0 - y_front) /num ;
                }
                else
                    f_temp--;
                State.doaction(this);
                AquaFrame.Panel.repaint();
                if(!food){
                    State=new Satiated();
                    f_temp=f;
                }
            }
            State.doaction(this);
        }
    }
    // get colors as color object for draw animal methood
    public Color gettColor() {
        Color[] color ={Color.BLACK,Color.RED ,Color.BLUE ,Color.GREEN ,Color.cyan ,Color.ORANGE,Color.YELLOW ,Color.MAGENTA ,Color.PINK};
        return color[col];
    }

    @Override
    public void setColor(Color color) {
        this.color=color;

    }
    @Override
    public memento saveStateToMemento() {
        return new memento(getAnimalName(),size,x_front, y_front,color,horSpeed,verSpeed);
    }

    @Override
    public void getStateFromMemento(memento m) {
        size=m.get_size();
        x_front=m.get_x_front();
        y_front=m.get_y_front();
        color=m.get_Colorr();
        horSpeed=m.get_horSpeed();
        verSpeed=m.get_verSpeed();
    }


    // draw animal method get the graphic g
    @Override
    public void drawAnimal(Graphics g) {
        /**
         * draw animal method
         */
        g.setColor(color);
        int numLegs;
        if(size<40)
            numLegs = 5;
        else if(size<80)
            numLegs = 9;
        else
            numLegs = 12;

        g.setColor(color);
        g.fillArc(x_front - size/2, y_front - size/4, size, size/2, 0, 180);

        for(int i=0; i<numLegs; i++)
            g.drawLine(x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front, x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front+size/3);

    }
    // set suspend put the current fish in wait mode until the condition change
    @Override
    public synchronized void setSuspend() {
        /**
         * set suspend method for sleep button and synchronized
         */
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setColo(Color col) {
        color=col;
    }

    // change the condition to notify the object from wait mode
    @Override
    public synchronized void setResume() {
        /**
         * set resume method for wake up button and synchronized
         */
        sleep=false;
        notify();

    }
    // set the barrier for the food action we get the barrier from aqua panel

    @Override
    public void drawCreature(Graphics g) {
        /**
         * draw creature implement of the interface
         */
        drawAnimal(g);

    }

    public void changeJellyfish(int size){
        this.size=size;
    }

    @Override
    public Jellyfish clone() {
        /**
         * for prototype pattern we used this clone method to copy the object
         */
        Jellyfish obj=new Jellyfish(this);
        return obj;
    }


    public void PaintFish(Color col) {
        /**
         * an implement from marine interface for decorator pattern
         */
        setColor(col);
    }
}
