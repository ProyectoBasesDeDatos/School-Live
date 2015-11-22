/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan Adams
 */
public class ContactosEst extends javax.swing.JInternalFrame {

    /**
     * Creates new form ContactosEst
     */
    public ContactosEst() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setClosable(true);
        setIconifiable(true);
        setTitle("Contactos y Directorio");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Phone number.png"))); // NOI18N

        jLabel1.setText("Buscar por");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Año", "Sección" }));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Primer Apellido", "Segundo Apellido", "Año", "Sección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contactos", jPanel1);

        jLabel3.setText("Buscar por");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Materia" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Primer Apellido", "Segundo Apellido", "Materias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
            jTable3.getColumnModel().getColumn(3).setResizable(false);
            jTable3.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Directorio Profesores", jPanel3);

        jLabel2.setText("Detalle");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        ConexionBase base = new ConexionBase();
        if (base.getConexionCorrecta() != -1) {
        String [][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo");
        String nombreColumnas[]={"ID","Nombre","Primer Apellido","Segundo Apellido","Año","Sección"};
        DefaultTableModel tableModel= new DefaultTableModel(nombreColumnas,0);
        tableModel.setRowCount(0);
        jTable1.setModel(tableModel);
        for (int i = 0; i < sql.length; i++) {
            String[][] sql2= base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo"); 
            tableModel.addRow(new Object[]{sql2[i][0],sql2[i][1],sql2[i][2],sql2[i][3],sql2[i][4],sql2[i][5]});
        }
        jTable1.setModel(tableModel);
        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ConexionBase base = new ConexionBase();
        if (base.getConexionCorrecta() != -1) {
            String[][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, string_agg(m.nombremateria, ', ') as materias from persona p, materias m, profesores pr where p.idpersona = pr.idpersona and pr.idmateriaasignada = m.idmateria group by p.idpersona, p.nombre1, p.apellido1, p.apellido2");
            String nombreColumnas[] = {"ID","Nombre", "Primer Apellido", "Segundo Apellido", "Materias"};
            DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
            tableModel.setRowCount(0);
            jTable3.setModel(tableModel);
            for (int i = 0; i < sql.length; i++) {
                String[][] sql2 = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, string_agg(m.nombremateria, ', ') as materias from persona p, materias m, profesores pr where p.idpersona = pr.idpersona and pr.idmateriaasignada = m.idmateria group by p.idpersona, p.nombre1, p.apellido1, p.apellido2");
                tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3],sql2[i][4]});
            }
            jTable3.setModel(tableModel);
        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String parametro = jComboBox1.getSelectedItem().toString();
        ConexionBase base = new ConexionBase();
        if (base.getConexionCorrecta() != -1) {
            if ("Nombre".equals(parametro)) {
                String[][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo and p.nombre1 = '" + jTextField1.getText() + "';");
                String nombreColumnas[] = {"ID","Nombre","Primer Apellido","Segundo Apellido","Año","Sección"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable1.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo and p.nombre1 = '" + jTextField1.getText() + "';");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3], sql2[i][4],sql2[i][5]});
                }
                jTable1.setModel(tableModel);
            } else if ("Año".equals(parametro)) {
                String[][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo and g.anno = '" + jTextField1.getText() + "';");
                String nombreColumnas[] = {"ID","Nombre","Primer Apellido","Segundo Apellido","Año","Sección"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable1.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo and g.anno = '" + jTextField1.getText() + "';");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3], sql2[i][4],sql2[i][5]});
                }
                jTable1.setModel(tableModel);
            } else if ("Sección".equals(parametro)){
                String[][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo and g.seccion = '" + jTextField1.getText() + "';");
                String nombreColumnas[] = {"ID","Nombre","Primer Apellido","Segundo Apellido","Año","Sección"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable1.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, g.anno, g.seccion from persona p, grupo g, estudiante e where p.idpersona = e.idpersona and e.idgrupo = g.idgrupo and g.seccion = '" + jTextField1.getText() + "';");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3], sql2[i][4],sql2[i][5]});
                }
                jTable1.setModel(tableModel);
            }
            else {
               System.err.println("Ingrese un valor válido"); 
            }

        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String parametro = jComboBox2.getSelectedItem().toString();
        ConexionBase base = new ConexionBase();
        if (base.getConexionCorrecta() != -1) {
            if ("Nombre".equals(parametro)) {
                String[][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, string_agg(m.nombremateria, ', ') as materias from persona p, materias m, profesores pr where p.idpersona = pr.idpersona and pr.idmateriaasignada = m.idmateria and p.nombre1 = '" + jTextField2.getText() + "' group by p.idpersona, p.nombre1, p.apellido1, p.apellido2;");
                String nombreColumnas[] = {"ID","Nombre", "Primer Apellido", "Segundo Apellido", "Materias"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable3.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, string_agg(m.nombremateria, ', ') as materias from persona p, materias m, profesores pr where p.idpersona = pr.idpersona and pr.idmateriaasignada = m.idmateria and p.nombre1 = '" + jTextField2.getText() + "' group by p.idpersona, p.nombre1, p.apellido1, p.apellido2;");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3],sql2[i][4]});
                }
                jTable3.setModel(tableModel);
            } else{
                String[][] sql = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, string_agg(m.nombremateria, ', ') as materias from persona p, materias m, profesores pr where p.idpersona = pr.idpersona and pr.idmateriaasignada = m.idmateria and m.nombremateria = '" + jTextField2.getText() + "' group by p.idpersona, p.nombre1, p.apellido1, p.apellido2;");
                String nombreColumnas[] = {"ID","Nombre", "Primer Apellido", "Segundo Apellido", "Materias"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable3.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.idpersona, p.nombre1, p.apellido1, p.apellido2, string_agg(m.nombremateria, ', ') as materias from persona p, materias m, profesores pr where p.idpersona = pr.idpersona and pr.idmateriaasignada = m.idmateria and m.nombremateria = '" + jTextField2.getText() + "' group by p.idpersona, p.nombre1, p.apellido1, p.apellido2;");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3],sql2[i][4]});
                }
                jTable3.setModel(tableModel);
            }
        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        ConexionBase base = new ConexionBase();
        if (base.getConexionCorrecta() != -1) {
        int selectedRowIndex = jTable1.getSelectedRow();
        String selectedObject = jTable1.getModel().getValueAt(selectedRowIndex, 0).toString();
        String[][] sql = base.getDatosConsulta("select concat('Dirección de ',r2.direcciones), concat('Teléfono de ',r3.telefonos), concat('Email: ',r4.email) from	(select d.idpersona, string_agg(concat(d.tipo, ': ',p.descripcion,', ' ,c.descripcion, ', ',d.descripcion),'; Dirección de  ') as Direcciones from dirpersona d, provincia p, canton c where d.idprovincia = p.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+selectedObject+"' group by d.idpersona)r2, (select idpersona, string_agg(concat(tipotelefono, ': ',numerotelefono),'; Teléfono de ') as Telefonos from telefono where idpersona = '"+selectedObject+"' group by idpersona)r3, (select idpersona, email from persona where idpersona = '"+selectedObject+"')r4 where r2.idpersona = r3.idpersona and r2.idpersona = r4.idpersona");
        jTextArea1.setText(sql[0][0]+"\n"+sql[0][1]+"\n"+sql[0][2]);
        }else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        ConexionBase base = new ConexionBase();
        if (base.getConexionCorrecta() != -1) {
        int selectedRowIndex = jTable3.getSelectedRow();
        String selectedObject = jTable3.getModel().getValueAt(selectedRowIndex, 0).toString();
        String[][] sql = base.getDatosConsulta("select concat('Dirección de ',r2.direcciones), concat('Teléfono de ',r3.telefonos), concat('Email: ',r4.email) from	(select d.idpersona, string_agg(concat(d.tipo, ': ',p.descripcion,', ' ,c.descripcion, ', ',d.descripcion),'; Dirección de  ') as Direcciones from dirpersona d, provincia p, canton c where d.idprovincia = p.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+selectedObject+"' group by d.idpersona)r2, (select idpersona, string_agg(concat(tipotelefono, ': ',numerotelefono),'; Teléfono de ') as Telefonos from telefono where idpersona = '"+selectedObject+"' group by idpersona)r3, (select idpersona, email from persona where idpersona = '"+selectedObject+"')r4 where r2.idpersona = r3.idpersona and r2.idpersona = r4.idpersona");
        jTextArea1.setText(sql[0][0]+"\n"+sql[0][1]+"\n"+sql[0][2]);
        }else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }//GEN-LAST:event_jTable3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}