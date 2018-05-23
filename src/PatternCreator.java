import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    File selectedFile;

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
        if(e.getSource() == save) {
            if(path.getText() != "Choose folder where save image"){
                ImageLoader.saveImage(path.getText(),paintingField.getImage());
                path.setText(getNextFreeNameInFolder(selectedFile.getAbsolutePath()));
                paintingField.clear();
            }

        }
        if(e.getSource() == load) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new java.io.File("."));
            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));

            if(jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                paintingField.setImage(ImageLoader.loadImage(jFileChooser.getSelectedFile().getAbsolutePath()));
                path.setText(jFileChooser.getSelectedFile().getAbsolutePath());
            }
        }
        if(e.getSource() == clear) {
            paintingField.clear();
        }
        if(e.getSource() == chooseFolder) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new java.io.File("."));
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if(jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedFile = jFileChooser.getSelectedFile();
                path.setText(getNextFreeNameInFolder(selectedFile.getAbsolutePath()));
            }
        }
    }

    public String getNextFreeNameInFolder(String folder){
        for(int i = 1; i < 1000000; i++){
            String newName = new String( folder + "\\" + Integer.toString(i) + ".jpg");
            File file = new File(newName);

            if(!file.exists()){
                return newName;
            }
        }
        return "You have 1 million patterns. REALLY want more?";
    }
}