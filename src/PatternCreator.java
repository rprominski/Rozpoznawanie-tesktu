import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatternCreator extends JFrame {

    public PatternCreator(){
        JButton jButton = new JButton("wybierz folder");
        JButton jButton2 = new JButton("zapisz");
        jButton.addActionListener((ActionEvent event)->{

        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createLayour(jButton,jButton2);
        setLocationRelativeTo(null);

    }

    public void createLayour(JComponent... components){
        JPanel pane = (JPanel) getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);

        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup()
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(components[0])
                    .addComponent(components[1]))
        );
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup()
                .addComponent(components[0])
                .addComponent(components[1]))
        );

        pack();
    }

}
