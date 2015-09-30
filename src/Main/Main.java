package Main;

import ConexionPSQL.Conexion;
import Interface.Busqueda;
import Interface.Login;
import Interface.Principal;

public class Main {

    public static void main(String[] args) {
        
        //new Login().setVisible(true);    
        new Principal().setVisible(true); 
        /*
        String hostBase = "localhost";
        String nombreBase = "DamazoP1";
        String puertoBase = "5432";
        String usuarioBase = "postgres";
        String passwordBase = "admin";
        
        //Declaramos y creamos la conexion con los datos especificos
        Conexion conexion;
        conexion = new Conexion(hostBase,nombreBase,puertoBase,usuarioBase,passwordBase);
        
        //Iniciamos la conexion, este se creo para poder iniciar y detener la conexion
        conexion.iniciarConexion();

        //Si la tabla existe, vamos a elimiarla, para test
        String sql = "drop table if exists test;";

        //Este metodo usa un updateQuery, que no espera resultados, solo el estado de la ejecucion
        conexion.queryNoResults(sql);
        
        //Si la tabla no existe, la creamos, con 3 atributos, numero, texto y fecha
        sql = "create table if not exists test (id int, nombre varchar(45), nacimiento timestamp);";
        conexion.queryNoResults(sql);
        
        //Insertamos en la base de datos
        sql = "insert into test values ( 114040427, 'Damazo', '1989-09-15 04:10:00');";
        conexion.queryNoResults(sql);

        //Insertamos en la base de datos
        sql = "insert into test values ( 114040428, 'Daniel', '1989-09-15 04:10:00');";
        conexion.queryNoResults(sql);
        
        //Obtener los datos, esta vez usamos queryResults que usa un executeQuery
        //Este si espera un resultado y da error si no devuelve nada
        sql = "select * from test;";
        conexion.queryResults(sql);
        
        //Detenemos la conexion, puede ser iniciada de nuevo con iniciarConexion
        conexion.detenerConexion(); */
            
    }
}
