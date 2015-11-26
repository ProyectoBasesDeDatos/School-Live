/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDatos.ConexionBase;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Tek
 */
public class VistaCalificaciones extends javax.swing.JInternalFrame {

    private Object [][] resultadoE;
    private ConexionBase conexion;
    
    public VistaCalificaciones(String idPersona) {
        initComponents();
        
        conexion = new ConexionBase();
        
        //Combobox
        String sql="select nombre1||' '||apellido1||' '||apellido2,idpersona,tipoperfil from persona where idpersona='"+idPersona+"';";
        resultadoE = conexion.getDatosConsulta(sql);

        if(resultadoE[0][2].toString().equals("E")){
            EstudianteSeleccion.removeAllItems();
            EstudianteSeleccion.addItem(resultadoE[0][0]+" - "+resultadoE[0][1]);
        }
        if(resultadoE[0][2].toString().equals("F")){
            sql="select nombre1||' '||apellido1||' '||apellido2,idpersona,tipoperfil \n" +
            "from persona \n" +
            "where idpersona IN (select idhijo from padrefamilia where idpersona='"+idPersona+"')";
            resultadoE = conexion.getDatosConsulta(sql);
            EstudianteSeleccion.removeAllItems();
            for(int i=0; i<resultadoE.length;i++){
                EstudianteSeleccion.addItem(resultadoE[i][0]+" - "+resultadoE[i][1]);
            }
        }
        
        EstudianteSeleccion.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                CargarEstudiante();
            }
        });
        
        CargarEstudiante();
        
        this.repaint();

    }

        public void CargarEstudiante(){
        Object[][] resultado;
        String[] periodo={"'I'","'II'","'III'"};
        String[] titulos = new String [] {"Materia", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"};
        
        //try{
        String elId=(String) resultadoE[EstudianteSeleccion.getSelectedIndex()][1];
        //1er Periodo, 2do Periodo, 3er Periodo
        String sql= "select m.nombremateria,c.parcial1,c.parcial2,c.trabajoextraclase,c.trabajocotidiano,c.asistencia,c.concepto,(c.parcial1+c.parcial2+c.trabajoextraclase+c.trabajocotidiano+c.asistencia+c.concepto) total\n" +
        "from materias m, calificacionesasignadas ca,calificaciones c\n" +
        "where m.idmateria=ca.idmateria\n" +
        "and ca.idcalificacion=c.idcalificacion\n" +
        "and ca.idestudiante='"+elId+"'"+
        "and ca.periodo=";

        resultado = conexion.getDatosConsulta(sql+periodo[0]);
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TPeriodo1.setModel(modelo);
        
        resultado = conexion.getDatosConsulta(sql+periodo[1]);
        modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TPeriodo2.setModel(modelo);
        
        resultado = conexion.getDatosConsulta(sql+periodo[2]);
        modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TPeriodo3.setModel(modelo);
        
        //Anual
        titulos = new String [] {"Materia", "1er Periodo", "2do Periodo", "3er Periodo", "Promedio Anual"};        
        sql= "select x.nombremateria,x.I_Periodo,y.II_Periodo,z.III_Periodo,(x.I_Periodo+y.II_Periodo+z.III_Periodo)/3 Promedio from (\n" +
        "	select m.nombremateria,(c.parcial1+c.parcial2+c.trabajoextraclase+c.trabajocotidiano+c.asistencia+c.concepto) I_Periodo \n" +
        "	from materias m, calificacionesasignadas ca,calificaciones c \n" +
        "	where m.idmateria=ca.idmateria \n" +
        "	and ca.idcalificacion=c.idcalificacion\n" +
        "	and ca.idestudiante='"+elId+"'\n" +
        "	and ca.periodo='I'\n" +
        ") x,\n" +
        "(\n" +
        "select m.nombremateria,(c.parcial1+c.parcial2+c.trabajoextraclase+c.trabajocotidiano+c.asistencia+c.concepto) II_Periodo \n" +
        "from materias m, calificacionesasignadas ca,calificaciones c \n" +
        "where m.idmateria=ca.idmateria \n" +
        "and ca.idcalificacion=c.idcalificacion\n" +
        "and ca.idestudiante='"+elId+"'\n" +
        "and ca.periodo='II'\n" +
        ") y,\n" +
        "(\n" +
        "select m.nombremateria,(c.parcial1+c.parcial2+c.trabajoextraclase+c.trabajocotidiano+c.asistencia+c.concepto) III_Periodo \n" +
        "from materias m, calificacionesasignadas ca,calificaciones c \n" +
        "where m.idmateria=ca.idmateria \n" +
        "and ca.idcalificacion=c.idcalificacion\n" +
        "and ca.idestudiante='"+elId+"'\n" +
        "and ca.periodo='III'\n" +
        ") z\n" +
        "where x.nombremateria=y.nombremateria\n" +
        "and y.nombremateria=z.nombremateria";
        
        resultado = conexion.getDatosConsulta(sql);
        modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TAnual.setModel(modelo);
        
        this.repaint();
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
        EstudianteSeleccion = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPeriodo1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPeriodo2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPeriodo3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TAnual = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Calificaciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png"))); // NOI18N

        jLabel1.setText("Estudiante");

        EstudianteSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estudiante", "", "", "" }));
        EstudianteSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteSeleccionActionPerformed(evt);
            }
        });

        TPeriodo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Materia", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"
            }
        ));
        TPeriodo1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TPeriodo1);

        jTabbedPane1.addTab("1er Periodo", jScrollPane1);

        TPeriodo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Materia", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"
            }
        ));
        TPeriodo2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TPeriodo2);

        jTabbedPane1.addTab("2do Periodo", jScrollPane2);

        TPeriodo3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Materia", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"
            }
        ));
        TPeriodo3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TPeriodo3);

        jTabbedPane1.addTab("3er Periodo", jScrollPane3);

        TAnual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Materia", "1er Periodo", "2do Periodo", "3er Periodo", "Promedio Anual", "Aprobado"
            }
        ));
        TAnual.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TAnual);

        jTabbedPane1.addTab("Anual", jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstudianteSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(EstudianteSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EstudianteSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteSeleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstudianteSeleccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox EstudianteSeleccion;
    private javax.swing.JTable TAnual;
    private javax.swing.JTable TPeriodo1;
    private javax.swing.JTable TPeriodo2;
    private javax.swing.JTable TPeriodo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
