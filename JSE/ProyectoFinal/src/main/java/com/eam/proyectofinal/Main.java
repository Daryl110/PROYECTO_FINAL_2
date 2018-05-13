package com.eam.proyectofinal;

import com.eam.proyecto.vista.FrmPrincipal;

/**
 * @author Daryl Ospina
 */
public class Main {
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
           FrmPrincipal ventanaPrincipal =  new FrmPrincipal();
           ventanaPrincipal.setLocationRelativeTo(null);
           ventanaPrincipal.setVisible(true);
        });
    }

}
