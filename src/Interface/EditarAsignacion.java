/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author fugalde
 */
public class EditarAsignacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarAsignacionProf
     */
    String idPersona;
    String[][] asignaciones;
    String[][] valoresGrupo;
    String[][] valoresMaterias;
            
    public EditarAsignacion(String idPersona) {
        this.idPersona=idPersona;
        initComponents();
        
        ConexionBase base = new ConexionBase();
        CBGrupo.removeAllItems();
        CBMateria.removeAllItems();
        
        if (base.getConexionCorrecta() != -1) {
            DefaultListModel model = new DefaultListModel();                    
            
            valoresMaterias = base.getDatosConsulta("select m.nombremateria, m.idmateria from materias m, (select idpersona from persona where idpersona = '"+idPersona+"') p, profesores pr where p.idpersona = pr.idpersona and m.idmateria = pr.idmateriaasignada group by m.nombremateria, m.idmateria;");
            if(valoresMaterias!=null){
                for (int i = 0; i < valoresMaterias.length; i++) {
                    CBMateria.addItem(valoresMaterias[i][0]);
                } 
            }
            
            valoresGrupo = base.getDatosConsulta("select g.idgrupo, g.anno, g.seccion from grupo g, impartegrupo ig where g.idgrupo = ig.idgrupo and ig.idprofesor = '"+idPersona+"' group by g.idgrupo, g.anno, g.seccion;");//Corregir
            if(valoresGrupo!=null){
                for (int i = 0; i < valoresGrupo.length; i++) {
                    CBGrupo.addItem(valoresGrupo[i][1]+"-"+valoresGrupo[i][2]);
                }
            }            
            
            asignaciones = base.getDatosConsulta("select a.idasignacion, a.tipo, a.materia, a.grupo from asignacion a, persona p where a.profesor = p.idpersona and p.idpersona = '"+idPersona+"';");
            if(asignaciones!= null){
                for (int i = 0; i < asignaciones.length; i++) {
                    model.addElement(asignaciones[i][0]+") "+getGrupo(asignaciones[i][3])+" / "+getMateria(asignaciones[i][2])+" / "+asignaciones[i][1]);
                } 
                LAsignaciones.setModel(model);
            }    
            if(asignaciones != null){
                LAsignaciones.setSelectedIndex(0);
                //setDatos(0);
            }else{
                DefaultListModel model2 = new DefaultListModel(); 
                LAsignaciones.setModel(model2);
            }
            
        }else {
                System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }
    
    private String getGrupo(String id){        
        String grupo = "";
        int i = 0;
        while(i<valoresGrupo.length&&grupo.compareTo("")==0){
            if(valoresGrupo[i][0].compareTo(id)==0){
                grupo = valoresGrupo[i][1]+"-"+valoresGrupo[i][2];
            }
            i++;
        }
        return grupo;
    }
    
    private String getMateria(String id){        
        String materia = "";
        int i = 0;
        while(i<valoresMaterias.length&&materia.compareTo("")==0){
            if(valoresMaterias[i][1].compareTo(id)==0){
                materia = valoresMaterias[i][0];
            }
            i++;
        }
        return materia;
    }
    
    private void setDatos(int iAsig){
        String[] valoresTipo = {"TA", "QZ", "EX", "PR", "TE", "NoDef"};
        /*
        int iAsig = 0;
        while(iAsig<asignaciones.length&&idAsignacion.compareTo(asignaciones[iAsig][0])!=0){
            iAsig++;
        }*/
        int iGrup = 0;
        while(iGrup<valoresGrupo.length&&asignaciones[iAsig][3].compareTo(valoresGrupo[iGrup][0])!=0){
            iGrup++;
        }
        int iMat = 0;
        while(iMat<valoresMaterias.length&&asignaciones[iAsig][2].compareTo(valoresMaterias[iMat][1])!=0){
            iMat++;
        }
        
        int iTipo = 0;
        while(iTipo<valoresTipo.length&&asignaciones[iAsig][1].compareTo(valoresTipo[iTipo])!=0){
            iTipo++;
        }
        CBGrupo.setSelectedIndex(iGrup);
        CBMateria.setSelectedIndex(iMat);
        CBTipo.setSelectedIndex(iTipo);
        
        ConexionBase base = new ConexionBase();
        
        String[][] descrip = base.getDatosConsulta("select descripcion from asignacion where idasignacion = '"+asignaciones[iAsig][0]+"';");
        TADescripcion.setText(descrip[0][0]);
        
        String[][] fecha = base.getDatosConsulta("select fecha from asignacion where idasignacion = '"+asignaciones[iAsig][0]+"';");        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
          date = formatter.parse(fecha[0][0]);
        } catch (ParseException ex) {
            Logger.getLogger(EditarAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        DPFecha.setDate(date);
        
        String[][] hora = base.getDatosConsulta("select hora from asignacion where idasignacion = '"+asignaciones[iAsig][0]+"';");        
        DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
        Date time = null;
        try {
          time = formatter2.parse(hora[0][0]);
        } catch (ParseException ex) {
            Logger.getLogger(EditarAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        SHora.setValue(time);
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
        jLabel2 = new javax.swing.JLabel();
        CBTipo = new javax.swing.JComboBox();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        LAsignaciones = new javax.swing.JList();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TADescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        DPFecha = new org.jdesktop.swingx.JXDatePicker();
        BGuardar = new javax.swing.JButton();
        LHora = new javax.swing.JLabel();
        SHora = new JSpinner( new SpinnerDateModel() );
        jLabel5 = new javax.swing.JLabel();
        CBMateria = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar Asignación");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N

        jLabel1.setText("Grupo:");

        CBGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Setimo", "Octavo", "Noveno", "Quinto" }));
        CBGrupo.setToolTipText("Seleccione un grupo el cual desea consultar las asignaciones");
        CBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBGrupoActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo Asignación:");

        CBTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tarea", "Quiz", "Examen", "Proyecto", "Trabajo Extraclase" }));

        jSplitPane2.setDividerLocation(250);

        LAsignaciones.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LAsignaciones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LAsignacionesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LAsignaciones);

        jSplitPane2.setLeftComponent(jScrollPane1);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setVisible(true);

        jLabel3.setText("Descripción");

        TADescripcion.setColumns(20);
        TADescripcion.setRows(5);
        jScrollPane2.setViewportView(TADescripcion);

        jLabel4.setText("Fecha");

        BGuardar.setText("Guardar");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BGuardar))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DPFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(LHora)
                            .addComponent(SHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DPFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BGuardar)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jInternalFrame1);

        jLabel5.setText("Materia");

        CBMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(75, 75, 75)
                                .addComponent(CBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CBMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CBGrupo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBGrupoActionPerformed

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
        try{
            ConexionBase base= new ConexionBase();
            int ind = LAsignaciones.getSelectedIndex();
            base.queryNoResults("delete from asignacion where idasignacion = '"+asignaciones[ind][0]+"';");
            
            String tipo = CBTipo.getSelectedItem().toString();
            String materia = CBMateria.getSelectedItem().toString();
            String idMateria = "";
            int j = 0;
            while(j<valoresMaterias.length&&idMateria.compareTo("")==0){
                if(valoresMaterias[j][0].compareTo(materia)==0){
                    idMateria = valoresMaterias[j][1];
                }
                j++;
            }
            String grupo = CBGrupo.getSelectedItem().toString();
            String idGrupo = "";
            int i = 0;
            while(i<valoresGrupo.length&&idGrupo.compareTo("")==0){
                if(valoresGrupo[i][1].compareTo(grupo.substring(0,2))==0&&valoresGrupo[i][2].compareTo(grupo.substring(3,5))==0){
                    idGrupo = valoresGrupo[i][0];
                }
                i++;
            }
            Date fecha = DPFecha.getDate();
            Date hora = (java.util.Date)SHora.getValue();
            String descripcion = TADescripcion.getText();
            String[][] idasignacion = base.getDatosConsulta("select max(idasignacion) from asignacion;");
            int idasig;
            if(idasignacion[0][0] != null){
                idasig = Integer.parseInt(idasignacion[0][0])+1;
            }else{
                idasig = 1;
            }
            base.crearAsignacionBase(Integer.toString(idasig),tipo,descripcion,hora,fecha,idGrupo,this.idPersona,idMateria);
        }catch(IllegalArgumentException	e){
            System.err.printf("Error al crear Asignacion");
        }
    }//GEN-LAST:event_BGuardarActionPerformed

    private void LAsignacionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LAsignacionesValueChanged
        int ind = LAsignaciones.getSelectedIndex();
        setDatos(ind);
    }//GEN-LAST:event_LAsignacionesValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGuardar;
    private javax.swing.JComboBox CBGrupo;
    private javax.swing.JComboBox CBMateria;
    private javax.swing.JComboBox CBTipo;
    private org.jdesktop.swingx.JXDatePicker DPFecha;
    private javax.swing.JList LAsignaciones;
    private javax.swing.JLabel LHora;
    private javax.swing.JSpinner SHora;
    private javax.swing.JTextArea TADescripcion;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    // End of variables declaration//GEN-END:variables
}
