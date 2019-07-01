package logica;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            int tic = 0;
            int toc = 1;
            @Override
            public void run(){
                if(tic%2==0){
                    System.out.println("Tic");
                    System.out.println("el valor de tic es: "+ tic);
                    
                }
                else if(tic > 30){
                    tic = 0;
                    System.out.println("El tic ha sido reteado");}
                else if(toc%2==1){
                    
                    System.out.println("holaaaa");
                }
                    
                else{
                    System.out.println("Hay unn error");
                }
                tic++;
                
                
                }
            
            
        };
       timer.schedule(task,10,1000);
         
    }
}
    


