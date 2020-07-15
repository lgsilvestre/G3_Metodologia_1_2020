package controlador;

import com.jfoenix.controls.JFXTextField;
import fuentes.CargadorFuentes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControladorGeneral {
    //Elementos gráficos
    public JFXTextField fraseTF;
    public JFXTextField expresionTF;
    public TitledPane simbolosTP;
    public TitledPane opcionesTP;
    public AnchorPane lienzo;
    public Label fraseFormat;

    private String frase;
    private String expresion;

    public void initialize(){
        simbolosTP.getStyleClass().set(0,"titled-pane");
        simbolosTP.setExpanded(false);
        opcionesTP.getStyleClass().set(0,"titled-pane");
        opcionesTP.setExpanded(false);
        lienzo= new AnchorPane();
        Label fraseFormat= new Label();

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

    public void simbolo1() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "»");
        formatear();
    }

    public void simbolo2() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "«");
        formatear();
    }

    public void simbolo3() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "...");
        formatear();
    }

    public void simbolo4() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
        formatear();
    }

    public void simbolo5() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
        formatear();
    }

    public void simbolo6() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "'");
        formatear();
    }

    public void simbolo7() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "...");
        formatear();
    }

    public void formatear() throws IOException {
        CargadorFuentes fuenteMaster= new CargadorFuentes();
        String frase= fraseTF.getText();
        fraseFormat.setFont(fuenteMaster.manuscrita);
        fraseFormat.setText(frase);
        System.out.println("done "+frase);
    }

    public void formatearLetra(KeyEvent event) throws IOException {
        formatear();
    }
}
