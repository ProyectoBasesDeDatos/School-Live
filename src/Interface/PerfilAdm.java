/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Carlos
 */
public class PerfilAdm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerfilAdm
     */
    private String idPersona;
    public PerfilAdm(String idPersona) {
        
        this.idPersona=idPersona;
        initComponents();
        
        ConexionBase base= new ConexionBase();
        
        if (base.getConexionCorrecta() != -1) {
            
            String[][] valoresProvincias = base.getDatosConsulta("select concat(idprovincia,'-',descripcion) as CodProvincia from provincia");
            String[][] valoresCantones = base.getDatosConsulta("select concat(idcanton,'-',descripcion) as CodCanton from canton");
             
            {String[][] sql = base.getDatosConsulta("select d.tipo, concat(p.idprovincia,'-',p.descripcion), concat(c.idcanton,'-',c.descripcion), d.descripcion from dirpersona d, provincia p, canton c where d.idpersona = '"+this.idPersona+"' and d.idprovincia = p.idprovincia and d.idcanton = c.idcanton");
            String nombreColumnas[] = {"Tipo", "Provincia", "Canton", "Direccion Exacta"};
            DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
            tableModel.setRowCount(0);
            tablaDirecciones.setModel(tableModel);
            for (int i = 0; i < sql.length; i++) {
                String[][] sql2 = base.getDatosConsulta("select d.tipo, concat(p.idprovincia,'-',p.descripcion), concat(c.idcanton,'-',c.descripcion), d.descripcion from dirpersona d, provincia p, canton c where d.idpersona = '"+this.idPersona+"' and d.idprovincia = p.idprovincia and d.idcanton = c.idcanton");
                tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2], sql2[i][3]});
            }
            tablaDirecciones.setModel(tableModel);
            TableColumn provinciaColumn = tablaDirecciones.getColumnModel().getColumn(1);
            TableColumn cantonColumn = tablaDirecciones.getColumnModel().getColumn(2);
            JComboBox listaProvincias = new JComboBox();
            JComboBox listaCantones = new JComboBox();
            for (int i = 0; i < valoresProvincias.length; i++) {
                listaProvincias.addItem(valoresProvincias[i][0]);
            }provinciaColumn.setCellEditor(new DefaultCellEditor(listaProvincias));
            for (int j = 0; j < valoresCantones.length; j++) {
                listaCantones.addItem(valoresCantones[j][0]);
            }cantonColumn.setCellEditor(new DefaultCellEditor(listaCantones));}
            
            {String[][] sql = base.getDatosConsulta("select tipotelefono, numerotelefono from telefono where idpersona = '"+this.idPersona+"'");
            String nombreColumnas[] = {"Tipo", "Numero"};
            DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
            tableModel.setRowCount(0);
            tablaTelefonos.setModel(tableModel);
            for (int i = 0; i < sql.length; i++) {
                String[][] sql2 = base.getDatosConsulta("select tipotelefono, numerotelefono from telefono where idpersona = '"+this.idPersona+"'");
                tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1]});
            }
            tablaTelefonos.setModel(tableModel);}
  
        }
        else{
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
        
        {String Parametro = jLabel5.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane5.setText(prueba2);}

        {String Parametro = jLabel1.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane2.setText(prueba2);}

        {String Parametro = jLabel2.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane4.setText(prueba2);}

        {String Parametro = jLabel3.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane3.setText(prueba2);}

        {String Parametro = jLabel4.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextField4.setText(prueba2);}

        {String Parametro = jLabel6.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane10.setText(prueba2);}

        {String Parametro = jLabel9.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane8.setText(prueba2);}

        {String Parametro = jLabel10.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane9.setText(prueba2);}

        {String Parametro = jLabel12.getText();
            String prueba2 = Parametro(this.idPersona, Parametro);
            jTextPane1.setText(prueba2);}
   
    }
    
    public String Parametro(String idPersona, String Parametro){
        //Metodo que devuelve la identificacion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneParametro(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
        
    }
    
    public int ActualizaDatosAdministrador(String IdPersona, String Email, String Facebook){
        //Metodo que actualiza los datos de Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            int Consulta = base.actualizaDatos(IdPersona, Email, Facebook); 
            return Consulta;
        }else{
            return -1;
        }
    }
    
    public int ActualizaProvinciaCanton(String IdPersona, String Tipo, String Provincia, String Canton){
        //Metodo que actualiza la direccion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            int Consulta = base.actualizaProvinciaCanton(IdPersona,Tipo,Provincia,Canton); 
            return Consulta;
        }else{
            return -1;
        }
    }
    
    public int ActualizaDireccion(String IdPersona, String Tipo, String Direccion){
        //Metodo que actualiza la direccion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            int Consulta = base.actualizaDireccion(IdPersona,Tipo,Direccion); 
            return Consulta;
        }else{
            return -1;
        }
    }
    
    public int ActualizaTelefonoAdministrador(String Tipo, String IdPersona, String Telefono){
        //Metodo que actualiza el telefono del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            int Consulta = base.actualizaTelefono(Tipo, IdPersona, Telefono); 
            return Consulta;
        }else{
            return -1;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaDirecciones = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaTelefonos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Perfil de Administrador");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Female.png"))); // NOI18N

        jLabel1.setText("Nombre");

        jLabel2.setText("Primer Apellido");

        jLabel3.setText("Segundo Apellido");

        jLabel4.setText("Sexo");

        jScrollPane1.setViewportView(jTextPane2);

        jScrollPane2.setViewportView(jTextPane3);

        jScrollPane3.setViewportView(jTextPane4);

        jLabel5.setText("Identificación");

        jLabel7.setText("Dirección");

        jLabel8.setText("Teléfono");

        jLabel9.setText("Correo Electrónico");

        jScrollPane5.setViewportView(jTextPane5);

        jLabel10.setText("Facebook");

        jLabel6.setText("Fecha de Nacimiento");

        jScrollPane8.setViewportView(jTextPane8);

        jScrollPane9.setViewportView(jTextPane9);

        jScrollPane10.setViewportView(jTextPane10);

        jLabel12.setText("Tipo de Usuario");

        jScrollPane6.setViewportView(jTextPane1);

        tablaDirecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Provincia", "Canton", "Direccion Exacta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tablaDirecciones);
        if (tablaDirecciones.getColumnModel().getColumnCount() > 0) {
            tablaDirecciones.getColumnModel().getColumn(0).setResizable(false);
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
        jScrollPane11.setViewportView(tablaTelefonos);

        jButton2.setText("Guardar Direccion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar Telefonos");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(23, 23, 23)))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(314, 314, 314))
        );

        jTabbedPane1.addTab("Perfil Personal", jPanel1);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
      String email = jTextPane8.getText();
      String facebook = jTextPane9.getText();  
      ActualizaDatosAdministrador(this.idPersona,email,facebook);
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      String tipo1 = tablaDirecciones.getModel().getValueAt(0, 0).toString();
      String provincia1 = tablaDirecciones.getModel().getValueAt(0, 1).toString();
      String canton1 = tablaDirecciones.getModel().getValueAt(0, 2).toString();
      String direccion1 = tablaDirecciones.getModel().getValueAt(0, 3).toString();
      ActualizaProvinciaCanton(this.idPersona,tipo1,provincia1,canton1);ActualizaDireccion(this.idPersona,tipo1,direccion1);
      
      String tipo2 = tablaDirecciones.getModel().getValueAt(1, 0).toString();
      String provincia2 = tablaDirecciones.getModel().getValueAt(1, 1).toString();
      String canton2 = tablaDirecciones.getModel().getValueAt(1, 2).toString();
      String direccion2 = tablaDirecciones.getModel().getValueAt(1, 3).toString();
      ActualizaProvinciaCanton(this.idPersona,tipo2,provincia2,canton2);ActualizaDireccion(this.idPersona,tipo2,direccion2);
      
      String tipo3 = tablaDirecciones.getModel().getValueAt(2, 0).toString();
      String provincia3 = tablaDirecciones.getModel().getValueAt(2, 1).toString();
      String canton3 = tablaDirecciones.getModel().getValueAt(2, 2).toString();
      String direccion3 = tablaDirecciones.getModel().getValueAt(2, 3).toString();
      ActualizaProvinciaCanton(this.idPersona,tipo3,provincia3,canton3);ActualizaDireccion(this.idPersona,tipo3,direccion3);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String tipo4 = tablaTelefonos.getModel().getValueAt(0, 0).toString();
      String telefono1 = tablaTelefonos.getModel().getValueAt(0, 1).toString();
      ActualizaTelefonoAdministrador(tipo4,this.idPersona,telefono1);
      
      String tipo5 = tablaTelefonos.getModel().getValueAt(1, 0).toString();
      String telefono2 = tablaTelefonos.getModel().getValueAt(1, 1).toString();
      ActualizaTelefonoAdministrador(tipo5,this.idPersona,telefono2);
      
      String tipo6 = tablaTelefonos.getModel().getValueAt(2, 0).toString();
      String telefono3 = tablaTelefonos.getModel().getValueAt(2, 1).toString();
      ActualizaTelefonoAdministrador(tipo6,this.idPersona,telefono3);
    
      String tipo7 = tablaTelefonos.getModel().getValueAt(2, 0).toString();
      String telefono4 = tablaTelefonos.getModel().getValueAt(2, 1).toString();
      ActualizaTelefonoAdministrador(tipo7,this.idPersona,telefono4);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    private javax.swing.JTable tablaDirecciones;
    private javax.swing.JTable tablaTelefonos;
    // End of variables declaration//GEN-END:variables
}
