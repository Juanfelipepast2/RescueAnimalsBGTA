package carpetas.GUI;



import java.io.FileNotFoundException;
import java.net.URL;


import javafx.fxml.FXMLLoader;

import javafx.scene.layout.Pane;


public class CargadorFXML {
    
    Pane panel;

    public Pane getPane(String pantalla){
        
        try{
            String link = "/carpetas/view/" + pantalla + ".fxml";
            URL url = getClass().getResource(link);
            System.out.println("link");
            if(url == null){
                throw new FileNotFoundException("El archivo FXML no existe");
            } else {
            panel = FXMLLoader.load(url);
            
            }
        }catch(Exception e){
            System.out.println("La vista " + pantalla + " tiene un error o no existe");
        }
        return panel;
    }

    
}
