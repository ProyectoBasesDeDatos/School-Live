/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Imagenes.ImagenFondo;
import javax.swing.JOptionPane;

/**
 *
 * @author fugalde
 */
public class EscritorioEst extends javax.swing.JFrame {

    /**
     * Creates new form EscritorioEst
     */
    public EscritorioEst() {
        initComponents();
        escritorioEst.setBorder(new ImagenFondo());
        this.setExtendedState(EscritorioProfesor.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioEst = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoEst = new javax.swing.JMenu();
        cerrarSesionEst = new javax.swing.JMenuItem();
        cerrarEst = new javax.swing.JMenuItem();
        verEstudiante = new javax.swing.JMenu();
        asignacionesEst = new javax.swing.JMenuItem();
        eventosEst = new javax.swing.JMenuItem();
        calificacionesEst = new javax.swing.JMenuItem();
        mensajesEst = new javax.swing.JMenu();
        busquedaEst = new javax.swing.JMenu();
        perfilEst = new javax.swing.JMenu();
        alertasEst = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioEstLayout = new javax.swing.GroupLayout(escritorioEst);
        escritorioEst.setLayout(escritorioEstLayout);
        escritorioEstLayout.setHorizontalGroup(
            escritorioEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        escritorioEstLayout.setVerticalGroup(
            escritorioEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        archivoEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/home.png")));
        archivoEst.setText("Archivo");

        cerrarSesionEst.setText("Cerrar Sesión");
        cerrarSesionEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionEstActionPerformed(evt);
            }
        });
        archivoEst.add(cerrarSesionEst);

        cerrarEst.setText("Cerrar");
        cerrarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarEstActionPerformed(evt);
            }
        });
        archivoEst.add(cerrarEst);

        jMenuBar1.add(archivoEst);

        verEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/table.png")));
        verEstudiante.setText("Ver");

        asignacionesEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clipboard.png")));
        asignacionesEst.setText("Asignaciones");
        asignacionesEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignacionesEstActionPerformed(evt);
            }
        });
        verEstudiante.add(asignacionesEst);

        eventosEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calendar.png")));
        eventosEst.setText("Eventos");
        verEstudiante.add(eventosEst);

        calificacionesEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png")));
        calificacionesEst.setText("Calificaciones");
        verEstudiante.add(calificacionesEst);

        jMenuBar1.add(verEstudiante);

        mensajesEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mail.png")));
        mensajesEst.setText("Mensajes");
        jMenuBar1.add(mensajesEst);

        busquedaEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search.png")));
        busquedaEst.setText("Busqueda");
        jMenuBar1.add(busquedaEst);

        perfilEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/people.png")));
        perfilEst.setText("Perfil");
        jMenuBar1.add(perfilEst);

        alertasEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/warning.png")));
        alertasEst.setText("Alertas");
        jMenuBar1.add(alertasEst);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioEst)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioEst)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void asignacionesEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignacionesEstActionPerformed
        AsignacionesEst asigEst= new AsignacionesEst();
        escritorioEst.add(asigEst);
        asigEst.show();
        
    }//GEN-LAST:event_asignacionesEstActionPerformed

    private void cerrarSesionEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionEstActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrarSesionEstActionPerformed

    private void cerrarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarEstActionPerformed
        int answ= JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir del sistema?");
        if(answ==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_cerrarEstActionPerformed

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
            java.util.logging.Logger.getLogger(EscritorioEst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscritorioEst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscritorioEst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscritorioEst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EscritorioEst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alertasEst;
    private javax.swing.JMenu archivoEst;
    private javax.swing.JMenuItem asignacionesEst;
    private javax.swing.JMenu busquedaEst;
    private javax.swing.JMenuItem calificacionesEst;
    private javax.swing.JMenuItem cerrarEst;
    private javax.swing.JMenuItem cerrarSesionEst;
    private javax.swing.JDesktopPane escritorioEst;
    private javax.swing.JMenuItem eventosEst;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mensajesEst;
    private javax.swing.JMenu perfilEst;
    private javax.swing.JMenu verEstudiante;
    // End of variables declaration//GEN-END:variables
}
