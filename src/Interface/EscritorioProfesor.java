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
public class EscritorioProfesor extends javax.swing.JFrame {
private JDesktopPaneImg escritorioProf;
private String idPersona;
    /**
     * Creates new form EscritorioProfesor
     */
    public EscritorioProfesor(String idPersona) {
        this.idPersona=idPersona;
        initComponents();
        escritorioProf = new JDesktopPaneImg();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(escritorioProf)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(escritorioProf)
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

        menuProfesor = new javax.swing.JMenuBar();
        archivoProf = new javax.swing.JMenu();
        cmbUserProf = new javax.swing.JMenuItem();
        cerrarProf = new javax.swing.JMenuItem();
        VerProf = new javax.swing.JMenu();
        asignacionesProf = new javax.swing.JMenu();
        crearAsignacionProf = new javax.swing.JMenuItem();
        editarAsigProf = new javax.swing.JMenuItem();
        eliminarAsigAdmin = new javax.swing.JMenuItem();
        eventosProf = new javax.swing.JMenuItem();
        calificacionesProf = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MsjsMenu = new javax.swing.JMenuItem();
        busquedaProf = new javax.swing.JMenu();
        ItemDirectorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuProfesor.setAutoscrolls(true);

        archivoProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Home.png"))); // NOI18N
        archivoProf.setText("Archivo");

        cmbUserProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Person.png"))); // NOI18N
        cmbUserProf.setText("Cambiar de usuario");
        cmbUserProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserProfActionPerformed(evt);
            }
        });
        archivoProf.add(cmbUserProf);

        cerrarProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Turn off.png"))); // NOI18N
        cerrarProf.setText("Cerrar");
        cerrarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarProfActionPerformed(evt);
            }
        });
        archivoProf.add(cerrarProf);

        menuProfesor.add(archivoProf);

        VerProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Table.png"))); // NOI18N
        VerProf.setText("Ver");

        asignacionesProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Clipboard.png"))); // NOI18N
        asignacionesProf.setText("Asignaciones");

        crearAsignacionProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        crearAsignacionProf.setText("Crear");
        crearAsignacionProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAsignacionProfActionPerformed(evt);
            }
        });
        asignacionesProf.add(crearAsignacionProf);

        editarAsigProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        editarAsigProf.setText("Editar");
        editarAsigProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAsigProfActionPerformed(evt);
            }
        });
        asignacionesProf.add(editarAsigProf);

        eliminarAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Delete.png"))); // NOI18N
        eliminarAsigAdmin.setText("Eliminar");
        eliminarAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAsigAdminActionPerformed(evt);
            }
        });
        asignacionesProf.add(eliminarAsigAdmin);

        VerProf.add(asignacionesProf);

        eventosProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Calendar.png"))); // NOI18N
        eventosProf.setText("Eventos");
        eventosProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventosProfActionPerformed(evt);
            }
        });
        VerProf.add(eventosProf);

        calificacionesProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png"))); // NOI18N
        calificacionesProf.setText("Calificaciones");
        calificacionesProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calificacionesProfActionPerformed(evt);
            }
        });
        VerProf.add(calificacionesProf);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N
        jMenuItem4.setText("Mi perfil");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        VerProf.add(jMenuItem4);

        MsjsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mail.png"))); // NOI18N
        MsjsMenu.setText("Mensajes/Alertas");
        MsjsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsjsMenuActionPerformed(evt);
            }
        });
        VerProf.add(MsjsMenu);

        menuProfesor.add(VerProf);

        busquedaProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Search.png"))); // NOI18N
        busquedaProf.setText("Busqueda");

        ItemDirectorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Phone number.png"))); // NOI18N
        ItemDirectorio.setText("Directorio");
        ItemDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemDirectorioActionPerformed(evt);
            }
        });
        busquedaProf.add(ItemDirectorio);

        menuProfesor.add(busquedaProf);

        setJMenuBar(menuProfesor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearAsignacionProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAsignacionProfActionPerformed
        CrearAsignacion asigProf= new CrearAsignacion(this.idPersona);
        escritorioProf.add(asigProf);
        asigProf.show();
    }//GEN-LAST:event_crearAsignacionProfActionPerformed

    private void cerrarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarProfActionPerformed
        int answ= JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir del sistema?");
        if(answ==JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarProfActionPerformed

    private void cmbUserProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserProfActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cmbUserProfActionPerformed

    private void editarAsigProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAsigProfActionPerformed
        EditarAsignacion editAsig= new EditarAsignacion(this.idPersona);
        escritorioProf.add(editAsig);
        editAsig.show();
    }//GEN-LAST:event_editarAsigProfActionPerformed

    private void eliminarAsigAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAsigAdminActionPerformed
        EliminarAsignacion elimAsig = new EliminarAsignacion(this.idPersona);
        escritorioProf.add(elimAsig);
        elimAsig.show();
    }//GEN-LAST:event_eliminarAsigAdminActionPerformed

    private void eventosProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventosProfActionPerformed
        VerEventos vEvento= new VerEventos();
        escritorioProf.add(vEvento);
        vEvento.show();
    }//GEN-LAST:event_eventosProfActionPerformed

    private void ItemDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDirectorioActionPerformed
        DirectorioProf dProf = new DirectorioProf();
        escritorioProf.add(dProf);
        dProf.show();
    }//GEN-LAST:event_ItemDirectorioActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        PerfilProf perfilP= new PerfilProf(this.idPersona);
        escritorioProf.add(perfilP);
        perfilP.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void calificacionesProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calificacionesProfActionPerformed
        CalificacionesGrupo caGru= new CalificacionesGrupo(idPersona);
        escritorioProf.add(caGru);
        caGru.show();
    }//GEN-LAST:event_calificacionesProfActionPerformed

    private void MsjsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsjsMenuActionPerformed
        
        Mensajes msj= new Mensajes(this.idPersona);
        escritorioProf.add(msj);
        msj.show();        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(EscritorioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscritorioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscritorioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscritorioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EscritorioProfesor("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemDirectorio;
    private javax.swing.JMenuItem MsjsMenu;
    private javax.swing.JMenu VerProf;
    private javax.swing.JMenu archivoProf;
    private javax.swing.JMenu asignacionesProf;
    private javax.swing.JMenu busquedaProf;
    private javax.swing.JMenuItem calificacionesProf;
    private javax.swing.JMenuItem cerrarProf;
    private javax.swing.JMenuItem cmbUserProf;
    private javax.swing.JMenuItem crearAsignacionProf;
    private javax.swing.JMenuItem editarAsigProf;
    private javax.swing.JMenuItem eliminarAsigAdmin;
    private javax.swing.JMenuItem eventosProf;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuBar menuProfesor;
    // End of variables declaration//GEN-END:variables
}
