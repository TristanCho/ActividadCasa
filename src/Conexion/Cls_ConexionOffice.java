/*
Con esta clase nos conectamos a la base de datos

*/
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Cls_ConexionOffice {
    
  
    
    private static final String DRIVER3 = "com.mysql.jdbc.Driver";
    //private static final String USER = "root";
    //private static final String PASSWORD = "";
    private static final String USER = "cristhian";
    private static final String PASSWORD = "cristhian";
    private static final String IP = "89.129.146.6";
    private static final String PUERTO = "3306";
    
    private static final String DDBB3 = "Oficina";
   
    
    private static final String URL3 = "jdbc:mysql://"+IP+":"+PUERTO+"/"+DDBB3+"?autoReconnect=true&useSSL=false";
    
    private Connection CN3;
    
    public Cls_ConexionOffice() {
        
        CN3 = null;
    }
    
         
    //Este método nos retorna la conexión
    public Connection getConnection(){
        try{
            Class.forName(DRIVER3);
            CN3 = DriverManager.getConnection(URL3, USER, PASSWORD);
            
            System.out.println("Conexión establecida...");
          }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de Conectar Con la DDBB Oficina...");
            System.exit(0);
        }
        return CN3;
        
    }
      
    //Cierra conexiones abiertas a la base de datos.
    public void close(){
        try{
            System.out.println("Cerrando Conexión3");
            CN3.close();
            
            System.out.println("Conexión Cerrada3");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cerrar la conexión con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
