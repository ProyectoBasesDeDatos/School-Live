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
            base = DriverManager.getConnection(url,"postgres","admin");
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
    
    public void queryResults(String sql){
        if(getConexionCorrecta()!= -1){
            String[][] resultado = getDatosConsulta(sql);
            if(resultado != null){
                for(int x=0; x<resultado.length; x++){
                    for(int y=0; y<resultado[0].length; y++){
                        System.err.print(resultado[x][y ]+" ");
                    }
                    System.err.println("");
                }
            }else{
                System.err.println("Error al procesar la consulta o la consulta no ha traído resultados");
            }
        }else{
            System.err.println("No se ha logrado establecer conexión con la base de datos");
        }
    }
    
    public void queryNoResults(String sql){
        try {
		PreparedStatement sentencia = base.prepareStatement(sql);
                //https://docs.oracle.com/javase/6/docs/api/java/sql/Statement.html
		sentencia.executeUpdate();
		
	} catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public String [][] getDatosConsulta(String sql){        
	try {
		PreparedStatement sentencia = base.prepareStatement(sql);
                //https://docs.oracle.com/javase/6/docs/api/java/sql/Statement.html
		ResultSet resultado = sentencia.executeQuery();
		if(resultado != null){
			return 
			getMatrizResultado(resultado);
		}else{
			return null;
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
		return null;
	}
    }
    
    public String[][] getMatrizResultado(ResultSet resultado){        
	List lista = new ArrayList();
	try {
		ResultSetMetaData metadata = resultado.getMetaData();
		int columnas = metadata.getColumnCount();
		while (resultado.next()) {
			String[] datos = new String[columnas];
			for(int x =0;x<columnas;x++){
				datos[x] = resultado.getString(x+1);
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
    
        public boolean consultarUsuario(String idPersona, String contrasenna){
        //Metodo para validar que la contraseña y el usuario coinciden
        boolean usuarioValido;
        try {
            CallableStatement validUser= base.prepareCall("{? = call sp_validezusuario(?,?)}");
            validUser.registerOutParameter(1, Types.BOOLEAN);
            validUser.setString(2, idPersona);
            validUser.setString(3, contrasenna);
            validUser.execute();
            usuarioValido=validUser.getBoolean(1);
            
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
    
    
    public int crearAsignacion (String id, String tipo, String descripcion,String hora, String fecha, String grupo, String profesor, String materia){
        String sqlAsignacion = "insert into asignacion(idasignacion, tipo, descripcion, hora, fecha, grupo, profesor, materia) values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlAsignacion);
            sentencia.setString(1, id);
            sentencia.setString(2, tipo);
            sentencia.setString(3, descripcion);
            sentencia.setString(4, hora);
            sentencia.setString(5, fecha);
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

    public String obtieneIdentificacion(String idPersona) {
    
        String sqlIdentificacion = "select idpersona from persona where idpersona = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlIdentificacion);
            sentencia.setString(1, idPersona);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()){
                return resultado.getString("idpersona");
            }
            else {
                return null;
            }
            //sentencia.setString(2, Parametro);
            //sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }   
    }
    
    public String obtieneNombre(String idPersona, String Parametro) {
    
        String sqlNombre = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlNombre);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlNombre;    
    }
    
    public String obtieneApellido1(String idPersona, String Parametro) {
    
        String sqlApellido1 = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlApellido1);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlApellido1;    
    }
    
    public String obtieneApellido2(String idPersona, String Parametro) {
    
        String sqlApellido2 = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlApellido2);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlApellido2;    
    }
    
    public String obtieneSexo(String idPersona, String Parametro) {
    
        String sqlSexo = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlSexo);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlSexo;    
    }
    
    public String obtieneFechaNacimiento(String idPersona, String Parametro) {
    
        String sqlFechaNacimiento = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlFechaNacimiento);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlFechaNacimiento;    
    }
    
    public String obtieneEmail(String idPersona, String Parametro) {
    
        String sqlEmail = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlEmail);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlEmail;    
    }
    
    public String obtieneFacebook(String idPersona, String Parametro) {
    
        String sqlFacebook = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlFacebook);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlFacebook;    
    }
    
    public String obtieneTipoPerfil(String idPersona, String Parametro) {
    
        String sqlTipoPerfil = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlTipoPerfil);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlTipoPerfil;    
    }
    
    public String obtieneDireccion(String idPersona, String Parametro) {
    
        String sqlDireccion = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlDireccion);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlDireccion;
    }
    
    public String obtieneTelefono(String idPersona, String Parametro) {
    
        String sqlTelefono = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlTelefono);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlTelefono;
    }
    
    public String obtieneNivel(String idPersona, String Parametro) {
    
        String sqlNivel = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlNivel);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlNivel;
    }
    
    public String obtieneSeccion(String idPersona, String Parametro) {
    
        String sqlSeccion = "select InformacionPerfilEstudiantePadreFamilia(?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlSeccion);
            sentencia.setString(1, idPersona);
            sentencia.setString(2, Parametro);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlSeccion;
    }
    
    public String actualizaDatosEstudiantePadreFamilia(String IdPersona, String Email, String Facebook) {
    
        String sqlactualizaest = "update Persona set email = ?, facebook = ? where idpersona = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizaest);
            sentencia.setString(1, Email);
            sentencia.setString(2, Facebook);
            sentencia.setString(3, IdPersona);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlactualizaest;
    }
    
    public String actualizaDireccionEstudiantePadreFamilia(String IdPersona, String Direccion) {
    
        String sqlactualizaestdir = "update DirPersona set descripcion = ? where idpersona = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizaestdir);
            sentencia.setString(1, Direccion);
            sentencia.setString(2, IdPersona);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlactualizaestdir;
    }
    
    public String actualizaTelefonoEstudiantePadreFamilia(String IdPersona, String Telefono) {
    
        String sqlactualizaesttel = "update Telefono set tipotelefono = 'Casa', numerotelefono = ? where idpersona = ?;";
        PreparedStatement sentencia = null;
        try {
            sentencia = base.prepareStatement(sqlactualizaesttel);
            sentencia.setString(1, Telefono);
            sentencia.setString(2, IdPersona);
            sentencia.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    return sqlactualizaesttel;
    }
    
    public int insertarEstudiante(String id, String nombre, String apellido1, String apellido2, String sexo, String fechaNac, String email, String fb, String pwd, String tPerfil){
        String sql= "Insert into Persona(idPersona,nombre1,apellido1,apellido2,sexo,fecNacimiento,email,facebook,contrasenna,tipoPerfil) values (?,?,?,?,?,to_date(?,'dd/mm/yy'),?,?,?,?);";
        PreparedStatement sentencia = null;
        try{
            sentencia=base.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido1);
            sentencia.setString(4, apellido2);
            sentencia.setString(5, sexo);
            sentencia.setString(6,fechaNac);
            sentencia.setString(7, email);
            sentencia.setString(8, fb);
            sentencia.setString(9, pwd);
            sentencia.setString(10, tPerfil);
            sentencia.execute();

            return 1;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        
    }
    
}
