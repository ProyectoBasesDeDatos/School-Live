/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author fugalde
 */
public class CrearAsignacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form AsignacionesProf
     */
    String idPersona;
    
    public CrearAsignacion(String idPersona) {
        this.idPersona = idPersona;
        initComponents();
        
        ConexionBase base = new ConexionBase();
        CBGrupo.removeAllItems();
        CBMateria.removeAllItems();
        //Agregar elementos a los combobox
        if (base.getConexionCorrecta() != -1) {
            String[][] valoresMaterias = base.getDatosConsulta("select m.nombremateria\n" +
                                                                "from materias m, persona p, profesores pr, impartemateria i\n" +
                                                                "where p.idpersona = pr.idpersona\n" +
                                                                    "and i.idprofesor = pr.idpersona\n" +
                                                                    "and m.idmateria = i.idmateria");


            for (int i = 0; i < valoresMaterias.length; i++) {
                CBMateria.addItem(valoresMaterias[i][0]);
            }
            if (base.getConexionCorrecta() != -1) {
                String[][] valoresGrupo = base.getDatosConsulta("select m.nombremateria\n" +
                                                                "from materias m, persona p, profesores pr, impartemateria i\n" +
                                                                "where p.idpersona = pr.idpersona\n" +
                                                                    "and i.idprofesor = pr.idpersona\n" +
                                                                    "and m.idmateria = i.idmateria");


                for (int i = 0; i < valoresGrupo.length; i++) {
                    CBMateria.addItem(valoresGrupo[i][0]);
                }


            } else {
                System.err.println("No se ha logrado establecer conexión con la base de datos");
            }
        }
    }
        
    private int crearAsignacionBase (String id, String tipo, String descripcion,String hora, Date fecha, String grupo, String profesor, String materia){
        String sqlAsignacion = "insert into asignacion(idasignacion, tipo, descripcion, hora, fecha, grupo, profesor, materia) values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = null;
        ConexionBase base = new ConexionBase();
        try {
            //sentencia = base.prepareStatement(sqlAsignacion);
            sentencia.setString(1, id);
            sentencia.setString(2, tipo);
            sentencia.setString(3, descripcion);
            sentencia.setString(4, hora);
            sentencia.setDate(5, (java.sql.Date)fecha);
            sentencia.setString(6, grupo);
            sentencia.setString(7, profesor);
            sentencia.setString(8, materia);
            sentencia.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return 1;

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
        CBGrupo = new javax.swing.JComboBox();
        jSplitPane1 = new javax.swing.JSplitPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TADescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        guardarAsignButton = new javax.swing.JButton();
        LHora = new javax.swing.JLabel();
        SHora = new JSpinner( new SpinnerDateModel() );
        DPFecha = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        LTipo = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        CBMateria = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Crear Asignación");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N

        jLabel1.setText("Grupo");

        CBGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBGrupoActionPerformed(evt);
            }
        });

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setEnabled(false);
        jInternalFrame1.setVisible(true);

        jLabel2.setText("Descripción");

        TADescripcion.setColumns(20);
        TADescripcion.setRows(5);
        jScrollPane2.setViewportView(TADescripcion);

        jLabel3.setText("Fecha de entrega");

        guardarAsignButton.setText("Guardar");
        guardarAsignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarAsignButtonActionPerformed(evt);
            }
        });

        LHora.setText("Hora");

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(SHora, "HH:mm");
        SHora.setEditor(timeEditor);
        SHora.setValue(new Date());

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardarAsignButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(DPFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LHora)
                    .addComponent(SHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DPFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(guardarAsignButton)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jInternalFrame1);

        LTipo.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Tarea", "Quiz", "Examen", "Proyecto", "Trabajo ExtraClase" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LTipo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LTipoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LTipo);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jLabel4.setText("Materia");

        CBMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSplitPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBGrupo, 0, 108, Short.MAX_VALUE)
                            .addComponent(CBMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CBMateria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBGrupoActionPerformed

    private void guardarAsignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarAsignButtonActionPerformed
        String tipo = LTipo.getSelectedValue().toString();
        String materia = CBMateria.getSelectedObjects()[0].toString();
        String grupo = CBGrupo.getSelectedObjects()[0].toString();
        Date fecha = DPFecha.getDate();
        String hora = SHora.getValue().toString();
        String descripcion = TADescripcion.getText();
        String[][] idasignacion = base.getDatosConsulta("select max(idasignacion) from asignacion;");
        int idasig;
        if(idasignacion[0][0] != null){
            idasig = Integer.parseInt(idasignacion[0][0])+1;
        }else{
            idasig = 1;
        }
        
        this.crearAsignacionBase(Integer.toString(idasig),tipo,descripcion,hora,fecha,grupo,this.idPersona,materia);
        
        
    }//GEN-LAST:event_guardarAsignButtonActionPerformed

    private void LTipoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LTipoValueChanged
        
    }//GEN-LAST:event_LTipoValueChanged

    private void CBMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CBGrupo;
    private javax.swing.JComboBox CBMateria;
    private org.jdesktop.swingx.JXDatePicker DPFecha;
    private javax.swing.JLabel LHora;
    private javax.swing.JList LTipo;
    private javax.swing.JSpinner SHora;
    private javax.swing.JTextArea TADescripcion;
    private javax.swing.JButton guardarAsignButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
