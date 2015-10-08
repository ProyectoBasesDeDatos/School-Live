/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import javax.swing.JLabel;
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
        
        //escritorioAdmin.setBorder(new ImagenFondo());
        //escritorioAdmin.setL  
       
        escritorioAdmin.setLayout(new BorderLayout());
        escritorioAdmin.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.jpg"))), BorderLayout.CENTER);
                
        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.jpg")));        
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
        jMenuItem5 = new javax.swing.JMenuItem();
        mensajesAdmin = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        busquedaAdmin = new javax.swing.JMenu();
        ItemDirectorio = new javax.swing.JMenuItem();
        perfilAdmin = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ItemEditProf = new javax.swing.JMenuItem();
        ItemEditEst = new javax.swing.JMenuItem();
        ItemEditEnc = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        alertasAdmin = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorioAdmin.setDoubleBuffered(true);

        javax.swing.GroupLayout escritorioAdminLayout = new javax.swing.GroupLayout(escritorioAdmin);
        escritorioAdmin.setLayout(escritorioAdminLayout);
        escritorioAdminLayout.setHorizontalGroup(
            escritorioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        escritorioAdminLayout.setVerticalGroup(
            escritorioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        archivoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Home.png"))); // NOI18N
        archivoAdmin.setText("Archivo");

        cerrarSesionAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Person.png"))); // NOI18N
        cerrarSesionAdmin.setText("Cerrar sesión");
        cerrarSesionAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionAdminActionPerformed(evt);
            }
        });
        archivoAdmin.add(cerrarSesionAdmin);

        cerrarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Turn off.png"))); // NOI18N
        cerrarAdmin.setText("Cerrar");
        cerrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarAdminActionPerformed(evt);
            }
        });
        archivoAdmin.add(cerrarAdmin);

        menuAdmin.add(archivoAdmin);

        verAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Table.png"))); // NOI18N
        verAdmin.setText("Ver");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Clipboard.png"))); // NOI18N
        jMenu1.setText("Asignaciones");

        crearAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        crearAsigAdmin.setText("Crear");
        crearAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAsigAdminActionPerformed(evt);
            }
        });
        jMenu1.add(crearAsigAdmin);

        editarAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        editarAsigAdmin.setText("Editar");
        editarAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAsigAdminActionPerformed(evt);
            }
        });
        jMenu1.add(editarAsigAdmin);

        eliminarAsigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Delete.png"))); // NOI18N
        eliminarAsigAdmin.setText("Eliminar");
        eliminarAsigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAsigAdminActionPerformed(evt);
            }
        });
        jMenu1.add(eliminarAsigAdmin);

        verAdmin.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Calendar.png"))); // NOI18N
        jMenu2.setText("Eventos");

        CrearEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        CrearEvento.setText("Crear");
        CrearEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEventoActionPerformed(evt);
            }
        });
        jMenu2.add(CrearEvento);

        EditarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        EditarEvento.setText("Editar ");
        EditarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarEventoActionPerformed(evt);
            }
        });
        jMenu2.add(EditarEvento);

        EliminarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Delete.png"))); // NOI18N
        EliminarEvento.setText("Eliminar");
        EliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarEventoActionPerformed(evt);
            }
        });
        jMenu2.add(EliminarEvento);

        verAdmin.add(jMenu2);

        calificacionesAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png"))); // NOI18N
        calificacionesAdmin.setText("Calificaciones");
        calificacionesAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calificacionesAdminActionPerformed(evt);
            }
        });
        verAdmin.add(calificacionesAdmin);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Female.png"))); // NOI18N
        jMenuItem5.setText("Mi perfil");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        verAdmin.add(jMenuItem5);

        menuAdmin.add(verAdmin);

        mensajesAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mail.png"))); // NOI18N
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

        busquedaAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Search.png"))); // NOI18N
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

        perfilAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/User group.png"))); // NOI18N
        perfilAdmin.setText("Usuarios");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        jMenu3.setText("Crear");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N
        jMenuItem2.setText("Profesor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Male.png"))); // NOI18N
        jMenuItem3.setText("Estudiante");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/People.png"))); // NOI18N
        jMenuItem4.setText("Padre Familia");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        perfilAdmin.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Sync.png"))); // NOI18N
        jMenu4.setText("Actualizar");

        ItemEditProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N
        ItemEditProf.setText("Profesor");
        ItemEditProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemEditProfActionPerformed(evt);
            }
        });
        jMenu4.add(ItemEditProf);

        ItemEditEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Male.png"))); // NOI18N
        ItemEditEst.setText("Estudiante");
        ItemEditEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemEditEstActionPerformed(evt);
            }
        });
        jMenu4.add(ItemEditEst);

        ItemEditEnc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/People.png"))); // NOI18N
        ItemEditEnc.setText("Padre Familia");
        ItemEditEnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemEditEncActionPerformed(evt);
            }
        });
        jMenu4.add(ItemEditEnc);

        perfilAdmin.add(jMenu4);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Delete.png"))); // NOI18N
        jMenuItem6.setText("Eliminar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        perfilAdmin.add(jMenuItem6);

        menuAdmin.add(perfilAdmin);

        alertasAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Warning.png"))); // NOI18N
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
     Mensajes msj= new Mensajes();
     escritorioAdmin.add(msj);
     msj.show();
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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       CrearPerfilEst perfilEst= new CrearPerfilEst();
       escritorioAdmin.add(perfilEst);
       perfilEst.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CrearPerfilFamiliar perfilFam= new CrearPerfilFamiliar();
        escritorioAdmin.add(perfilFam);
        perfilFam.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        EliminarPerfil elimPerfil= new EliminarPerfil();
        escritorioAdmin.add(elimPerfil);
        elimPerfil.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void ItemEditProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemEditProfActionPerformed
        EditPerfProf perfProf = new EditPerfProf();
        escritorioAdmin.add(perfProf);
        perfProf.show();
    }//GEN-LAST:event_ItemEditProfActionPerformed

    private void ItemEditEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemEditEstActionPerformed
        EditPerfEst perfilEst= new EditPerfEst();
        escritorioAdmin.add(perfilEst);
        perfilEst.show();
    }//GEN-LAST:event_ItemEditEstActionPerformed

    private void ItemEditEncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemEditEncActionPerformed
        EditPerfFamiliar perfilFam= new EditPerfFamiliar();
        escritorioAdmin.add(perfilFam);
        perfilFam.show();
    }//GEN-LAST:event_ItemEditEncActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        PerfilAdm miPerfil= new PerfilAdm();
        escritorioAdmin.add(miPerfil);
        miPerfil.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void calificacionesAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calificacionesAdminActionPerformed
        CalificacionesGrupo caGru= new CalificacionesGrupo();
        escritorioAdmin.add(caGru);
        caGru.show();
    }//GEN-LAST:event_calificacionesAdminActionPerformed

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
    private javax.swing.JMenuItem ItemEditEnc;
    private javax.swing.JMenuItem ItemEditEst;
    private javax.swing.JMenuItem ItemEditProf;
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
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu mensajesAdmin;
    private javax.swing.JMenuBar menuAdmin;
    private javax.swing.JMenu perfilAdmin;
    private javax.swing.JMenu verAdmin;
    // End of variables declaration//GEN-END:variables
}
