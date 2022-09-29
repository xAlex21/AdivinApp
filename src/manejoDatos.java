import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class manejoDatos
    {
        private int intentos = 0;
        private int numeroADescubrir = (int)(Math.random()*100+1);

        public void reseteo(){
        	intentos = 0;
        	numeroADescubrir = (int)(Math.random()*100+1);
        }
        
        public void aumentarIntento() {
        	intentos++;
        }
       
        public void alertaError(String mensaje) {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("AdivinApp");
        	alert.setHeaderText("Error");
        	alert.setContentText(mensaje);
        	alert.showAndWait();
        }
        
        public void comprobarNumero(int numero) {
        	if(numero == numeroADescubrir) {
        		aumentarIntento();
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("AdivinApp");
        		alert.setHeaderText("¡Has Ganado!");
        		alert.setContentText("Solo has necesitado " + intentos + " intentos.");
        		reseteo();
        		alert.showAndWait();
        	}else {
        		aumentarIntento();
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("AdivinApp");
        		alert.setHeaderText("Has Fallado.");
        		alert.setContentText("El numero a adivinar " + ((numero < numeroADescubrir) ? " es mayor que " + numero : "es menor que " + numero));
        		alert.showAndWait();
        	}
        }
        



    }