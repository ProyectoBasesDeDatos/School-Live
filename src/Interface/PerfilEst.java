/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import Interface.Login;

/**
 *
 * @author Carlos
 */
public class PerfilEst extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerfilEst
     */
    public PerfilEst() {
        initComponents();
    }

    public String Identificacion(String idPersona, String Parametro){
        //Metodo que devuelve la identificacion del Estudiante/Padre de Familia
        ConexionBase base= new ConexionBase();
        idPersona = base.obtenerUsuarioLogeado(); //Carlos: Este es un ejemplo del uso del metodo GET para tener el usuario logeado, crea un objeto ConexionBase y llama al metodo- Atte:Fabian
        Parametro = jLabel5.getText();
        
        if(base.getConexionCorrecta()!= -1){
            jTextPane5.setText(base.obtieneIdentificacion(idPersona, Parametro)); //La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneIdentificacion(idPersona, Parametro);
    }
    
    public String Nombre(String idPersona, String Parametro){
        //Metodo que devuelve el nombre del Estudiante/Padre de Familia
        Parametro = jLabel1.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane2.setText(base.obtieneNombre(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneNombre(idPersona, Parametro);
    }
    
    public String Apellido1(String idPersona, String Parametro){
        //Metodo que devuelve el primer apellido del Estudiante/Padre de Familia
        Parametro = jLabel2.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane4.setText(base.obtieneApellido1(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneApellido1(idPersona, Parametro);
    }
    
    public String Apellido2(String idPersona, String Parametro){
        //Metodo que devuelve el segundo apellido del Estudiante/Padre de Familia
        Parametro = jLabel3.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane3.setText(base.obtieneApellido2(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneApellido2(idPersona, Parametro);
    }
    
    public String Sexo(String idPersona, String Parametro){
        //Metodo que devuelve el sexo del Estudiante/Padre de Familia
        Parametro = jLabel4.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField4.setText(base.obtieneSexo(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneSexo(idPersona, Parametro);
    }
    
    public String FechaNacimiento(String idPersona, String Parametro){
        //Metodo que devuelve la fecha de nacimiento del Estudiante/Padre de Familia
        Parametro = jLabel6.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane10.setText(base.obtieneFechaNacimiento(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneFechaNacimiento(idPersona, Parametro);
    }
    
    public String Email(String idPersona, String Parametro){
        //Metodo que devuelve el correo electronico del Estudiante/Padre de Familia
        Parametro = jLabel9.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane8.setText(base.obtieneEmail(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneEmail(idPersona, Parametro);
    }
    
    public String Facebook(String idPersona, String Parametro){
        //Metodo que devuelve el facebook del Estudiante/Padre de Familia
        Parametro = jLabel10.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane9.setText(base.obtieneFacebook(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneFacebook(idPersona, Parametro);
    }
    
    public String TipoPerfil(String idPersona, String Parametro){
        //Metodo que devuelve tipo de usuario del Estudiante/Padre de Familia
        Parametro = jLabel12.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane9.setText(base.obtieneTipoPerfil(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneTipoPerfil(idPersona, Parametro);
    }
    
    public String Direccion(String idPersona, String Parametro){
        //Metodo que devuelve la direccion del Estudiante/Padre de Familia
        Parametro = jLabel7.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextArea1.setText(base.obtieneDireccion(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneDireccion(idPersona, Parametro);
    }
    
    public String Telefono(String idPersona, String Parametro){
        //Metodo que devuelve el telefono del Estudiante/Padre de Familia
        Parametro = jLabel8.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField2.setText(base.obtieneTelefono(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneTelefono(idPersona, Parametro);
    }
    
    public String Nivel(String idPersona, String Parametro){
        //Metodo que devuelve el Nivel del Estudiante/Padre de Familia
        Parametro = jLabel11.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField5.setText(base.obtieneNivel(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneNivel(idPersona, Parametro);
    }
    
    public String Seccion(String idPersona, String Parametro){
        //Metodo que devuelve la seccion del Estudiante/Padre de Familia
        Parametro = jLabel13.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextPane11.setText(base.obtieneSeccion(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneSeccion(idPersona, Parametro);
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
        jTextField2 = new javax.swing.JTextField();
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
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane11 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Perfil de estudiante");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Male.png"))); // NOI18N

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

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Nivel");

        jLabel13.setText("Sección");

        jScrollPane11.setViewportView(jTextPane11);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Perfil Personal", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane11;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    // End of variables declaration//GEN-END:variables
}
