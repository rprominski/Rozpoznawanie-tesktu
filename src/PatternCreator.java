import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class PatternCreator extends JFrame implements ActionListener{

    JButton save = new JButton("save");
    JButton load = new JButton("load");
    JButton clear = new JButton("clear");
    JButton chooseFolder = new JButton("choose folder");
    JTextField path = new JTextField("Choose folder where save image");
    PaintingField paintingField = new PaintingField();

    public PatternCreator(){
        save.addActionListener(this);
        load.addActionListener(this);
        clear.addActionListener(this);
        chooseFolder.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        createLayout();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            ImageLoader.saveImage("C:\\Users\\Rav\\Desktop\\saved.jpg",paintingField.getImage());
            paintingField.clear();
        }
        if(e.getSource() == load){
           // paintingField.setImage(ImageLoader.loadImage("C:\\Users\\Rav\\Desktop\\saved.png"));
        }
        if(e.getSource() == clear){
            paintingField.clear();
        }
        if(e.getSource() == chooseFolder){
            System.out.println("chooseFolder");
        }
    }
}