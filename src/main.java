import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class main extends Application {
    
	@Override
    public void init() {
    }
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		
		manejoDatos example = new manejoDatos();
		
		Pane root = new Pane();
		primaryStage.setTitle("AdivinApp");
  

        TextField introducirNumero = new TextField();
        introducirNumero.setLayoutX(80);
        introducirNumero.setLayoutY(120);
        
        Label label = new Label("Introduce un número al azar entre 1 y 100");
        label.setLayoutX(80);
        label.setLayoutY(100);
        
        Button button = new Button("Continuar");
        button.setLayoutX(230);
        button.setLayoutY(120);
        
        button.setOnAction((event) -> {
        	
        	String numeroIntroducido = introducirNumero.getText();
        	int numero;
        	try {
        		numero = Integer.parseInt(numeroIntroducido);
        		
        		if((numero > 0) && (numero <= 100)) {
        			example.comprobarNumero(numero);
        		}else {
        			example.alertaError("Numero fuera del rango entre 1 y 100.");
        		}
        	} catch (NumberFormatException nfe){
        		example.alertaError("El valor introducido no es un numero.");
        	}     
        	
        });
        
        root.getChildren().addAll(label, introducirNumero, button);        
    	Scene scene = new Scene(root, 400, 300);

    	primaryStage.setScene(scene);
    	primaryStage.setTitle("AdivinApp");
    	primaryStage.show();        
    }

	@Override
	public void stop() {
	}
    public static void main(String[] args) {
        launch(args);
    }
}