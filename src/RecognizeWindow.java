import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class RecognizeWindow extends JFrame implements ActionListener{

    JButton check = new JButton("check");
    PaintingField paintingField = new PaintingField();
    public RecognizeWindow() {

        setLayout(new FlowLayout());
        check.addActionListener(this);
        add(check);
        add(paintingField);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check) {
           // System.out.print("aaaa");
            TextRecognizer textRecognizer = new TextRecognizer("patterns");
            System.out.println(textRecognizer.recognize((BufferedImage) paintingField.getImage()));
            paintingField.clear();
        }
    }
}
