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
import java.sql.SQLException;
import java.sql.Types;

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
}
