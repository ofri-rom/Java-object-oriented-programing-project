package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
//this class is for save the object and restore the objects
public class SaveObject extends JDialog implements ActionListener {
    JTable t1,t2;
    JButton ok;

    private CareTaker list_moment=new CareTaker();
    static ArrayList <String> id = new ArrayList<>();
    static String[] col1={"id","Animal","Color","Size","Hor.speed","Ver.speed"};
    static String[] col2={"Sea Plant","Size","Hor.speed","Ver.speed"};
    static String[][] data1=new String[6][6];
    static String[][] data2=new String[6][4];
    int row,row1;

    public SaveObject(){
        /**
         * the creation of this class is depended on the flag we have if the flag is true that create an save object dialog
         * if the flag is false we create objects restore dialog
         */
        row=row1=-1;

        JPanel panel1 = new JPanel();
        if(AquaFrame.Save==true){
            for (int i=0;i<6;i++)
                data1[i] = new String[]{"","","", "","",""};

            int conter=0;
            for (Swimmable i:AquaPanel.set){
                data1[conter]=new String[]{String.valueOf(i.getId()),i.getAnimalName(),String.valueOf(i.get_Color()),String.valueOf(i.getSize()),String.valueOf(i.getHorSpeed()),String.valueOf(i.getVerSpeed()),String.valueOf(i.getEatCount())};
                conter++;}
            conter=0;
            for (Immobile i:AquaPanel.set_SeaPlant){
                data2[conter]=new String[]{i.get_name(),String.valueOf(i.get_size()),String.valueOf(i.get_x()),String.valueOf(i.get_y())};
                conter++;}
            t2=new JTable(data2,col2);
            t2.setPreferredScrollableViewportSize(t2.getPreferredSize());
            t2.setFillsViewportHeight(true);
            JScrollPane jp2=new JScrollPane(t2);
            panel1.add(jp2,BorderLayout.CENTER);
            t2.getSelectionModel().addListSelectionListener(e -> row1=t2.getSelectedRow());
        }
        else {
            for (int i=0;i<6;i++)
                data1[i] = new String[]{"","","", "","",""};


            int conter = 0;
            for (memento i : CareTaker.moment) {
                if (i.get_type().equals("Fish") || i.get_type().equals("Jellyfish"))
                    data1[conter] = new String[]{id.get(conter), String.valueOf(i.get_type()), String.valueOf(i.get_Colorr()), String.valueOf(i.get_size()), String.valueOf(i.get_horSpeed()), String.valueOf(i.get_verSpeed())};

                else if (i.get_type().equals("Laminaria") || i.get_type().equals("Zostera"))
                    data1[conter] = new String[]{id.get(conter), String.valueOf(i.get_type()), String.valueOf(i.get_Colorr()), "", "", ""};
                conter++;
            }
        }
        t1=new JTable(data1,col1);
        //t1.setPreferredSize(new Dimension(100,100));
        t1.setPreferredScrollableViewportSize(t1.getPreferredSize());
        t1.setFillsViewportHeight(true);
        JScrollPane jp1=new JScrollPane(t1);
        panel1.add(jp1,BorderLayout.NORTH);
        ok = new JButton("ok");
        ok.addActionListener(this);
        panel1.add(ok, BorderLayout.SOUTH);


        panel1.setSize(300, 200);
        panel1.setLayout(new GridLayout(3,1));
        add(panel1);
        setSize(600, 400);
        t1.getSelectionModel().addListSelectionListener(e -> row=t1.getSelectedRow());

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * action perform method
         * the creation of this class is depended on the flag we have if the flag is true that create an save object dialog
         * if the flag is false we create objects restore dialog
         */
        if (e.getSource().equals(ok)){
            if(AquaFrame.Save==true){
                if(CareTaker.moment.size()!=6){
                    if(row>=0) {
                        //  // immobile or swimmable save state
                        for (Swimmable i : AquaPanel.set) {
                            if (t1.getValueAt(row, 0).equals(String.valueOf(i.getId()))) {
                                list_moment.add(i.saveStateToMemento());
                                id.add(String.valueOf(i.hashCode()));

                            }
                        }
                        this.dispose();
                    }
                    if(row1>=0){
                        for(Immobile i:AquaPanel.set_SeaPlant){
                            if(t2.getValueAt(row1,0).equals(i.get_name()) && t2.getValueAt(row1,1).equals(String.valueOf(i.get_size()))&& t2.getValueAt(row1,2).equals(String.valueOf(i.get_x())) && t2.getValueAt(row1,3).equals(String.valueOf(i.get_y()))){
                                list_moment.add(i.saveStateToMemento());
                                id.add(String.valueOf(i.hashCode()));
                            }
                        }
                        this.dispose();

                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "הגעת למכסה,\n קיימים במערכת 6 ");
                    this.dispose();
                }
            }
            else {
                // immobile or swimmable restore
                if (row>=0){
                    if (list_moment.get(row).get_type().equals("Fish") || list_moment.get(row).get_type().equals("Jellyfish")){
                        for (Swimmable i:AquaPanel.set){
                            if(t1.getValueAt(row,0).equals(String.valueOf(i.hashCode()))){
                                i.getStateFromMemento(list_moment.get(row));

                            }
                        }
                    }else {
                        for (Immobile i : AquaPanel.set_SeaPlant) {
                            if (t1.getValueAt(row, 0).equals(String.valueOf(i.hashCode()))) {
                               i.getStateFromMemento(list_moment.get(row));
                            }

                        }
                    }
                }

                this.dispose();
            }

        }

    }
}
