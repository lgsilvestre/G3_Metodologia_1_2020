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

    private String frase="";
    private String expresion;

    public void initialize(){
        fraseFormat.setWrapText(true);
        simbolosTP.getStyleClass().set(0,"titled-pane");
        simbolosTP.setExpanded(false);
        opcionesTP.getStyleClass().set(0,"titled-pane");
        opcionesTP.setExpanded(false);
        lienzo= new AnchorPane();
        Label fraseFormat= new Label();

    }

    /**
     * detecta letras de alfabeto, en caso de ser cualquier  otra tecla, deshabilita la edicion del campo de texto
     * @param event
     */
    @FXML
    public void ingresarFrase(KeyEvent event){
        String cRaw = event.getCharacter();
        char c = cRaw.charAt(0);
        if(Character.isLetter(c) || Character.isWhitespace(c)){
            fraseTF.setEditable(true);
            frase=frase+c;
            System.out.println("frase: "+frase);
        }else if(Character.isISOControl(c)){
            fraseTF.setEditable(true);
            String[] fraseSplit = frase.split("");
            int i=0;
            frase="";
            while(i<fraseSplit.length-1){
                frase=frase+fraseSplit[i];
                i++;
            }
        }else{
            fraseTF.setEditable(false);
        }
    }

    public void simbolo1() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "»");
        frase=frase+ "»";
        formatear();
    }
    public void simbolo2() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "«");
        frase=frase+"«";
        formatear();
    }
    public void simbolo3() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
        frase=frase+"\"";
        formatear();
    }
    public void simbolo4() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
        frase=frase+"\"";
        formatear();
    }
    public void simbolo5() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "'");
        frase=frase+"'";
        formatear();
    }
    public void simbolo6() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "'");
        frase=frase+"'";
        formatear();
    }
    public void simbolo7() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "...");
        frase=frase+"...";
        formatear();
    }

    /**
     * Metodo que carga la fuente descrita en fuentes/CargadorFuentes.java ,
     * donde es utilizada en una label dentro del lienzo del programa
     * @throws IOException
     */
    public void formatear() throws IOException {
        double posX,ancho;
        posX=fraseFormat.getLayoutX();
        ancho=fraseFormat.getWidth();
        double limite = 547.0-posX-20.0;
        CargadorFuentes fuenteMaster= new CargadorFuentes();
        fraseFormat.setFont(fuenteMaster.manuscrita);
        System.out.println("Label X: "+fraseFormat.getLayoutX()+" Label Y: "+fraseFormat.getLayoutY());
        System.out.println("width: "+fraseFormat.getWidth()+"  height: "+fraseFormat.getHeight());
        System.out.println("limite: "+limite);
        if (ancho >=limite){
            System.out.println("mucho ancho");
            String[] fraseSplit=frase.split("");
            frase="";
            int i=0;
            while(i<fraseSplit.length-2){
                frase=frase+fraseSplit[i];
                i++;
            }
            frase=frase+"\n"+fraseSplit[i]+fraseSplit[i+1];
            fraseFormat.setText(frase);
            System.out.println("done "+frase);

        }else{
            fraseFormat.setText(frase);
            System.out.println("done "+frase);
        }



    }
}
