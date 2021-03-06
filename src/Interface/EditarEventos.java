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
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Bryan Adams
 */
public class EditarEventos extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearEventos
     */
    String idPersona;
    String[][] eventos;
    
    public EditarEventos(String idPersona) {
        this.idPersona = idPersona;
        initComponents();
        
        ConexionBase base = new ConexionBase();
        
        if (base.getConexionCorrecta() != -1) {              
            actualizarListaEventos();           
            
            if(eventos != null){
                LEventos.setSelectedIndex(0);
                //setDatos(0);
            }else{
                DefaultListModel model2 = new DefaultListModel(); 
                LEventos.setModel(model2);
            }
            
            }else {
                System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }
    
    private void actualizarListaEventos(){
        ConexionBase base = new ConexionBase();
        DefaultListModel model = new DefaultListModel();    
        eventos = base.getDatosConsulta("select idevento, fecha, tipo, descripcion from evento e, persona p where e.autor = p.idpersona and p.idpersona = '"+idPersona+"';");
            if(eventos!= null){
                for (int i = 0; i < eventos.length; i++) {
                    model.addElement(eventos[i][0]+") "+eventos[i][1]+" / "+eventos[i][2]+" / "+eventos[i][3]);
                } 
                LEventos.setModel(model);
            } 
    }
    
    private void setDatos(int iEvento){
        String[] valoresTipo = {"Cultural", "Deportivo", "Otro"};
        
        int iTipo = 0;
        while(iTipo<valoresTipo.length&&eventos[iEvento][2].compareTo(valoresTipo[iTipo])!=0){
            iTipo++;
        }
        CBTipo.setSelectedIndex(iTipo);
        
        ConexionBase base = new ConexionBase();
        
        String[][] descrip = base.getDatosConsulta("select descripcion from evento where idevento = '"+eventos[iEvento][0]+"';");
        TADescripcion.setText(descrip[0][0]);
        
        String[][] fecha = base.getDatosConsulta("select fecha from evento where idevento = '"+eventos[iEvento][0]+"';");        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
          date = formatter.parse(fecha[0][0]);
        } catch (ParseException ex) {
            Logger.getLogger(EditarAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        DPFecha.setDate(date);
        
        String[][] horai = base.getDatosConsulta("select horainicio from evento where idevento = '"+eventos[iEvento][0]+"';");        
        DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
        Date timei = null;
        try {
          timei = formatter2.parse(horai[0][0]);
        } catch (ParseException ex) {
            Logger.getLogger(EditarEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        SHoraInicio.setValue(timei);
        
        String[][] horaf = base.getDatosConsulta("select horafinal from evento where idevento = '"+eventos[iEvento][0]+"';");        
        DateFormat formatter3 = new SimpleDateFormat("hh:mm:ss");
        Date timef = null;
        try {
          timef = formatter3.parse(horaf[0][0]);
        } catch (ParseException ex) {
            Logger.getLogger(EditarEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        SHoraInicio.setValue(timef);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBTipo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        DPFecha = new org.jdesktop.swingx.JXDatePicker();
        SHoraInicio = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(SHoraInicio, "HH:mm");
        SHoraInicio.setEditor(timeEditor);
        SHoraInicio.setValue(new Date());
        SHoraFinal = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(SHoraFinal, "HH:mm");
        SHoraFinal.setEditor(timeEditor2);
        SHoraFinal.setValue(new Date());
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TADescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        BGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LEventos = new javax.swing.JList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar Evento");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N

        CBTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cultural", "Deportivo", "Otro"}));
        CBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTipoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo");

        jLabel2.setText("Fecha Evento:");

        jLabel3.setText("Hora Inicio");

        jLabel4.setText("Hora Final");

        TADescripcion.setColumns(20);
        TADescripcion.setRows(5);
        jScrollPane1.setViewportView(TADescripcion);

        jLabel5.setText("Descripción");

        BGuardar.setText("Guardar");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });

        LEventos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LEventos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LEventosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(LEventos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(158, 158, 158))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DPFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DPFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(SHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BGuardar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTipoActionPerformed

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
        int error=0;
        try{
            ConexionBase base= new ConexionBase();           
            
            String tipo = CBTipo.getSelectedItem().toString();
            Date fecha = DPFecha.getDate();
            Date horaIn = (java.util.Date)SHoraInicio.getValue();
            Date horaFi = (java.util.Date)SHoraFinal.getValue();
            String descripcion = TADescripcion.getText();
            
            int ind = LEventos.getSelectedIndex();
            
            base.editarEventos(tipo, fecha, horaIn, horaFi, descripcion, idPersona,eventos[ind][0]);
            this.dispose();
            
        }catch(IllegalArgumentException	e){
            System.err.printf("Error al Editar Evento");
            error++;
            this.dispose();
        }
        
        if (error==0) {
                JOptionPane.showMessageDialog(null, "Se actualizo el evento seleccionado", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se logró actualizar correctamente el evento", "Error ", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_BGuardarActionPerformed

    private void LEventosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LEventosValueChanged
        int ind = LEventos.getSelectedIndex();
        setDatos(ind);
    }//GEN-LAST:event_LEventosValueChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGuardar;
    private javax.swing.JComboBox CBTipo;
    private org.jdesktop.swingx.JXDatePicker DPFecha;
    private javax.swing.JList LEventos;
    private javax.swing.JSpinner SHoraFinal;
    private javax.swing.JSpinner SHoraInicio;
    private javax.swing.JTextArea TADescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
