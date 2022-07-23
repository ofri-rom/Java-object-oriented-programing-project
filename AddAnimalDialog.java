package q3;
//ofri rom:208891804
//avigail shekasta:209104314

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// add animal dialog class this is small window that pop up and allows us to choose the animal that we want to add
public class AddAnimalDialog extends JDialog  implements ActionListener {
    // fields of this class
    JSlider size;
    JSlider Horizontally;
    JSlider Vertically;
    JSlider f;
    JComboBox<String> cmb;
    JButton fish;
    JButton jellyfish;
    JButton ok;
    String[] names = {"Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink"};
    Swimmable temp;
    AnimalFactory obj;
    Listener aqua_panel=AquaFrame.Panel;




    // add animal dialog constructor init the component
    public AddAnimalDialog() {
        obj=new AnimalFactory();
        JPanel panel1 = new JPanel();
        cmb = new JComboBox<String>();
        for (int i = 0; i < names.length; i++)
            cmb.addItem(names[i]);
        if(DuplicateAnima.flag==false){
            size = new JSlider(20, 320);
            Horizontally = new JSlider(1, 10);
            Vertically = new JSlider(1, 10);
            f = new JSlider(100, 1000);
            fish = new JButton("דג");
            fish.addActionListener(this);
            panel1.add(fish, BorderLayout.SOUTH);
            jellyfish = new JButton("מדוזה");
            jellyfish.addActionListener(this);
            panel1.add(jellyfish, BorderLayout.SOUTH);
        }
        else {
            size = new JSlider(20, 320,DuplicateAnima.temp.getSize());
            Horizontally = new JSlider(1, 10,DuplicateAnima.temp.getHorSpeed());
            Vertically = new JSlider(1, 10,DuplicateAnima.temp.getVerSpeed());
            f = new JSlider(100, 1000,DuplicateAnima.temp.getf());
            cmb.setSelectedIndex(DuplicateAnima.temp.getColorInt());
            ok = new JButton("אישור");
            ok.addActionListener(this);
            panel1.add(ok, BorderLayout.SOUTH);

        }
        size.setMinorTickSpacing(1);
        size.setMajorTickSpacing(50);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        size.setPaintTrack(true);
        JLabel size1 = new JLabel("גודל:");
        panel1.add(size);
        panel1.add(size1);
        pack();
        Horizontally.setMinorTickSpacing(1);
        Horizontally.setMajorTickSpacing(2);
        Horizontally.setPaintTicks(true);
        Horizontally.setPaintLabels(true);

        Horizontally.setPaintTrack(true);
        JLabel Horizontally1 = new JLabel("מהירות אופקית:");
        panel1.add(Horizontally);
        panel1.add(Horizontally1);
        pack();
        Vertically.setMinorTickSpacing(1);
        Vertically.setMajorTickSpacing(2);
        Vertically.setPaintTicks(true);
        Vertically.setPaintLabels(true);
        Vertically.setPaintTrack(true);
        JLabel Vertically1 = new JLabel("מהירות אנכית:");
        panel1.add(Vertically);
        panel1.add(Vertically1);
        pack();
        f.setMinorTickSpacing(1);
        f.setMajorTickSpacing(500);
        f.setPaintTicks(true);
        f.setPaintLabels(true);
        f.setPaintTrack(true);
        JLabel f1 = new JLabel("תדירות אכילה:");
        panel1.add(f);
        panel1.add(f1);
        pack();
        JLabel Color1 = new JLabel("צבע:");
        panel1.add(cmb);
        panel1.add(Color1);
        panel1.setSize(100, 100);
        add(panel1);
        setSize(350, 300);
        setTitle("הוספת חיה");
        panel1.setLayout(new GridLayout(0, 2));
    }
    // the action listener of this class
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * parameters event
         * this methods perform the relevant task according to the source that received
         * in general this method add animals to hashset in aqua panel
         */
        // we can add animal just if we have less then 5 Swimable objects
        if (AquaPanel.set.size() < 5) {
            // add fish to the hash set
            if (e.getSource().equals(fish))
                temp=(Swimmable) obj.produceSeaCreature("Fish");
            // add jelly fish to the hash set
            else if (e.getSource().equals(jellyfish))
                temp=(Swimmable) obj.produceSeaCreature("Jellyfish");
            else if (e.getSource().equals(ok))
                temp=DuplicateAnima.temp;

            temp.set_obj(size.getValue(), 2, Horizontally.getValue(), Vertically.getValue(), cmb.getSelectedIndex(),f.getValue());
            AquaPanel.set.add(temp);

            // start the current object threads
            temp.registerObserver(aqua_panel);
            temp.start();
            // set the window unvisible
            this.dispose();
        // if there are already five Swimable objects we pop up message
        } else{
            JOptionPane.showMessageDialog(this, "הגעת למכסה,\n קיימים במערכת 5 חיות");
            this.dispose();
        }
        DuplicateAnima.flag=false;
    }
}



