/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class CrearPerfilProf extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerfilEstProf
     */
    public CrearPerfilProf() {
        initComponents();
        ConexionBase base = new ConexionBase();
        listaProvincias.removeAllItems();
        listaCantones.removeAllItems();
        if (base.getConexionCorrecta() != -1) {
            String[][] valoresProvincias = base.getDatosConsulta("select * from provincia");
            String[][] valoresCantones = base.getDatosConsulta("select idcanton, descripcion from canton");

            for (int i = 0; i < valoresProvincias.length; i++) {
                listaProvincias.addItem(valoresProvincias[i][0] + "-" + valoresProvincias[i][1]);
            }
            for (int j = 0; j < valoresCantones.length; j++) {
                listaCantones.addItem(valoresCantones[j][0] + "-" + valoresCantones[j][1]);
            }
             String[][] materias= base.getDatosConsulta("select idmateria,nombremateria from materias");
            
             DefaultListModel model= new DefaultListModel();
             for (int i = 0; i < materias.length; i++) {
             model.addElement(materias[i][0]+"-"+materias[i][1]);
             }
             listaMateriasDisponibles.setModel(model);

        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoDireccion = new javax.swing.JComboBox();
        listaProvincias = new javax.swing.JComboBox();
        listaCantones = new javax.swing.JComboBox();
        tiposTelefono = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaMateriasDisponibles = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        apellido1 = new javax.swing.JTextField();
        nombre1 = new javax.swing.JTextField();
        apellido2 = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox();
        email = new javax.swing.JTextField();
        fb = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMateriasAsignadas = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDirecciones = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTelefonos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        pwd = new javax.swing.JTextField();

        tipoDireccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Habitacion", "Oficina", "Otro" }));

        listaProvincias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listaCantones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tiposTelefono.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casa", "Oficina", "Movil", "Otro" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Crear Perfil Profesor");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N

        jLabel5.setText("Identificación");

        jLabel2.setText("Primer Apellido");

        jLabel8.setText("Teléfono");

        jLabel11.setText("Materias");

        jLabel4.setText("Sexo");

        jScrollPane4.setViewportView(listaMateriasDisponibles);

        jLabel1.setText("Nombre");

        jLabel3.setText("Segundo Apellido");

        jLabel9.setText("E mail");

        jLabel10.setText("Facebook");

        jLabel6.setText("Fecha de Nacimiento");

        jLabel7.setText("Dirección");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        id.setToolTipText("");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jToggleButton1.setText(">");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("<");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listaMateriasAsignadas);

        tablaDirecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Provincia", "Canton", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaDirecciones);
        if (tablaDirecciones.getColumnModel().getColumnCount() > 0) {
            tablaDirecciones.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(tipoDireccion));
            tablaDirecciones.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(listaProvincias));
            tablaDirecciones.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(listaCantones));
        }

        tablaTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Numero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTelefonos);
        if (tablaTelefonos.getColumnModel().getColumnCount() > 0) {
            tablaTelefonos.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(tiposTelefono));
        }

        jLabel12.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(64, 64, 64)
                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(89, 89, 89)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fb, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6))
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(fb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jToggleButton1)
                        .addGap(15, 15, 15)
                        .addComponent(jToggleButton2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    DefaultListModel dlm = new DefaultListModel();

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        dlm.addElement(listaMateriasDisponibles.getSelectedValue());
        listaMateriasAsignadas.setModel(dlm);
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        DefaultListModel model = (DefaultListModel) listaMateriasAsignadas.getModel();
        int selectedIndex = listaMateriasAsignadas.getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                 ConexionBase base = new ConexionBase();
        if(base.getConexionCorrecta() != -1){
            Date fechaNacimiento;
            String fechaString;
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            fechaNacimiento= jXDatePicker1.getDate();
            fechaString= formatter.format(fechaNacimiento);
            int res=0;
            res+=base.insertarEstudiante(id.getText(), nombre1.getText(), apellido1.getText(), apellido2.getText(), String.valueOf(sexo.getSelectedItem()),fechaString , email.getText(), fb.getText(), pwd.getText(), "P");
        //Recorrer la tabla de direcciones para agregar uno a una las direcciones la BD
            DefaultTableModel dtm = (DefaultTableModel) tablaDirecciones.getModel();
            int nRow = dtm.getRowCount();
            String codCanton;
            String codProvincia;
            String tDireccion= String.valueOf(dtm.getValueAt(0, 0));
            for (int i = 0; i < nRow-1; i++) {
                if (!tDireccion.equals("null")||tDireccion.equals("")) {
                    codProvincia = String.valueOf(dtm.getValueAt(i, 1));
                    codProvincia = codProvincia.substring(0, codProvincia.indexOf("-"));
                    codCanton = String.valueOf(dtm.getValueAt(i, 2));
                    codCanton = codCanton.substring(0, codCanton.indexOf("-"));
                    res+=base.insertarDireccion(id.getText(), String.valueOf(dtm.getValueAt(i, 0)), codProvincia, codCanton, String.valueOf(dtm.getValueAt(i, 3)));
                    tDireccion= String.valueOf(dtm.getValueAt(i+1, 0));
                }
            }
            
            //Recorrer la tabla de telefonos para agregar uno a uno los telefonos
            DefaultTableModel dtm2 = (DefaultTableModel) tablaTelefonos.getModel();
            int nRow2 = dtm2.getRowCount();
           
            for (int j = 0; j < nRow2-1; j++) {
                if (!(String.valueOf(dtm2.getValueAt(j, 0)).equals("")||String.valueOf(dtm2.getValueAt(j, 0)).equals("null"))) {
 
                    res += base.insertarTelefonos(id.getText(), String.valueOf(dtm2.getValueAt(j, 0)), String.valueOf(dtm2.getValueAt(j, 1)));
                }
            }
            
            //Recorrer la lista de materias para asignarselas al profesor
            
            ListModel model= listaMateriasAsignadas.getModel();
            String[] idMateriasAsig = new String[model.getSize()];
            String idMateria;
            for (int i = 0; i < model.getSize(); i++) {
                idMateria=model.getElementAt(i).toString();
                idMateria= idMateria.substring(0, idMateria.indexOf("-"));
                idMateriasAsig[i]=idMateria;
            }
            res+=base.insertarProfesor(id.getText(), idMateriasAsig);
            
                if(res>=4){
                JOptionPane.showMessageDialog(null,"Se agregó exitosamente el nuevo profesor","Exito",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"","No se agregó ",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1;
    private javax.swing.JTextField apellido2;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fb;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JComboBox listaCantones;
    private javax.swing.JList listaMateriasAsignadas;
    private javax.swing.JList listaMateriasDisponibles;
    private javax.swing.JComboBox listaProvincias;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTextField pwd;
    private javax.swing.JComboBox sexo;
    private javax.swing.JTable tablaDirecciones;
    private javax.swing.JTable tablaTelefonos;
    private javax.swing.JComboBox tipoDireccion;
    private javax.swing.JComboBox tiposTelefono;
    // End of variables declaration//GEN-END:variables
}
