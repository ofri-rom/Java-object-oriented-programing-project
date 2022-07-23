package q3;
//ofri rom:208891804
//avigail shekasta:209104314

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//class aqua frame include the jpanel component
public class AquaFrame extends JFrame implements ActionListener {
    //The main function that start the program
    public static void main(String[] args){
        /**
         * the main function from here the program begin to run init the main component and start the program
         */
        AquaFrame frame1=new AquaFrame("My Aquarium");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1150, 450);
        frame1.setVisible(true);

    }


    JMenu Fil,background,help,Memento;
    JMenuItem Exit,Image,Blue,None,Help,Save_Object_State,Restore_Object_State;
    JMenuBar z;
    SaveObject dialog1;
    static AquaPanel Panel;
    static boolean Save=false;



    //constructor init the size and the jmenu and j menu bar
    public AquaFrame(String string) {
        super(string);
        Fil=new JMenu("File");
        background=new JMenu("background");
        help=new JMenu("help");
        Exit=new JMenuItem("Exit");
        Exit.addActionListener(this);
        Image=new JMenuItem("Image");
        Image.addActionListener(this);
        Blue=new JMenuItem("Blue");
        Blue.addActionListener(this);
        None=new JMenuItem("None");
        None.addActionListener(this);
        Memento=new JMenu("Memento");
        Save_Object_State=new JMenuItem("Save Object State");
        Save_Object_State.addActionListener(this);
        Restore_Object_State=new JMenuItem("Restore Object State");
        Restore_Object_State.addActionListener(this);
        Help=new JMenuItem("Help");
        Help.addActionListener(this);

        Memento.add(Save_Object_State);
        Memento.add(Restore_Object_State);
        Fil.add(Exit);
        background.add(Image);
        background.add(Blue);
        background.add(None);
        help.add(Help);
        z=new JMenuBar();
        z.add(Fil);
        z.add(background);
        z.add(Memento);
        z.add(help);

        setJMenuBar(z);
        Panel=new AquaPanel(new BorderLayout());

        add(Panel);

    }
    //event listener for this class buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * this method perform the task according to the source that comes in the signature of this method
         */
        // listen to exit button
        if (e.getSource().equals(Exit))
            System.exit(0);
        // listen to image background button
        if (e.getSource().equals(Image))
        {
            Panel.setBackground(null);
            AquaPanel.img=new ImageIcon("src/images (1).jpg");
            Panel.repaint();
        }
        // set the background to blue
        if (e.getSource().equals(Blue)){
            AquaPanel.img=null;
            Panel.setBackground(Color.BLUE);
        }
        //set the background to none
        if (e.getSource().equals(None))
        {
            AquaPanel.img=null;
            Panel.setBackground(Color.white);
        }
        if (e.getSource().equals(Save_Object_State))
        {
            Save=true;
            dialog1 = new SaveObject();
            dialog1.setVisible(true);

        }
        if (e.getSource().equals(Restore_Object_State))
        {
            Save=false;
            dialog1 = new SaveObject();
            dialog1.setVisible(true);

        }
        // listen to help button event
        if (e.getSource().equals(Help))
            JOptionPane.showMessageDialog(this,"Home Work 3\n GUI @ Threads");
    }


}

