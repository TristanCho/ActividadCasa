
package logica;

import Conexion.Cls_Conexion2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Temperatura {
    
    private final String SQL_SELECT = "SELECT * FROM `dht11` ORDER BY `hora` DESC LIMIT 1";
    private DefaultTableModel TP;
    private ResultSet RS;
    private PreparedStatement PS;
    private final Cls_Conexion2 CN2; 
    
    
    public Cls_Temperatura(){
        PS = null;
        CN2 = new Cls_Conexion2();
    }

/*
    private DefaultTableModel setTitulosT(){
        TP = new DefaultTableModel();
        TP.addColumn("Id");
        TP.addColumn("Hora");
        TP.addColumn("Esp");
        TP.addColumn("Temperatura");
        TP.addColumn("Humedad");
       
        return TP;
    
        
    }
    /*
    public DefaultTableModel getDatosT(){
        try {
            setTitulosT();
            PS = CN2.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[5];
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getTimestamp(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getInt(5);
                
                TP.addRow(fila);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar los datos de temperatura: "+ e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN2.close();
        }
        return TP;
    }

*/
}
