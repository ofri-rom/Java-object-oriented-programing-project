package q3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//ofri rom:208891804
//avigail shekasta:209104314
public class JPanelDecorator extends JDialog implements ActionListener {
    JTable t;
    JButton Change_Color;
    static String[] col={"id","Animal","Color","Size","Hor.speed","Ver.speed","Eat counter"};
    static String[][] data=new String[6][7];
    int row=-1;
    public JPanelDecorator(){
        JPanel panel1 = new JPanel();

        int conter=0;
        for (Swimmable i:AquaPanel.set){
            data[conter]=new String[]{String.valueOf(i.getId()),i.getAnimalName(),String.valueOf(i.getColor()),String.valueOf(i.getSize()),String.valueOf(i.getHorSpeed()),String.valueOf(i.getVerSpeed()),String.valueOf(i.getEatCount())};
            conter++;}
        t=new JTable(data,col);

        t.setPreferredSize(new Dimension(750,350));
        JScrollPane jp=new JScrollPane(t);
        jp.setSize(750,350);
        panel1.add(jp);

        Change_Color = new JButton("Change Color");
        Change_Color.addActionListener(this);
        panel1.add(Change_Color, BorderLayout.SOUTH);

        panel1.setSize(300, 100);
        add(panel1);
        setSize(600, 300);
        t.getSelectionModel().addListSelectionListener(e -> row=t.getSelectedRow());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * get an source and perform the task according the calling source
         * this method list of objects and then choose one
         * after the choose open an color chooser dialog and choose any color
         * then by the decorator pattern the fish is painted by the color we choose
         */
        if (e.getSource().equals(Change_Color)){
            if(row>=0){
                for(Swimmable i:AquaPanel.set){
                    if(t.getValueAt(row,0).equals(String.valueOf(i.getId()))){
                        Color col=JColorChooser.showDialog(null,"",i.gettColor());
                        MarineAnimal temp= new MarineAnimalDecorator(i);
                        temp.PaintFish(col);
                    }
            }

            }

        }
        this.dispose();

    }
}
