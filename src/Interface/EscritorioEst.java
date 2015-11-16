/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import Imagenes.JDesktopPaneImg;

import javax.swing.JOptionPane;

/**
 *
 * @author fugalde
 */
public class EscritorioEst extends javax.swing.JFrame {
private JDesktopPaneImg escritorioEst;
private String idPersona;
    /**
     * Creates new form EscritorioEst
     */
    public EscritorioEst(String idPersona) {
        initComponents();
        this.idPersona=idPersona;

        escritorioEst = new JDesktopPaneImg();

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

        jMenuBar1 = new javax.swing.JMenuBar();
        archivoEst = new javax.swing.JMenu();
        cerrarSesionEst = new javax.swing.JMenuItem();
        cerrarEst = new javax.swing.JMenuItem();
        verEstudiante = new javax.swing.JMenu();
        asignacionesEst = new javax.swing.JMenuItem();
        eventosEst = new javax.swing.JMenuItem();
        calificacionesEst = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MsjsMenu = new javax.swing.JMenuItem();
        busquedaEst = new javax.swing.JMenu();
        ItemContDir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        archivoEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Home.png"))); // NOI18N
        archivoEst.setText("Archivo");

        cerrarSesionEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Person.png"))); // NOI18N
        cerrarSesionEst.setText("Cerrar Sesión");
        cerrarSesionEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionEstActionPerformed(evt);
            }
        });
        archivoEst.add(cerrarSesionEst);

        cerrarEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Turn off.png"))); // NOI18N
        cerrarEst.setText("Cerrar");
        cerrarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarEstActionPerformed(evt);
            }
        });
        archivoEst.add(cerrarEst);

        jMenuBar1.add(archivoEst);

        verEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Table.png"))); // NOI18N
        verEstudiante.setText("Ver");

        asignacionesEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Clipboard.png"))); // NOI18N
        asignacionesEst.setText("Asignaciones");
        asignacionesEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignacionesEstActionPerformed(evt);
            }
        });
        verEstudiante.add(asignacionesEst);

        eventosEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Calendar.png"))); // NOI18N
        eventosEst.setText("Eventos");
        eventosEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventosEstActionPerformed(evt);
            }
        });
        verEstudiante.add(eventosEst);

        calificacionesEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png"))); // NOI18N
        calificacionesEst.setText("Calificaciones");
        calificacionesEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calificacionesEstActionPerformed(evt);
            }
        });
        verEstudiante.add(calificacionesEst);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Male.png"))); // NOI18N
        jMenuItem2.setText("Mi perfil");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        verEstudiante.add(jMenuItem2);

        MsjsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mail.png"))); // NOI18N
        MsjsMenu.setText("Mensajes/Alertas");
        MsjsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsjsMenuActionPerformed(evt);
            }
        });
        verEstudiante.add(MsjsMenu);

        jMenuBar1.add(verEstudiante);

        busquedaEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Search.png"))); // NOI18N
        busquedaEst.setText("Busqueda");

        ItemContDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Phone number.png"))); // NOI18N
        ItemContDir.setText("Contactos y Directorio");
        ItemContDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemContDirActionPerformed(evt);
            }
        });
        busquedaEst.add(ItemContDir);

        jMenuBar1.add(busquedaEst);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
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

    private void eventosEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventosEstActionPerformed
        VerEventos vEvento= new VerEventos();
        escritorioEst.add(vEvento);
        vEvento.show();
    }//GEN-LAST:event_eventosEstActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        PerfilEst perfEst= new PerfilEst(this.idPersona);
        escritorioEst.add(perfEst);
        perfEst.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ItemContDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemContDirActionPerformed
        ContactosEst cEst = new ContactosEst();
        escritorioEst.add(cEst);
        cEst.show();
    }//GEN-LAST:event_ItemContDirActionPerformed

    private void calificacionesEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calificacionesEstActionPerformed
        VistaCalificaciones visCal= new VistaCalificaciones(idPersona);
        escritorioEst.add(visCal);
        visCal.show();
    }//GEN-LAST:event_calificacionesEstActionPerformed

    private void MsjsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsjsMenuActionPerformed
        Mensajes msj= new Mensajes();
        escritorioEst.add(msj);
        msj.show();
    }//GEN-LAST:event_MsjsMenuActionPerformed
 
    
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
                new EscritorioEst("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemContDir;
    private javax.swing.JMenuItem MsjsMenu;
    private javax.swing.JMenu archivoEst;
    private javax.swing.JMenuItem asignacionesEst;
    private javax.swing.JMenu busquedaEst;
    private javax.swing.JMenuItem calificacionesEst;
    private javax.swing.JMenuItem cerrarEst;
    private javax.swing.JMenuItem cerrarSesionEst;
    private javax.swing.JMenuItem eventosEst;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu verEstudiante;
    // End of variables declaration//GEN-END:variables
}
