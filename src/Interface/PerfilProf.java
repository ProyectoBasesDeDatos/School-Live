/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;

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
    }
    
    public String Identificacion(String idPersona, String Parametro){
        //Metodo que devuelve la identificacion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
        
    }
    
    public String Nombre(String idPersona, String Parametro){
        //Metodo que devuelve el nombre del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String Apellido1(String idPersona, String Parametro){
        //Metodo que devuelve el primer apellido del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String Apellido2(String idPersona, String Parametro){
        //Metodo que devuelve el segundo apellido del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String Sexo(String idPersona, String Parametro){
        //Metodo que devuelve el sexo del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String FechaNacimiento(String idPersona, String Parametro){
        //Metodo que devuelve la fecha de nacimiento del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String Email(String idPersona, String Parametro){
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String Facebook(String idPersona, String Parametro){
        //Metodo que devuelve el facebook del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    /*public String TipoPerfil(String idPersona, String Parametro){
        //Metodo que devuelve tipo de usuario del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }*/
    
    public String Direccion(String idPersona, String Parametro){
        //Metodo que devuelve la direccion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String Telefono(String idPersona, String Parametro){
        //Metodo que devuelve el telefono del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            String Consulta = base.obtieneIdentificacion(idPersona, Parametro); 
            return Consulta;
        }else{
            return null;
        }
    }
    
    public String ActualizaDatosEstudiante(String IdPersona, String Email, String Facebook){
        //Metodo que actualiza los datos de Estudiante/Padre de Familia
        Email = jLabel9.getText();
        Facebook = jLabel10.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            return base.actualizaDatosEstudiantePadreFamilia(IdPersona, Email, Facebook);//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
    }
    
    public String ActualizaDireccionEstudiante(String IdPersona, String Direccion){
        //Metodo que actualiza la direccion del Estudiante/Padre de Familia
        Direccion = jLabel7.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            return base.actualizaDireccionEstudiantePadreFamilia(IdPersona, Direccion);//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
    }
    
    public String ActualizaTelefonoEstudiante(String IdPersona, String Telefono){
        //Metodo que actualiza el telefono del Estudiante/Padre de Familia
        Telefono = jLabel8.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            return base.actualizaTelefonoEstudiantePadreFamilia(IdPersona, Telefono);//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
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
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField9 = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel11.setText("Grupos");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jToggleButton1.setText("Ver");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Guardar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField5)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3)
                                            .addComponent(jTextField4))))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jToggleButton2)
                                .addContainerGap())
                            .addComponent(jScrollPane2)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        {String Parametro = jLabel1.getText();
        String prueba2 = Identificacion(this.idPersona, Parametro);
        jTextField1.setText(prueba2);}
        
        {String Parametro = jLabel3.getText();
        String prueba2 = Nombre(this.idPersona, Parametro);
        jTextField4.setText(prueba2);}
        
        {String Parametro = jLabel2.getText();
        String prueba2 = Apellido1(this.idPersona, Parametro);
        jTextField2.setText(prueba2);}
        
        {String Parametro = jLabel4.getText();
        String prueba2 = Apellido2(this.idPersona, Parametro);
        jTextField3.setText(prueba2);}
        
        {String Parametro = jLabel7.getText();
        String prueba2 = Sexo(this.idPersona, Parametro);
        jTextField7.setText(prueba2);}
        
        {String Parametro = jLabel9.getText();
        String prueba2 = FechaNacimiento(this.idPersona, Parametro);
        jTextField9.setText(prueba2);}
        
        {String Parametro = jLabel6.getText();
        String prueba2 = Email(this.idPersona, Parametro);
        jTextField6.setText(prueba2);}
        
        {String Parametro = jLabel8.getText();
        String prueba2 = Facebook(this.idPersona, Parametro);
        jTextField8.setText(prueba2);}
        
        {String Parametro = jLabel10.getText();
        String prueba2 = Direccion(this.idPersona, Parametro);
        jTextArea1.setText(prueba2);}
        
        {String Parametro = jLabel5.getText();
        String prueba2 = Telefono(this.idPersona, Parametro);
        jTextField5.setText(prueba2);}
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
