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
    public PerfilProf() {
        initComponents();
    }
    
    public String Identificacion(String idPersona, String Parametro){
        //Metodo que devuelve la identificacion del Estudiante/Padre de Familia
        Parametro = jLabel1.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField1.setText(base.obtieneIdentificacion(idPersona, Parametro)); //La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneIdentificacion(idPersona, Parametro);
    }
    
    public String Nombre(String idPersona, String Parametro){
        //Metodo que devuelve el nombre del Estudiante/Padre de Familia
        Parametro = jLabel3.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField4.setText(base.obtieneNombre(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
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
            jTextField2.setText(base.obtieneApellido1(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneApellido1(idPersona, Parametro);
    }
    
    public String Apellido2(String idPersona, String Parametro){
        //Metodo que devuelve el segundo apellido del Estudiante/Padre de Familia
        Parametro = jLabel4.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField3.setText(base.obtieneApellido2(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneApellido2(idPersona, Parametro);
    }
    
    public String Sexo(String idPersona, String Parametro){
        //Metodo que devuelve el sexo del Estudiante/Padre de Familia
        Parametro = jLabel7.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField7.setText(base.obtieneSexo(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneSexo(idPersona, Parametro);
    }
    
    /*public String FechaNacimiento(String idPersona, String Parametro){
        //Metodo que devuelve la fecha de nacimiento del Estudiante/Padre de Familia
        Parametro = jLabel9.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jXDatePicker1.setText(base.obtieneFechaNacimiento(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneFechaNacimiento(idPersona, Parametro);
    }*/
    
    public String Email(String idPersona, String Parametro){
        //Metodo que devuelve el correo electronico del Estudiante/Padre de Familia
        Parametro = jLabel6.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField6.setText(base.obtieneEmail(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneEmail(idPersona, Parametro);
    }
    
    public String Facebook(String idPersona, String Parametro){
        //Metodo que devuelve el facebook del Estudiante/Padre de Familia
        Parametro = jLabel8.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField8.setText(base.obtieneFacebook(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneFacebook(idPersona, Parametro);
    }
    
    public String Direccion(String idPersona, String Parametro){
        //Metodo que devuelve la direccion del Estudiante/Padre de Familia
        Parametro = jLabel10.getText();
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
        Parametro = jLabel5.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            jTextField5.setText(base.obtieneTelefono(idPersona, Parametro));//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
        return base.obtieneTelefono(idPersona, Parametro);
    }
    
    public String ActualizaDatosEstudiante(String IdPersona, String Email, String Facebook){
        //Metodo que actualiza los datos de Estudiante/Padre de Familia
        Email = jLabel6.getText();
        Facebook = jLabel8.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            return base.actualizaDatosEstudiantePadreFamilia(IdPersona, Email, Facebook);//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
    }
    
    public String ActualizaDireccionEstudiante(String IdPersona, String Direccion){
        //Metodo que actualiza la direccion del Estudiante/Padre de Familia
        Direccion = jLabel10.getText();
        ConexionBase base= new ConexionBase();
        if(base.getConexionCorrecta()!= -1){
            return base.actualizaDireccionEstudiantePadreFamilia(IdPersona, Direccion);//La idea es llamar el texto de la parte de perfil que se guarda en la identificacion
        }else{
            return null;
        }
    }
    
    public String ActualizaTelefonoEstudiante(String IdPersona, String Telefono){
        //Metodo que actualiza el telefono del Estudiante/Padre de Familia
        Telefono = jLabel5.getText();
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
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jToggleButton1 = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Perfil Profesor");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N

        jLabel1.setText("Identificación");

        jLabel2.setText("Primer Apellido");

        jLabel3.setText("Nombre");

        jLabel4.setText("Segundo Apellido");

        jLabel5.setText("Telefono");

        jLabel6.setText("Correo Eléctronico");

        jLabel7.setText("Sexo");

        jLabel8.setText("Facebook");

        jLabel9.setText("Fecha Nacimiento");

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

        jToggleButton1.setText("Guardar");

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                        .addComponent(jTextField4)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(56, 56, 56)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField6)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane2))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jToggleButton1))
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
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JToggleButton jToggleButton1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
