package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// add planet dialog class this is small window that pop up and allows us to choose the planet that we want to add
public class AddSeaPlantDialog extends JDialog implements ActionListener {
    // fields of this class
    JSlider size;
    JSlider Horizontally;
    JSlider Vertically;
    JButton Zostera;
    JButton Laminaria;
    Immobile temp;
    PlantFactory obj;


    // add sea planet dialog constructor init the component
    public AddSeaPlantDialog() {
        obj=new PlantFactory();
        JPanel panel1 = new JPanel();
        size = new JSlider(20, 320);
        size.setPaintTrack(true);

        JLabel size1 = new JLabel("גודל:");
        panel1.add(size);
        panel1.add(size1);
        pack();
        Horizontally = new JSlider(50, 750);
        Horizontally.setPaintTrack(true);
        JLabel Horizontally1 = new JLabel("מיקום אופקי:");
        panel1.add(Horizontally);
        panel1.add(Horizontally1);

        pack();
        Vertically = new JSlider(50, 450);
        Vertically.setPaintTrack(true);
        JLabel Vertically1 = new JLabel("מיקום אנכי:");
        panel1.add(Vertically);
        panel1.add(Vertically1);
        pack();

        Zostera = new JButton("Zostera");
        Zostera.addActionListener(this);
        panel1.add(Zostera, BorderLayout.SOUTH);
        Laminaria = new JButton("Laminaria");
        Laminaria.addActionListener(this);
        panel1.add(Laminaria, BorderLayout.SOUTH);
        panel1.setSize(100, 100);
        add(panel1);
        setSize(350, 200);
        setTitle("הוספת צמח");
        panel1.setLayout(new GridLayout(0, 2));
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * parameters event
         * this methods perform the relevant task according to the source that received
         * in general this method add planets to hashset in aqua panel
         */
        if (AquaPanel.set_SeaPlant.size() < 5) {

            if (e.getSource().equals(Zostera))
                temp=(Immobile) obj.produceSeaCreature("Zostera");

            else if (e.getSource().equals(Laminaria))
                temp=(Immobile) obj.produceSeaCreature("Laminaria");
            temp.set_obj(size.getValue(), Horizontally.getValue(), Vertically.getValue());
            AquaPanel.set_SeaPlant.add(temp);
            this.dispose();

        } else{
            JOptionPane.showMessageDialog(this, "הגעת למכסה,\n קיימים במערכת 5 צמחים");
            this.dispose();}
    }

    }

