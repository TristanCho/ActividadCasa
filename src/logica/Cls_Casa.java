
package logica;

import Conexion.Cls_Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Cls_Casa {
   
    private final String SQL_SELECT = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor  AND `nombre_sensor`<> 'Escritorio' AND `nombre_sensor`<> 'Puerta Hardware' ORDER BY `Actividad`.`hora`DESC LIMIT 50";
    private DefaultTableModel DT;
    private ResultSet RS;
    private PreparedStatement PS;
    private final Cls_Conexion CN;
    
    public Cls_Casa(){
        PS = null;
        CN = new Cls_Conexion();
    }
    
    
    
    private DefaultTableModel setTitulos(){
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Hora");
        DT.addColumn("ESP");
        DT.addColumn("Sensor");
        DT.addColumn("Estado");
       
        return DT;
    }
      
    //Método para listar los datos leyendo desde la DDBB
    public DefaultTableModel getDatos(){
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
            while (RS.next()){
                
                fila[0] = RS.getInt(1);
                fila[1] = RS.getTimestamp(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(7);
                fila[4] = RS.getInt(5);
                DT.addRow(fila);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar los datos en clase_Casa: "+ e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN.close();
        }
        return DT;
    }

       public DefaultTableModel getDato(int crt){
           String SQL;
        switch (crt) {
            case 0:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor  AND `nombre_sensor`<> 'Escritorio' AND `nombre_sensor`<> 'Puerta Hardware' ORDER BY `Actividad`.`hora`DESC LIMIT 50";
                break;
            case 1:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'Salon' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
            case 2:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'Pasillo' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
            case 3:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'Cocina' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
            case 4:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'MiddleRoom' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
            case 5:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'MainRoom' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
            case 6:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'BathRoom' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
            default:
                SQL = "SELECT *FROM `Actividad`, `Sensores` WHERE `Actividad`.`sensor` = `Sensores`.id_sensor AND `Sensores`.`nombre_sensor`= 'Puerta' ORDER BY `Actividad`.`hora` DESC LIMIT 15";
                break;
        }
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[5];
            while (RS.next()){
              
                fila[0] = RS.getInt(1);
                fila[1] = RS.getTimestamp(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(7);//Salida2;
                fila[4] = RS.getInt(5);
                
                DT.addRow(fila);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar los datos En casa: "+ e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN.close();
        }
        return DT;
    }
}
