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
public class CalificacionesGrupo extends javax.swing.JInternalFrame {

    /**
     * Creates new form CalificacionesGrupo
     */
    private Object[][] resultadoG;
    private Object[][] resultadoM;
    private Object[][] resultadoE;
    private String idPersona;
    ConexionBase conexion;
    
    public CalificacionesGrupo(String idPersona) {
        initComponents();
        this.idPersona=idPersona;
    //String sql;
        //Object[][] resultado;
        conexion=new ConexionBase();
        
        //ComboBoxMaterias
        String sqlM="select idmateria,nombremateria\n" +
        "from profesores p, materias m \n" +
        "where p.idpersona='"+idPersona+"'\n" +
        "and p.idmateriaasignada= m.idmateria;";
        
        ComboMateria.removeAllItems();
        resultadoM = conexion.getDatosConsulta(sqlM);
        for (int i=0; i<resultadoM.length;i++){
            ComboMateria.addItem(resultadoM[i][0]+" - "+resultadoM[i][1]);
        }
        
        //ComboBoxGrupos
        
        String sqlG="select * \n" +
        "from grupo\n" +
        "where idgrupo IN (select g.idgrupo\n" +
                            "from (\n" +
                            "    select *\n" +
                            "    from profesores p, materias m \n" +
                            "    where p.idpersona='987654' --pone el id del profesor\n" +
                            "    and p.idmateriaasignada= m.idmateria) R1, gruposasignados g, estudiante e\n" +
                            "where R1.idmateria=g.idmateria\n" +
                            "and e.idgrupo=g.idgrupo)";
        ComboGrupo.removeAllItems();
        ComboGrupoEstudiante.removeAllItems();
        resultadoG = conexion.getDatosConsulta(sqlG);
        for (int i=0; i<resultadoG.length;i++){
            ComboGrupo.addItem(resultadoG[i][1]+" - "+resultadoG[i][2]);
            ComboGrupoEstudiante.addItem(resultadoG[i][1]+" - "+resultadoG[i][2]);
        }
        
        ComboMateria.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                CargarGrupo();
            }
        });
        
        ComboGrupo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                CargarGrupo();
            }
        });
        
        ComboPeriodo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                CargarGrupo();
            }
        });
        
        CargarGrupo();
        
        CargarComboEstudiante();
        
        ComboEstudiante.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                CargarEstudiante();
            }
        });
        
        ComboGrupoEstudiante.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                CargarComboEstudiante();
                CargarEstudiante();
            }
        });
        
        CargarEstudiante();
    }
    
    public void CargarComboEstudiante(){
    //ComboEstudiantes
        String sqlE="select nombre1||' '||apellido1||' '||apellido2,idpersona from persona where idpersona IN\n" +
        "(\n" +
        "select distinct e.idpersona\n" +
        "from (\n" +
        "    select *\n" +
        "    from profesores p, materias m \n" +
        "    where p.idpersona='"+idPersona+"'\n" +
        "    and p.idmateriaasignada= m.idmateria) R1, gruposasignados g, estudiante e\n" +
        "where R1.idmateria=g.idmateria\n" +
        "and e.idgrupo=g.idgrupo\n" +
        "and e.idgrupo='"+resultadoG[ComboGrupoEstudiante.getSelectedIndex()][0]+"'"+
        ");";
        resultadoE = conexion.getDatosConsulta(sqlE);
        ComboEstudiante.removeAllItems();
        
        for(int i=0;i<resultadoE.length;i++){
            ComboEstudiante.addItem(resultadoE[i][0]);
        }
    }
    
    public void CargarGrupo(){
        try{
        //TGrupo
        String sql="select p2.nombre1||' '||p2.apellido1||' '||p2.apellido2 nombre,parcial1,parcial2,trabajoextraclase,trabajocotidiano,asistencia,concepto,(parcial1+parcial2+trabajoextraclase+trabajocotidiano+asistencia+concepto) Total\n" +
        "from calificaciones c, calificacionesasignadas ca2, persona p2\n" +
        "where ca2.idcalificacion=c.idcalificacion\n" +
        "and p2.idpersona=ca2.idestudiante\n" +
        "and c.idcalificacion IN (\n" +
        "select ca.idcalificacion from calificacionesasignadas ca\n" +
        "where ca.idmateria='"+resultadoM[ComboMateria.getSelectedIndex()][0]+"'\n" +
        "and ca.periodo='"+ComboPeriodo.getSelectedItem().toString()+"'\n" +
        "and ca.idestudiante IN (\n" +
        "select distinct e.idpersona\n" +
        "from (\n" +
        "    select *\n" +
        "    from profesores p, materias m \n" +
        "    where p.idpersona='987654'\n" +
        "    and p.idmateriaasignada= m.idmateria) R1, gruposasignados g, estudiante e\n" +
        "where R1.idmateria=g.idmateria\n" +
        "and e.idgrupo=g.idgrupo\n" +
        "and e.idgrupo='"+resultadoG[ComboGrupo.getSelectedIndex()][0]+"'\n"+
        ")\n" +
        "order by idestudiante,periodo\n" +
        ")";
        String[] titulos = {"Estudiante", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"};
        Object[][] resultado = conexion.getDatosConsulta(sql);
        javax.swing.table.DefaultTableModel modelo;
        modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TGrupo.setModel(modelo);
        
        this.repaint();
        }
        catch(Exception err){
        
        }
    }

    public void CargarEstudiante(){
        Object[][] resultado;
        String[] periodo={"'I'","'II'","'III'"};
        String[] titulos = new String [] {"Materia", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"};
        
        //try{
        String elId=(String) resultadoE[ComboEstudiante.getSelectedIndex()][1];
        //1er Periodo, 2do Periodo, 3er Periodo
        String sql= "select m.nombremateria,c.parcial1,c.parcial2,c.trabajoextraclase,c.trabajocotidiano,c.asistencia,c.concepto,(c.parcial1+c.parcial2+c.trabajoextraclase+c.trabajocotidiano+c.asistencia+c.concepto) total\n" +
        "from materias m, calificacionesasignadas ca,calificaciones c\n" +
        "where m.idmateria=ca.idmateria\n" +
        "and ca.idcalificacion=c.idcalificacion\n" +
        "and ca.idestudiante='"+elId+"'"+
        "and ca.periodo=";

        resultado = conexion.getDatosConsulta(sql+periodo[0]);
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TPeriodo1Est.setModel(modelo);
        
        resultado = conexion.getDatosConsulta(sql+periodo[1]);
        modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TPeriodo2Est.setModel(modelo);
        
        resultado = conexion.getDatosConsulta(sql+periodo[2]);
        modelo = new javax.swing.table.DefaultTableModel(resultado,titulos);
        TPeriodo3Est.setModel(modelo);
        
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
        TAnualEst.setModel(modelo);
        
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TGrupo = new javax.swing.JTable();
        ComboGrupo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ComboPeriodo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        ComboMateria = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        JPanel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPeriodo1Est = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPeriodo2Est = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPeriodo3Est = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TAnualEst = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ComboGrupoEstudiante = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        ComboEstudiante = new javax.swing.JComboBox();
        Guardar = new javax.swing.JButton();
        Reporte = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Calificaciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d bar chart.png"))); // NOI18N

        TGrupo.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Estudiante", "Parcial I", "Parcial II", "T. Extraclase", "T. Cotidiano", "Asistencia", "Concepto", "Total"
            }
        ));
        TGrupo.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TGrupo);

        ComboGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboGrupoMouseClicked(evt);
            }
        });

        jLabel4.setText("Grupo");

        jLabel1.setText("Periodo");

        ComboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "I", "II", "III" }));
        ComboPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboPeriodoMouseClicked(evt);
            }
        });
        ComboPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPeriodoActionPerformed(evt);
            }
        });

        jLabel5.setText("Materia");

        ComboMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboMateriaMouseClicked(evt);
            }
        });
        ComboMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboMateria, 0, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ComboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vista Grupal", jPanel2);

        TPeriodo1Est.setModel(new javax.swing.table.DefaultTableModel(
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
        TPeriodo1Est.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TPeriodo1Est);

        JPanel.addTab("1er Periodo", jScrollPane1);

        TPeriodo2Est.setModel(new javax.swing.table.DefaultTableModel(
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
        TPeriodo2Est.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TPeriodo2Est);

        JPanel.addTab("2do Periodo", jScrollPane2);

        TPeriodo3Est.setModel(new javax.swing.table.DefaultTableModel(
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
        TPeriodo3Est.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TPeriodo3Est);

        JPanel.addTab("3er Periodo", jScrollPane3);

        TAnualEst.setModel(new javax.swing.table.DefaultTableModel(
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
        TAnualEst.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TAnualEst);

        JPanel.addTab("Anual", jScrollPane4);

        jLabel2.setText("Grupo");

        ComboGrupoEstudiante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Estudiante");

        ComboEstudiante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboGrupoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboGrupoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ComboEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(379, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Vista Estudiante", jPanel1);

        Guardar.setText("Guardar");

        Reporte.setText("Generar Reporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reporte)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Reporte))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMateriaActionPerformed
       
    }//GEN-LAST:event_ComboMateriaActionPerformed

    private void ComboPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPeriodoActionPerformed
        
    }//GEN-LAST:event_ComboPeriodoActionPerformed

    private void ComboGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboGrupoMouseClicked

    }//GEN-LAST:event_ComboGrupoMouseClicked

    private void ComboMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboMateriaMouseClicked

    }//GEN-LAST:event_ComboMateriaMouseClicked

    private void ComboPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboPeriodoMouseClicked

    }//GEN-LAST:event_ComboPeriodoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboEstudiante;
    private javax.swing.JComboBox ComboGrupo;
    private javax.swing.JComboBox ComboGrupoEstudiante;
    private javax.swing.JComboBox ComboMateria;
    private javax.swing.JComboBox ComboPeriodo;
    private javax.swing.JButton Guardar;
    private javax.swing.JTabbedPane JPanel;
    private javax.swing.JButton Reporte;
    private javax.swing.JTable TAnualEst;
    private javax.swing.JTable TGrupo;
    private javax.swing.JTable TPeriodo1Est;
    private javax.swing.JTable TPeriodo2Est;
    private javax.swing.JTable TPeriodo3Est;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
