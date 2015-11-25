/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fugalde
 */
public class ConexionBase {

    int conexion_correcta = 0;
    Connection base = null;

    public ConexionBase() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            base = DriverManager.getConnection(url, "postgres", "admin");
            conexion_correcta = 1;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            conexion_correcta = -1;
        }
    }

    public int getConexionCorrecta() {
        return conexion_correcta;
    }

    public int cerrarConexion() {
        try {
            base.close();
            return 1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public void queryResults(String sql) {
        if (getConexionCorrecta() != -1) {
            String[][] resultado = getDatosConsulta(sql);
            if (resultado != null) {
                for (int x = 0; x < resultado.length; x++) {
                    for (int y = 0; y < resultado[0].length; y++) {
                        System.err.print(resultado[x][y] + " ");
                    }
                    System.err.println("");
                }
            } else {
                System.err.println("Error al procesar la consulta o la consulta no ha traído resultados");
            }
        } else {
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }

    public void queryNoResults(String sql) {
        try {
            PreparedStatement sentencia = base.prepareStatement(sql);
            //https://docs.oracle.com/javase/6/docs/api/java/sql/Statement.html
            sentencia.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String[][] getDatosConsulta(String sql) {
        try {
            PreparedStatement sentencia = base.prepareStatement(sql);
            //https://docs.oracle.com/javase/6/docs/api/java/sql/Statement.html
            ResultSet resultado = sentencia.executeQuery();
            if (resultado != null) {
                return getMatrizResultado(resultado);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String[][] getMatrizResultado(ResultSet resultado) {
        List lista = new ArrayList();
        try {
            ResultSetMetaData metadata = resultado.getMetaData();
            int columnas = metadata.getColumnCount();
            while (resultado.next()) {
                String[] datos = new String[columnas];
                for (int x = 0; x < columnas; x++) {
                    datos[x] = resultado.getString(x + 1);
                }
                lista.add(datos);
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return aMatriz(lista);
    }

    private String[][] aMatriz(List lista) {
        if (lista.size() > 0) {
            String[][] matriz = new String[lista.size()][];
            for (int i = 0; i < lista.size(); i++) {
                matriz[i] = (String[]) lista.get(i);
            }
            return matriz;
        } else {
            return null;
        }
    }

    public boolean consultarUsuario(String idPersona, String contrasenna) {
        //Metodo para validar que la contraseña y el usuario coinciden
        boolean usuarioValido;
        try {
            CallableStatement validUser = base.prepareCall("{? = call sp_validezusuario(?,?)}");
            validUser.registerOutParameter(1, Types.BOOLEAN);
            validUser.setString(2, idPersona);
            validUser.setString(3, contrasenna);
            validUser.execute();
            usuarioValido = validUser.getBoolean(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return usuarioValido;
    }

    public String consultarTipoPerfil(String idPersona) {

        String tipoPerfil;
        try {
            CallableStatement validUser = base.prepareCall("{? = call sp_tipoUsuario(?)}");
            validUser.registerOutParameter(1, Types.VARCHAR);
            validUser.setString(2, idPersona);
            validUser.execute();
            tipoPerfil = validUser.getString(1);
            return tipoPerfil;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public String obtieneParametro(String idPersona, String Parametro) {

        String sqlIdentificacion = "{ ? = call InformacionPerfilEstudiantePadreFamilia(?,?)}";
        CallableStatement sentencia = null;
        String Resultado;
        try {
            sentencia = base.prepareCall(sqlIdentificacion);
            sentencia.registerOutParameter(1, Types.VARCHAR);
            sentencia.setString(2, idPersona);
            sentencia.setString(3, Parametro);
            sentencia.execute();
            Resultado = sentencia.getString(1);
            if (Resultado != null) {
                return Resultado;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int actualizaDatos(String IdPersona, String Email, String Facebook) {

        String sqlactualizadatos = "update Persona set email = ?, facebook = ? where idpersona = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizadatos);
            sentencia.setString(1, Email);
            sentencia.setString(2, Facebook);
            sentencia.setString(3, IdPersona);
            sentencia.execute();
            return 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int actualizaProvinciaCanton(String IdPersona, String Tipo, String Provincia, String Canton) {

        String sqlactualizadir = "update DirPersona set idprovincia = substring(? from 1 for 2),idcanton = substring(? from 1 for 2) where idpersona = ? and tipo = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizadir);
            sentencia.setString(1, Provincia);
            sentencia.setString(2, Canton);
            sentencia.setString(3, IdPersona);
            sentencia.setString(4, Tipo);
            sentencia.execute();
            return 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }

    }
    
    public int actualizaDireccion(String IdPersona, String Tipo, String Direccion) {

        String sqlactualizadir = "update DirPersona set descripcion = ? where idpersona = ? and tipo = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizadir);
            sentencia.setString(1, Direccion);
            sentencia.setString(2, IdPersona);
            sentencia.setString(3, Tipo);
            sentencia.execute();
            return 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }

    }

    public int actualizaTelefono(String Tipo, String IdPersona, String Telefono) {

        String sqlactualizaetel = "update Telefono set numerotelefono = ? where idpersona = ? and tipotelefono = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizaetel);
            sentencia.setString(1, Telefono);
            sentencia.setString(2, IdPersona);
            sentencia.setString(3, Tipo);
            sentencia.execute();
            return 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }

    }

    public int insertarEstudiante(String id, String nombre, String apellido1, String apellido2, String sexo, String fechaNac, String email, String fb, String pwd, String tPerfil) {
        String sql = "Insert into Persona(idPersona,nombre1,apellido1,apellido2,sexo,fecNacimiento,email,facebook,contrasenna,tipoPerfil) values (?,?,?,?,?,to_date(?,'dd/mm/yy'),?,?,?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido1);
            sentencia.setString(4, apellido2);
            sentencia.setString(5, sexo);
            sentencia.setString(6, fechaNac);
            sentencia.setString(7, email);
            sentencia.setString(8, fb);
            sentencia.setString(9, pwd);
            sentencia.setString(10, tPerfil);
            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }

    }

    public int insertarDireccion(String id, String tipo, String idProvincia, String idCanton, String descripcion) {
        String sql = "Insert into dirpersona(idpersona,tipo,idprovincia,idcanton,descripcion) values (?,?,?,?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, tipo);
            sentencia.setString(3, idProvincia);
            sentencia.setString(4, idCanton);
            sentencia.setString(5, descripcion);
            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int insertarTelefonos(String id, String tipo, String numero) {
        String sql = "Insert into telefono(idpersona,tipotelefono,numerotelefono) values (?,?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, tipo);
            sentencia.setString(3, numero);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int insertarEstudianteEnGrupo(String id, String grupo) {
        String sql = "Insert into estudiante(idpersona,idgrupo) values (?,?);";
        PreparedStatement sentencia = null;
        try {

            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, grupo);
            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int insertarHijos(String id, String[] listaHijos) {
        String sql = "Insert into padrefamilia(idpersona,idhijo) values (?,?);";
        PreparedStatement sentencia = null;
        try {
            for (int i = 0; i < listaHijos.length; i++) {
                sentencia = base.prepareStatement(sql);
                sentencia.setString(1, id);
                sentencia.setString(2, listaHijos[i]);
                sentencia.execute();
            }

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int insertarProfesor(String id, String[] listaMaterias) {
        String sql = "insert into profesores(idpersona,idmateriaasignada)values(?,?);";
        PreparedStatement sentencia = null;
        try {
            for (int i = 0; i < listaMaterias.length; i++) {
                sentencia = base.prepareStatement(sql);
                sentencia.setString(1, id);
                sentencia.setString(2, listaMaterias[i]);
                sentencia.execute();
            }

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    /* public int insertarEstudianteEnGrupo(String id, String grupo) {
     String sql = "Insert into estudiante(idpersona,idgrupo) values (?,?);";
     PreparedStatement sentencia = null;
     try {

     sentencia = base.prepareStatement(sql);
     sentencia.setString(1, id);
     sentencia.setString(2, grupo);
     sentencia.execute();

     return 1;
     } catch (SQLException ex) {
     ex.printStackTrace();
     return -1;
     }
     }
     public int insertarHijos(String id, String[] listaHijos) {
     String sql = "Insert into padrefamilia(idpersona,idhijo) values (?,?);";
     PreparedStatement sentencia = null;
     try {
     for (int i = 0; i < listaHijos.length; i++) {
     sentencia = base.prepareStatement(sql);
     sentencia.setString(1, id);
     sentencia.setString(2, listaHijos[i]);
     sentencia.execute();
     }

     return 1;
     } catch (SQLException ex) {
     ex.printStackTrace();
     return -1;
     }
     }*/

    public int actualizarEstudiante(String nombre, String apellido1, String apellido2, String sexo, String fechaNac, String email, String fb, String pwd, String id) {
        String sql = "Update persona set nombre1=?, apellido1=?, apellido2=?, sexo=?, fecnacimiento=to_date(?,'dd/mm/yy'),email=?,facebook=?,contrasenna=? where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido1);
            sentencia.setString(3, apellido2);
            sentencia.setString(4, sexo);
            sentencia.setString(5, fechaNac);
            sentencia.setString(6, email);
            sentencia.setString(7, fb);
            sentencia.setString(8, pwd);
            sentencia.setString(9, id);
            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int actualizarEstudianteEnGrupo(String id, String idGrupo) {
        String sql = "Update estudiante set idgrupo=? where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idGrupo);
            sentencia.setString(2, id);
            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int actualizarDireccion(String id, String tipo, String idProvincia, String idCanton, String descripcion) {
        String sql = "Update dirpersona set idprovincia=?,idcanton=?,descripcion=? where idpersona=? and tipo=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);

            sentencia.setString(1, idProvincia);
            sentencia.setString(2, idCanton);
            sentencia.setString(3, descripcion);
            sentencia.setString(4, id);
            sentencia.setString(5, tipo);
            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int actualizarTelefonos(String id, String tipo, String numero) {
        String sql = "Update telefono set numerotelefono=? where idpersona=? and tipotelefono=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, numero);
            sentencia.setString(2, id);
            sentencia.setString(3, tipo);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int eliminarMateriasAsignadas(String idPersona) {
        String sql = "delete from profesores where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int eliminarHijosAsignados(String idPersona) {
        String sql = "delete from padrefamilia where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int eliminarProfesor(String idPersona) {
        String sql = "delete from profesores where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from dirpersona where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from telefono where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from persona where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int eliminarEstudiantes(String idPersona) {
        String sql = "delete from padrefamilia where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from estudiante where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from dirpersona where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from telefono where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from persona where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int eliminarPadreFamilia(String idPersona) {
        String sql = "delete from padrefamilia where idpersona=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from dirpersona where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from telefono where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        sql = "delete from persona where idpersona=?;";
        sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int actualizarMsjVisto(String idMsj) {
        String sql = "update mensaje set leido=true where idmensaje=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idMsj);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int enviarMensaje(String idAutor, String idDestino, String asunto, String descripcion) {
        String sql = "insert into mensaje(idmensaje, destinatario, autor, asunto, descripcion, leido) values (nextval('idMensaje'),?,?,?,?,false)";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1,idDestino );
            sentencia.setString(2, idAutor);
            sentencia.setString(3, asunto);
            sentencia.setString(4, descripcion);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int crearAsignacionBase (String id, String tipo, String descripcion,Date hora, Date fecha, String grupo, String profesor, String materia){
        String sql = "insert into asignacion(idasignacion, tipo, descripcion, hora, fecha, grupo, profesor, materia) values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            
            int horas = hora.getHours();
            int minutos = hora.getMinutes();
            String sHoras = Integer.toString(horas)+":"+Integer.toString(minutos)+":00";
            java.sql.Time tiempo = java.sql.Time.valueOf(sHoras);
                        
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            int anno = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            String sFecha = Integer.toString(anno)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia);
            java.sql.Date fechaSQL = java.sql.Date.valueOf( sFecha );
            
            String abTipo;
            switch(tipo){
                case "Tarea":
                    abTipo = "TA";
                    break;
                case "Quiz":
                    abTipo = "QZ";
                    break;
                case "Examen":
                    abTipo = "EX";
                    break;
                case "Proyecto":
                    abTipo = "PR";
                    break;
                case "Trabajo Extraclase":
                    abTipo = "TE";
                    break;
                default:
                    abTipo = "NoDef";                    
            }
            
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, abTipo);
            sentencia.setString(3, descripcion);
            sentencia.setTime(4, tiempo);
            sentencia.setDate(5, fechaSQL);
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
    
    public int crearEvento(String id, String tipo, Date fecha, Date horaInicio, Date horaFinal,String descripcion, String autor){
        String sql = "insert into evento(idevento, tipo, fecha, horainicio, horafinal, descripcion, autor) values(?,?,?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            
            int horasi = horaInicio.getHours();
            int minutosi = horaInicio.getMinutes();
            String sHorasi = Integer.toString(horasi)+":"+Integer.toString(minutosi)+":00";
            java.sql.Time tiempoi = java.sql.Time.valueOf(sHorasi);
            
            int horasf = horaFinal.getHours();
            int minutosf = horaFinal.getMinutes();
            String sHorasf = Integer.toString(horasf)+":"+Integer.toString(minutosf)+":00";
            java.sql.Time tiempof = java.sql.Time.valueOf(sHorasf);
                        
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            int anno = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            String sFecha = Integer.toString(anno)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia);
            java.sql.Date fechaSQL = java.sql.Date.valueOf( sFecha );
            
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, tipo);
            sentencia.setDate(3, fechaSQL);
            sentencia.setTime(4, tiempoi);
            sentencia.setTime(5, tiempof);
            sentencia.setString(6, descripcion);
            sentencia.setString(7, autor);
            sentencia.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return 1;
    }
    
   public int asignarGruposProfesor(String id,String []listaGrupos){
        String sql = "insert into impartegrupo values(?,?);";
        PreparedStatement sentencia = null;
        try {
            for (int i = 0; i < listaGrupos.length; i++) {
                sentencia = base.prepareStatement(sql);
                sentencia.setString(1, id);
                sentencia.setString(2, listaGrupos[i]);
                sentencia.execute();
            }

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
   }
       public int eliminarGruposAsignados(String idPersona) {
        String sql = "delete from impartegrupo where idprofesor=?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sql);
            sentencia.setString(1, idPersona);

            sentencia.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}

