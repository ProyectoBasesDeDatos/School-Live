/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import java.util.Arrays;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author fugalde
 */
public class PerfilProf extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerfilProf
     */
    private String idPersona;
    
    public PerfilProf(String idPersona) {
        this.idPersona=idPersona;
        initComponents();
        
        ConexionBase base= new ConexionBase();
        
        if (base.getConexionCorrecta() != -1) {
            
            String[][] valoresProvincias = base.getDatosConsulta("select concat(idprovincia,'-',descripcion) as CodProvincia from provincia");
            String[][] valoresCantones = base.getDatosConsulta("select concat(idcanton,'-',descripcion) as CodCanton from canton");
             
            {String[][] sql = base.getDatosConsulta("select d.tipo, concat(p.idprovincia,'-',p.descripcion), concat(c.idcanton,'-',c.descripcion), d.descripcion from dirpersona d, provincia p, canton c where d.idpersona = '"+this.idPersona+"' and p.idprovincia = c.idprovincia and d.idprovincia = p.idprovincia and d.idcanton = c.idcanton");
            String nombreColumnas[] = {"Tipo", "Provincia", "Canton", "Direccion Exacta"};
            DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
            tableModel.setRowCount(0);
            tablaDirecciones.setModel(tableModel);
            for (int i = 0; i < sql.length; i++) {
                String[][] sql2 = base.getDatosConsulta("select d.tipo, concat(p.idprovincia,'-',p.descripcion), concat(c.idcanton,'-',c.descripcion), d.descripcion from dirpersona d, provincia p, canton c where d.idpersona = '"+this.idPersona+"' and p.idprovincia = c.idprovincia and d.idprovincia = p.idprovincia and d.idcanton = c.idcanton");
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
        
        {String Parametro = jLabel1.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField1.setText(prueba2);}
        
        {String Parametro = jLabel3.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField4.setText(prueba2);}
        
        {String Parametro = jLabel2.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField2.setText(prueba2);}
        
        {String Parametro = jLabel4.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField3.setText(prueba2);}
        
        {String Parametro = jLabel7.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField7.setText(prueba2);}
        
        {String Parametro = jLabel9.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField9.setText(prueba2);}
        
        {String Parametro = jLabel6.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField6.setText(prueba2);}
        
        {String Parametro = jLabel8.getText();
        String prueba2 = Parametro(this.idPersona, Parametro);
        jTextField8.setText(prueba2);}
        
        {if (base.getConexionCorrecta() != -1) {
        String [][] sql = base.getDatosConsulta("select g.anno, g.seccion, string_agg(m.nombremateria, ', ') as Materias from grupo g, profesores p, impartegrupo ig, materias m where g.idgrupo = ig.idgrupo and p.idpersona = ig.idprofesor and p.idmateriaasignada = m.idmateria and ig.idprofesor = '"+this.idPersona+"' group by g.anno, g.seccion order by g.seccion;");
        String nombreColumnas[]={"Nivel","Seccion","Materias"};
        DefaultTableModel tableModel= new DefaultTableModel(nombreColumnas,0);
        tableModel.setRowCount(0);
        jTable2.setModel(tableModel);
        for (int i = 0; i < sql.length; i++) {
            String[][] sql2= base.getDatosConsulta("select g.anno, g.seccion, string_agg(m.nombremateria, ', ') as Materias from grupo g, profesores p, impartegrupo ig, materias m where g.idgrupo = ig.idgrupo and p.idpersona = ig.idprofesor and p.idmateriaasignada = m.idmateria and ig.idprofesor = '"+this.idPersona+"' group by g.anno, g.seccion order by g.seccion;"); 
            tableModel.addRow(new Object[]{sql2[i][0],sql2[i][1],sql2[i][2]});
        }
        jTable2.setModel(tableModel);
        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }}
        
        /*{String parametro = jComboBox2.getSelectedItem().toString();
        if (base.getConexionCorrecta() != -1) {
            if ("Habitacion".equals(parametro)) {
                String[][] sql = base.getDatosConsulta("select p.descripcion, c.descripcion, d.descripcion from provincia p, canton c, dirpersona d where p.idprovincia = c.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+this.idPersona+"' and d.tipo = '"+parametro+"';");
                String nombreColumnas[] = {"Provincia","Canton","Direccion Exacta"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable1.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.descripcion, c.descripcion, d.descripcion from provincia p, canton c, dirpersona d where p.idprovincia = c.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+this.idPersona+"' and d.tipo = '"+parametro+"';");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2]});
                }
                jTable1.setModel(tableModel);
            } else if ("Oficina".equals(parametro)) {
                String[][] sql = base.getDatosConsulta("select p.descripcion, c.descripcion, d.descripcion from provincia p, canton c, dirpersona d where p.idprovincia = c.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+this.idPersona+"' and d.tipo = '"+parametro+"';");
                String nombreColumnas[] = {"Provincia","Canton","Direccion Exacta"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable1.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.descripcion, c.descripcion, d.descripcion from provincia p, canton c, dirpersona d where p.idprovincia = c.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+this.idPersona+"' and d.tipo = '"+parametro+"';");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2]});
                }
                jTable1.setModel(tableModel);
            }
            else {
               String[][] sql = base.getDatosConsulta("select p.descripcion, c.descripcion, d.descripcion from provincia p, canton c, dirpersona d where p.idprovincia = c.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+this.idPersona+"' and d.tipo = '"+parametro+"';");
                String nombreColumnas[] = {"Provincia","Canton","Direccion Exacta"};
                DefaultTableModel tableModel = new DefaultTableModel(nombreColumnas, 0);
                tableModel.setRowCount(0);
                jTable1.setModel(tableModel);
                for (int i = 0; i < sql.length; i++) {
                    String[][] sql2 = base.getDatosConsulta("select p.descripcion, c.descripcion, d.descripcion from provincia p, canton c, dirpersona d where p.idprovincia = c.idprovincia and d.idcanton = c.idcanton and d.idpersona = '"+this.idPersona+"' and d.tipo = '"+parametro+"';");
                    tableModel.addRow(new Object[]{sql2[i][0], sql2[i][1], sql2[i][2]});
                }
                jTable1.setModel(tableModel); 
            }

        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }}*/
        
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
    
    public int ActualizaDatosProfesor(String IdPersona, String Email, String Facebook){
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
    
    /*public int ActualizaCanton(String IdPersona, String Tipo, String Canton){
        //Metodo que actualiza la direccion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            int Consulta = base.actualizaProvincia(IdPersona,Tipo,Canton); 
            return Consulta;
        }else{
            return -1;
        }
    }*/
    
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
    
    public int ActualizaTelefonoProfesor(String Tipo, String IdPersona, String Telefono){
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaDirecciones = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaTelefonos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Perfil Profesor");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N

        jLabel1.setText("Identificación");

        jLabel2.setText("Primer Apellido");

        jLabel3.setText("Nombre");

        jLabel4.setText("Segundo Apellido");

        jLabel5.setText("Teléfono");

        jLabel6.setText("Correo Electrónico");

        jLabel7.setText("Sexo");

        jLabel8.setText("Facebook");

        jLabel9.setText("Fecha de Nacimiento");

        jLabel10.setText("Dirección");

        jLabel11.setText("Grupos");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(50);
        jScrollPane3.setViewportView(jTextArea2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nivel", "Seccion", "Materias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable2);

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

        tablaTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane12.setViewportView(tablaTelefonos);

        jButton3.setText("Guardar Telefonos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar Direccion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jTextField7))))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String tipo4 = tablaTelefonos.getModel().getValueAt(0, 0).toString();
        String telefono1 = tablaTelefonos.getModel().getValueAt(0, 1).toString();
        ActualizaTelefonoProfesor(tipo4,this.idPersona,telefono1);

        String tipo5 = tablaTelefonos.getModel().getValueAt(1, 0).toString();
        String telefono2 = tablaTelefonos.getModel().getValueAt(1, 1).toString();
        ActualizaTelefonoProfesor(tipo5,this.idPersona,telefono2);

        String tipo6 = tablaTelefonos.getModel().getValueAt(2, 0).toString();
        String telefono3 = tablaTelefonos.getModel().getValueAt(2, 1).toString();
        ActualizaTelefonoProfesor(tipo6,this.idPersona,telefono3);

        String tipo7 = tablaTelefonos.getModel().getValueAt(2, 0).toString();
        String telefono4 = tablaTelefonos.getModel().getValueAt(2, 1).toString();
        ActualizaTelefonoProfesor(tipo7,this.idPersona,telefono4);
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      String email = jTextField6.getText();
      String facebook = jTextField8.getText();  
      ActualizaDatosProfesor(this.idPersona,email,facebook);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable tablaDirecciones;
    private javax.swing.JTable tablaTelefonos;
    // End of variables declaration//GEN-END:variables
}
