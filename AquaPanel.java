package q3;
//ofri rom:208891804
//avigail shekasta:209104314

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

// class Aqua panel extend jPanel
public class AquaPanel extends JPanel implements ActionListener,Listener {

    static ImageIcon img;

    JButton add_Animal;
    JButton Duplicate_Animal;
    JButton Decorator;
    JButton SeaPlant;
    JButton Sleep;
    JButton Wake_up;
    JButton Reset;
    JButton Food;
    JButton Info;
    JButton Exit;
    AddAnimalDialog dialog;
    AddSeaPlantDialog dialog2;
    DuplicateAnima dialog1;
    JPanelDecorator dialog3;
    JPanel pp;
     String[] col={"Animal","Color","Size","Hor.speed","Ver.speed","Eat counter"};
     String[][] data=new String[6][6];
    public static HashSet<Swimmable> set = new HashSet<>();
    public static HashSet<Immobile> set_SeaPlant = new HashSet<>();
    JScrollPane jp;
    boolean info=true;
    static boolean food=false;

    //aqua panel constructor init all component
    public  AquaPanel(BorderLayout borderLayout){
        //pp is inside panel the this panel include the buttons and pp panel include the area for fish
        pp=new JPanel();

        add_Animal=new JButton("Add Animal");
        add_Animal.addActionListener(this);
        pp.add(add_Animal);
        Duplicate_Animal=new JButton("Duplicate Animal");
        Duplicate_Animal.addActionListener(this);
        pp.add(Duplicate_Animal);
        Decorator=new JButton("Decorator");
        Decorator.addActionListener(this);
        pp.add(Decorator);
        SeaPlant=new JButton("Sea Plant");
        SeaPlant.addActionListener(this);
        pp.add(SeaPlant);
        Sleep=new JButton("Sleep");
        Sleep.addActionListener(this);
        pp.add(Sleep);
        Wake_up=new JButton("Wake up");
        Wake_up.addActionListener(this);
        pp.add(Wake_up);
        Reset=new JButton("Reset");
        Reset.addActionListener(this);
        pp.add(Reset);
        Food=new JButton("Food");
        Food.addActionListener(this);
        pp.add(Food);
        Info=new JButton("Info");
        Info.addActionListener(this);
        pp.add(Info);
        Exit=new JButton("Exit");
        Exit.addActionListener(this);
        pp.add(Exit);
        pp.setLayout(new GridLayout(1,0,0,0));
        this.setLayout(borderLayout);
        this.add(pp,BorderLayout.SOUTH);

    }

// action listener for this class
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * this method perform the task according to the source that comes in the signature of this method
         */
        //add animal event
        if (e.getSource().equals(add_Animal)) {
            dialog = new AddAnimalDialog();
            dialog.setVisible(true);

        }
        if (e.getSource().equals(Duplicate_Animal)){
            dialog1 = new DuplicateAnima();
            dialog1.setVisible(true);
        }
        if (e.getSource().equals(Decorator)) {
            dialog3 = new JPanelDecorator();
            dialog3.setVisible(true);

        }
            if (e.getSource().equals(SeaPlant)) {
            dialog2 = new AddSeaPlantDialog();
            dialog2.setVisible(true);
        }
        //sleep event
        if (e.getSource().equals(Sleep)){
            Fish.sleep=true;
            Jellyfish.sleep=true;
        }
        //wake up event
        if (e.getSource().equals(Wake_up))
            for (Swimmable i:set){
                i.setResume();
            }
        //reset event
        if (e.getSource().equals(Reset)){
            int conter=0;
            for (Swimmable i:set){ // iterat over the hashset
                data[conter]=new String[]{"","","","","",""}; // clean the data from the data[][]
                conter++;
                i.stop();
            }
            set.removeAll(set); // clean the set
            repaint(); // call to repaint for refresh the screen
        }
        //event for food
        if (e.getSource().equals(Food)){

            food=true; // flag of food = true
            Fish.food=true; // set the flag in fish to start food process in run method
            Jellyfish.food=true; // set the flag in jellyfish to start food process in run method
        }
        // info button that init jatable and put it on jscrollpane
        if (e.getSource().equals(Info)){
            int conter=0;
            for (Swimmable i:set){
                data[conter]=new String[]{i.getAnimalName(),String.valueOf(i.get_Color()),String.valueOf(i.getSize()),String.valueOf(i.getHorSpeed()),String.valueOf(i.getVerSpeed()),String.valueOf(i.getEatCount())};
                conter++;
            }
           if (info){
               JTable t=new JTable(data,col);
               t.setPreferredSize(new Dimension(750,350));
               jp=new JScrollPane(t);
               jp.setSize(750,350);
               this.add(jp);
               info=false;
           }
           else {
               jp.setVisible(false);
               info=true;

           }
        }
        //button to exit the program
        if (e.getSource().equals(Exit))
            System.exit(0);

    }
    // paint component method that call from the threads every time they start the loop
    public void paintComponent(Graphics g) {
        /**
         * paint component method that belong to the panel
         * the main idea is to paint and refresh the object that appears on the panel and simulate their move animation
         */
        super.paintComponent(g);
        if(img!=null)
            g.drawImage(img.getImage(), 0, 0,this); //draw the image bg
        for(Swimmable i:set){
            i.drawAnimal(g);//draw each swimable object from the set each time this function called
        }
        for (Immobile i:set_SeaPlant){
            i.drawCreature(g);
        }
        //food flag put the worm in the center of the panel from image icon
        if(food){
            g.drawImage(Singleton.getInstance().img.getImage(),555 , 180,40,30,this);
        }

    }
    //callback method every fish that get the worm call to this function and this function increament the eat counter of the object
    public static void callback(Swimmable x){
        /**
         * call back method if fish eat the worm that function is called
         */
        x.eatInc();
    }

    @Override
    public void update(String msg) {
        /**
         * this function use for observer pattern when one animal is notified the observer this message pop up
         */
        JOptionPane.showMessageDialog(this, "הדג"+msg+"רעב");
    }
}
