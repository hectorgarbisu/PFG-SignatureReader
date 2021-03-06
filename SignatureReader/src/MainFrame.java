/*
 * This is part of my grade project
 * All its code is free to use and modify
 */

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * @author geco
 *
 * Description: This program helps to capture movements done with the mouse. The
 * sequence of positions are stored along a label for each input. The list of
 * positions and the label will be used later for Machine Learning.
 */
public class MainFrame extends javax.swing.JFrame {

    // temporal data regarding mouse movement is considered relevant
    // stating a fixed period helps to differentiate between fast and slow
    // mouse swipes

    private final int PERIOD = 20; //miliseconds
    private final int DIM1 = 300;
    private final int DIM2 = 300;

    public MainFrame() {
        initComponents();
        this.vds = new VectorialDataSample(PERIOD,
                authorField.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvasPanel1 = new CanvasPanel();
        controlPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        authorField = new javax.swing.JTextField();
        canvasPanel2 = new CanvasPanel();

        javax.swing.GroupLayout canvasPanel1Layout = new javax.swing.GroupLayout(canvasPanel1);
        canvasPanel1.setLayout(canvasPanel1Layout);
        canvasPanel1Layout.setHorizontalGroup(
            canvasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        canvasPanel1Layout.setVerticalGroup(
            canvasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Figure reader");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(clearButton)
                    .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        canvasPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasPanel2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout canvasPanel2Layout = new javax.swing.GroupLayout(canvasPanel2);
        canvasPanel2.setLayout(canvasPanel2Layout);
        canvasPanel2Layout.setHorizontalGroup(
            canvasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        canvasPanel2Layout.setVerticalGroup(
            canvasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvasPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvasPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canvasPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasPanel2MousePressed
        // Initialize counter and draw current point
        if (SwingUtilities.isLeftMouseButton(evt)) {
            timDate.start();
        }
    }//GEN-LAST:event_canvasPanel2MousePressed

    private void canvasPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasPanel2MouseReleased
        // Stops time counter
        timDate.stop();
        if (SwingUtilities.isRightMouseButton(evt)) {
            //If right clic, it should delete the current figure        
            clearCanvas();
        } else if (SwingUtilities.isLeftMouseButton(evt)) {
  
        }
    }//GEN-LAST:event_canvasPanel2MouseReleased

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        vds.saveFigure(authorField.getText(),DIM1,DIM2);
        clearCanvas();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearCanvas();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void clearCanvas() {
        vds = new VectorialDataSample(PERIOD,authorField.getText());
        canvasPanel2.drawVectorialDataSample(vds);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private void drawCurrentPoint() {
        Point p = MouseInfo.getPointerInfo().getLocation();
//        System.out.println(p.getX() + " " + p.getY());
        SwingUtilities.convertPointFromScreen(p, canvasPanel2);
        System.out.println(p.getX() + " " + p.getY());
        vds.addPoint(p);
        canvasPanel2.drawVectorialDataSample(vds);

    }

    VectorialDataSample vds;
    private Timer timDate = new Timer(PERIOD, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            drawCurrentPoint();
        }
    });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorField;
    private CanvasPanel canvasPanel1;
    private CanvasPanel canvasPanel2;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables


}
