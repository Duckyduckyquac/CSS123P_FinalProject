package css123p_finalproject.view;

import javax.swing.*;  
import java.awt.event.*;
import java.awt.*; 

/**
 * Author: Group 3
 *
 */
public class ApplicationFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ApplicationFrame.class.getName());

    /**
     * Creates new form ApplicationFrame
     */
    public ApplicationFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {

        JFrame frame = new JFrame("");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(500, 400);
        
        frame.setLocationRelativeTo(null);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_UP) {

                }
            }
        })
        
        frame.setVisible(true);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ApplicationFrame().setVisible(true));
    }

}
