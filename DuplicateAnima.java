package q3;
//ofri rom:208891804
//avigail shekasta:209104314
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuplicateAnima extends JDialog implements ActionListener {
    JButton ok;
    JComboBox<String> cmb;
    static Swimmable temp;
    AddAnimalDialog dialog;
    static boolean flag=false;
    public DuplicateAnima(){
        JPanel panel1 = new JPanel();

        JLabel size1 = new JLabel("בחר חיה לשכפול:");
        panel1.add(size1,BorderLayout.NORTH);
        pack();

        cmb = new JComboBox<String>();
        for (Swimmable i: AquaPanel.set)
            cmb.addItem(i.to_string());
        cmb.setSize(1000,30);
        panel1.add(cmb,BorderLayout.CENTER);

        ok = new JButton("אישור");
        ok.addActionListener(this);
        panel1.add(ok, BorderLayout.SOUTH);

        panel1.setSize(600, 50);
        add(panel1);
        setSize(550, 150);
        setTitle("הוספת חיה");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * this method perform the task according to the source that comes in the signature of this method
         */
        if (e.getSource().equals(ok)){
            for (Swimmable i:AquaPanel.set){
                if(cmb.getSelectedItem().toString().equals(i.to_string()))
                    temp=i.clone();
            }
            flag=true;
            dialog = new AddAnimalDialog();
            dialog.setVisible(true);
            this.dispose();
        }
    }
}
