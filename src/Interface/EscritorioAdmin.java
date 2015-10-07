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
public class EscritorioAdmin extends javax.swing.JFrame {

    /**
     * Creates new form EscritorioAdmin
     */
    public EscritorioAdmin() {
        initComponents();
        escritorioAdmin.setBorder(new ImagenFondo());
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

        escritorioAdmin = new javax.swing.JDesktopPane();
        menuAdmin = new javax.swing.JMenuBar();
        archivoAdmin = new javax.swing.JMenu();
        cerrarSesionAdmin = new javax.swing.JMenuItem();
        cerrarAdmin = new javax.swing.JMenuItem();
        verAdmin = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        crearAsigAdmin = new javax.swing.JMenuItem();
        editarAsigAdmin = new javax.swing.JMenuItem();
        eliminarAsigAdmin = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        CrearEvento = new javax.swing.JMenuItem();
        EditarEvento = new javax.swing.JMenuItem();
        EliminarEvento = new javax.swing.JMenuItem();
        calificacionesAdmin = new javax.swing.JMenuItem();
        mensajesAdmin = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        busquedaAdmin = new javax.swing.JMenu();
        ItemDirectorio = new javax.swing.JMenuItem();
        perfilAdmin = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        alertasAdmin = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioAdminLayout = new javax.swing.GroupLayout(escritorioAdmin);
        escritorioAdmin.setLayout(escritorioAdminLayout);
        escritorioAdminLayout.setHorizontalGroup(
            escritorioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );
        escritorioAdminLayout.setVerticalGroup(
            escritorioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        archivoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/home.png")));
        archivoAdmin.setText("Archivo");

        cerrarSesionAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person.png")));
        cerrarSesionAdmin.setText("Cerrar sesión");
        cerrarSesionAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionAdminActionPerformed(evt);
            }
        });
        archivoAdmin.add(cerrarSesionAdmin);

        cerrarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/turn off.png")));
        cerrarAdmin.setText("Cerrar");
        cerrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarAdminActionPerformed(evt);
            }
        });
        archivoAdmin.add(cerrarAdmin);

        menuAdmin.add(archivoAdmin);

        verAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/table.png")));
        verAdmin.setText("Ver");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clipboard.png")));
        jMenu1.setText("Asignaciones");

        crearAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/list.png")));
        crearAsigAdmin.setText("Crear");
        crearAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAsigAdminActionPerformed(evt);
            }
        });
        jMenu1.add(crearAsigAdmin);

        editarAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modify.png")));
        editarAsigAdmin.setText("Editar");
        editarAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAsigAdminActionPerformed(evt);
            }
        });
        jMenu1.add(editarAsigAdmin);

        eliminarAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete.png")));
        eliminarAsigAdmin.setText("Eliminar");
        eliminarAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAsigAdminActionPerformed(evt);
            }
        });
        jMenu1.add(eliminarAsigAdmin);

        verAdmin.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Calendar.png")));
        jMenu2.setText("Eventos");

        CrearEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/list.png")));
        CrearEvento.setText("Crear");
        CrearEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEventoActionPerformed(evt);
            }
        });
        jMenu2.add(CrearEvento);

        EditarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modify.png")));
        EditarEvento.setText("Editar ");
        EditarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarEventoActionPerformed(evt);
            }
        });
        jMenu2.add(EditarEvento);

        EliminarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete.png")));
        EliminarEvento.setText("Eliminar");
        EliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarEventoActionPerformed(evt);
            }
        });
        jMenu2.add(EliminarEvento);

        verAdmin.add(jMenu2);

        calificacionesAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png")));
        calificacionesAdmin.setText("Calificaciones");
        verAdmin.add(calificacionesAdmin);

        menuAdmin.add(verAdmin);

        mensajesAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mail.png")));
        mensajesAdmin.setText("Mensajes");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        jMenuItem1.setText("Crear Mensaje");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mensajesAdmin.add(jMenuItem1);

        menuAdmin.add(mensajesAdmin);

        busquedaAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search.png")));
        busquedaAdmin.setText("Busqueda");

        ItemDirectorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Phone number.png"))); // NOI18N
        ItemDirectorio.setText("Directorio");
        ItemDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemDirectorioActionPerformed(evt);
            }
        });
        busquedaAdmin.add(ItemDirectorio);

        menuAdmin.add(busquedaAdmin);

        perfilAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/user group.png")));
        perfilAdmin.setText("Perfil");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person.png")));
        jMenu3.setText("Crear");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N
        jMenuItem2.setText("Profesor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        perfilAdmin.add(jMenu3);

        menuAdmin.add(perfilAdmin);

        alertasAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/warning.png")));
        alertasAdmin.setText("Alertas");
        menuAdmin.add(alertasAdmin);

        setJMenuBar(menuAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioAdmin)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioAdmin)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionAdminActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrarSesionAdminActionPerformed

    private void cerrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarAdminActionPerformed
        int answ= JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir del sistema?");
        if(answ==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_cerrarAdminActionPerformed

    private void crearAsigAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAsigAdminActionPerformed
        CrearAsignacion asig= new CrearAsignacion();
        escritorioAdmin.add(asig);
        asig.show();
    }//GEN-LAST:event_crearAsigAdminActionPerformed

    private void editarAsigAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAsigAdminActionPerformed
        EditarAsignacion editAsig= new EditarAsignacion();
        escritorioAdmin.add(editAsig);
        editAsig.show();        
    }//GEN-LAST:event_editarAsigAdminActionPerformed

    private void eliminarAsigAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAsigAdminActionPerformed
        EliminarAsignacion elimAsig = new EliminarAsignacion();
        escritorioAdmin.add(elimAsig);
        elimAsig.show();    }//GEN-LAST:event_eliminarAsigAdminActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     MensajesAdm mnjAdm= new MensajesAdm();
     escritorioAdmin.add(mnjAdm);
     mnjAdm.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void CrearEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEventoActionPerformed
        CrearEventos cEvento = new CrearEventos();
        escritorioAdmin.add(cEvento);
        cEvento.show(); 
    }//GEN-LAST:event_CrearEventoActionPerformed

    private void EditarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarEventoActionPerformed
        EditarEventos eEvento = new EditarEventos();
        escritorioAdmin.add(eEvento);
        eEvento.show(); 
    }//GEN-LAST:event_EditarEventoActionPerformed

    private void EliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarEventoActionPerformed
        EliminarEventos eEvento = new EliminarEventos();
        escritorioAdmin.add(eEvento);
        eEvento.show(); 
    }//GEN-LAST:event_EliminarEventoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CrearPerfilProf perfProf = new CrearPerfilProf();
        escritorioAdmin.add(perfProf);
        perfProf.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ItemDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDirectorioActionPerformed
        DirectorioAdmin dAdmin = new DirectorioAdmin();
        escritorioAdmin.add(dAdmin);
        dAdmin.show();
    }//GEN-LAST:event_ItemDirectorioActionPerformed

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
            java.util.logging.Logger.getLogger(EscritorioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscritorioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscritorioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscritorioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EscritorioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CrearEvento;
    private javax.swing.JMenuItem EditarEvento;
    private javax.swing.JMenuItem EliminarEvento;
    private javax.swing.JMenuItem ItemDirectorio;
    private javax.swing.JMenu alertasAdmin;
    private javax.swing.JMenu archivoAdmin;
    private javax.swing.JMenu busquedaAdmin;
    private javax.swing.JMenuItem calificacionesAdmin;
    private javax.swing.JMenuItem cerrarAdmin;
    private javax.swing.JMenuItem cerrarSesionAdmin;
    private javax.swing.JMenuItem crearAsigAdmin;
    private javax.swing.JMenuItem editarAsigAdmin;
    private javax.swing.JMenuItem eliminarAsigAdmin;
    private javax.swing.JDesktopPane escritorioAdmin;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mensajesAdmin;
    private javax.swing.JMenuBar menuAdmin;
    private javax.swing.JMenu perfilAdmin;
    private javax.swing.JMenu verAdmin;
    // End of variables declaration//GEN-END:variables
}
