package logica;

import Conexion.Cls_ConexionOffice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Cls_Oficina {
    
   
   // private final String SQL_SELECT = "SELECT * FROM `Actividad` WHERE `esp` = 'ESP_8bdf' ORDER BY `hora` DESC LIMIT 20";
    private final String SQL_SELECT = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.`id_sensor` ORDER BY `Actividad`.`hora` DESC LIMIT 5";
    //private final String SQL_SELECT = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Actividad`.`dispositivo`= 'EC:FA:BC:05:8B:DF'  \n" +
//"ORDER BY `Actividad`.`hora` DESC LIMIT 15";
    private DefaultTableModel TO;
    private ResultSet RS;
    private PreparedStatement PS;
    private final Cls_ConexionOffice CN3;
    
  
   
    public Cls_Oficina(){
        PS = null;
        CN3 = new Cls_ConexionOffice();
        
    }
    
    private DefaultTableModel setTitulosO(){
        TO = new DefaultTableModel();
        TO.addColumn("ID");
        TO.addColumn("Hora");
        TO.addColumn("ESP");
        TO.addColumn("Sensor");
        TO.addColumn("Estado");
       
        return TO;
    }
      
    //Método para listar los datos leyendo desde la DDBB
    public DefaultTableModel getDatosO(){
       
        try {
            setTitulosO();
            PS = CN3.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
                  
            while (RS.next()){
               
                fila[0] = RS.getInt(1);
                fila[1] = RS.getTimestamp(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(7);//Salida2;
                fila[4] = RS.getInt(5);
                TO.addRow(fila);                
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar los datos en Oficina: "+ e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN3.close();
        }
        return TO;
    } 

}  
    
