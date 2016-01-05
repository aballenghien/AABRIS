/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Class.GrandArbre;
import GestionAABRI.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Audrey
 */
public class Menu extends javax.swing.JFrame {

    ArrayList AABRIS;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        AABRIS = new ArrayList();
    }

    public ArrayList getAABRIS() {
        return AABRIS;
    }

    public void setAABRIS(ArrayList AABRIS) {
        this.AABRIS = AABRIS;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B_FichierVersAabri = new javax.swing.JButton();
        B_aabriVersFichier = new javax.swing.JButton();
        B_aabrisAleatoire = new javax.swing.JButton();
        B_verifierAabri = new javax.swing.JButton();
        B_ModifierAabbri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        B_FichierVersAabri.setText("Générer un AABRI à partir d'un fichier");
        B_FichierVersAabri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_FichierVersAabriActionPerformed(evt);
            }
        });

        B_aabriVersFichier.setText("Ecrire un AABRI dans un fichier");
        B_aabriVersFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_aabriVersFichierActionPerformed(evt);
            }
        });

        B_aabrisAleatoire.setText("Générer un AABRI aléatoire");
        B_aabrisAleatoire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_aabrisAleatoireActionPerformed(evt);
            }
        });

        B_verifierAabri.setText("Vérifier si l'arbre d'arbres est un AABRI");
        B_verifierAabri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_verifierAabriActionPerformed(evt);
            }
        });

        B_ModifierAabbri.setText("Modifier un AABRI");
        B_ModifierAabbri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ModifierAabbriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(B_FichierVersAabri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_aabriVersFichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_aabrisAleatoire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_verifierAabri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_ModifierAabbri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B_FichierVersAabri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_aabriVersFichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_aabrisAleatoire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_verifierAabri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_ModifierAabbri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_FichierVersAabriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_FichierVersAabriActionPerformed
        String Emplacement = "C:\\Users\\Audrey\\Documents\\DOCUMENTS\\ETUDES\\UNIVERSITE\\Cours\\Master 1\\Complément en algorithme\\Projet AABRIS\\src\\";
	String fichier = Emplacement+"arbre.txt";
        GrandArbre unGrandArbre = FichierVersAABRI.lireFichier(fichier);
        AABRIS.add(unGrandArbre);
    }//GEN-LAST:event_B_FichierVersAabriActionPerformed

    private void B_aabrisAleatoireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_aabrisAleatoireActionPerformed
        GrandArbre unGrandArbre = AABRIAleatoire.genererGrandArbre(5, 100);
        AABRIS.add(unGrandArbre);
    }//GEN-LAST:event_B_aabrisAleatoireActionPerformed

    private void B_aabriVersFichierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_aabriVersFichierActionPerformed
        FileWriter fw = null;
        try {
            Object []options = AABRIS.toArray();
            GrandArbre unGrandArbre= (GrandArbre) JOptionPane.showInputDialog(this, "Choisissez un AABRI:", "AABRIS", JOptionPane.PLAIN_MESSAGE, null, options, null);
            String Emplacement = "C:\\Users\\Audrey\\Documents\\DOCUMENTS\\ETUDES\\UNIVERSITE\\Cours\\Master 1\\Complément en algorithme\\Projet AABRIS\\src\\";
            File fichier2 = new File(Emplacement+"arbre2.txt");
            fw = new FileWriter(fichier2);
            AABRIVersFichier.ecrireFichier(unGrandArbre, fw);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_B_aabriVersFichierActionPerformed

    private void B_verifierAabriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_verifierAabriActionPerformed
        Object []options = AABRIS.toArray();
        GrandArbre unGrandArbre= (GrandArbre) JOptionPane.showInputDialog(this, "Choisissez un AABRI:", "AABRIS", JOptionPane.PLAIN_MESSAGE, null, options, null);
        if(VerifierAABRI.isAABRI(unGrandArbre)){
            JOptionPane.showConfirmDialog(this, "L'arbre est un AABRI");
        }else{
            JOptionPane.showConfirmDialog(this, "L'arbre n'est pas un AABRI"); 
        }
    }//GEN-LAST:event_B_verifierAabriActionPerformed

    private void B_ModifierAabbriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ModifierAabbriActionPerformed
        ModifierAABRI mod = new ModifierAABRI();
        mod.setAABRIS(AABRIS);
        for(int i = 0; i < AABRIS.size(); i++){
           mod.getCB_AABRI().addItem(AABRIS.get(i)); 
        }       
        mod.setVisible(true);        
    }//GEN-LAST:event_B_ModifierAabbriActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_FichierVersAabri;
    private javax.swing.JButton B_ModifierAabbri;
    private javax.swing.JButton B_aabriVersFichier;
    private javax.swing.JButton B_aabrisAleatoire;
    private javax.swing.JButton B_verifierAabri;
    // End of variables declaration//GEN-END:variables
}
