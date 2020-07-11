package controlador;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;

public class ControladorGeneral {
    //Elementos gráficos
    public JFXTextField fraseTF;
    public JFXTextField expresionTF;
    public TitledPane simbolosTP;
    public TitledPane opcionesTP;

    private String frase;
    private String expresion;

    public void initialize(){
        simbolosTP.getStyleClass().set(0,"titled-pane");
        simbolosTP.setExpanded(false);
        opcionesTP.getStyleClass().set(0,"titled-pane");
        opcionesTP.setExpanded(false);
    }

    @FXML
    public void ingresarFrase(KeyEvent event){
        String cRaw = event.getCharacter();
        char c = cRaw.charAt(0);
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
            fraseTF.setEditable(true);
        }else{
            fraseTF.setEditable(false);
        }
    }

    public void simbolo1(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "»");
    }

    public void simbolo2(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "«");
    }

    public void simbolo3(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "...");
    }

    public void simbolo4(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
    }

    public void simbolo5(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
    }

    public void simbolo6(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "'");
    }

    public void simbolo7(){
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "'");
    }
}
