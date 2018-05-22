import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class PatternCreator extends JFrame {

    JButton save = new JButton("save");
    JButton load = new JButton("load");
    JButton clear = new JButton("clear");
    JButton chooseFolder = new JButton("choose folder");
    JTextField path = new JTextField("Wybierz folder do zapisu");
    PaintingField paintingField = new PaintingField();

    public PatternCreator(){
        createLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createLayout(){
        JPanel pane = (JPanel) getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);

        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(CENTER)
                .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(save)
                        .addComponent(load)
                        .addComponent(clear)
                        .addComponent(chooseFolder))
                .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(paintingField,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(path))
        );
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup()
                        .addComponent(save)
                        .addComponent(load)
                        .addComponent(clear)
                        .addComponent(chooseFolder))
                .addGroup(groupLayout.createParallelGroup()
                        .addComponent(paintingField,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createParallelGroup()
                        .addComponent(path))
        );

        pack();
    }

}