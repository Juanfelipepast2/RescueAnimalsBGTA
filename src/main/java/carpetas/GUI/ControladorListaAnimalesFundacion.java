package carpetas.GUI;


import java.util.ArrayList;
import java.util.List;


import carpetas.clases.Animal;
import carpetas.clases.Fundacion;
import carpetas.sql_clases.CRUD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ControladorListaAnimalesFundacion{

    private Fundacion fund;

    private List<Animal> listaAnimales = new ArrayList<>();

    @FXML
    private GridPane gridAnimalesFundacion;


    


    void setFund(Fundacion fund){
        this.fund = fund;        
        getData();

        int columna = 0;
        int fila = 0;

        try{

            for (int i = 0; i<listaAnimales.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/carpetas/view/ItemAnimalFundacion.fxml"));;
                VBox vbox = fxmlLoader.load();

                ControladorItemAnimalFundacion item = fxmlLoader.getController();
                item.initAnimal(listaAnimales.get(i));

                gridAnimalesFundacion.add(vbox, columna, fila++);

                GridPane.setMargin(vbox, new Insets(20));
            }

        }catch(Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

        
    }

    void getData(){
        
        listaAnimales = CRUD.LeerAnimalesIDFundacion(fund.getID());
    }
}
