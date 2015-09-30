/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionPSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tek
 */
public class Conexion {
    
    int estadoConexion = 0;
    Connection base = null;
    String hostBase;
    String nombreBase;
    String puertoBase;
    String usuarioBase;
    String passwordBase;
    
    public Conexion(String host, String base, String puerto, String usuario, String password){
        hostBase = host;
        nombreBase = base;
        puertoBase = puerto;
        usuarioBase = usuario;
        passwordBase = password;
    }

    public int iniciarConexion(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+hostBase+":"+puertoBase+"/"+nombreBase;
            base = DriverManager.getConnection(url,usuarioBase,passwordBase);
            estadoConexion = 1;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            estadoConexion = -1;
        }        
        return estadoConexion;
    }
    
    public int getEstadoConexion(){
        return estadoConexion;
    }
    
    public int detenerConexion(){
      try {            
            base.close();
            estadoConexion = 1;
      } catch (SQLException ex) {
            estadoConexion = -1;
      }
      return estadoConexion;
    }
    
    public void queryResults(String sql){
        if(getEstadoConexion()!= -1){
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
    
    
}
