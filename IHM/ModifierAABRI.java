/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Audrey
 */
public class ModifierAABRI extends javax.swing.JPanel {

    ArrayList AABRIS;
    /**
     * Creates new form ModifierAABRI
     */
    public ModifierAABRI() {
        AABRIS = new ArrayList();
        initComponents();
    }

    public ArrayList getAABRIS() {
        return AABRIS;
    }

    public void setAABRIS(ArrayList AABRIS) {
        this.AABRIS = AABRIS;
    }

    public JComboBox getCB_AABRI() {
        return CB_AABRI;
    }

    public void setCB_AABRI(JComboBox CB_AABRI) {
        this.CB_AABRI = CB_AABRI;
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B_insererValeur = new javax.swing.JButton();
        B_SupprimerValeur = new javax.swing.JButton();
        CB_AABRI = new javax.swing.JComboBox();
        B_retour = new javax.swing.JButton();

        B_insererValeur.setText("Insérer une valeur dans l'AABRI");

        B_SupprimerValeur.setText("Supprimer une valeur de l'AABRI");

        CB_AABRI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        B_retour.setText("Retour");
        B_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_retourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(B_insererValeur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_SupprimerValeur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB_AABRI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_retour))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CB_AABRI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_insererValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_SupprimerValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(B_retour)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void B_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_retourActionPerformed
        
    }//GEN-LAST:event_B_retourActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_SupprimerValeur;
    private javax.swing.JButton B_insererValeur;
    private javax.swing.JButton B_retour;
    private javax.swing.JComboBox CB_AABRI;
    // End of variables declaration//GEN-END:variables
}