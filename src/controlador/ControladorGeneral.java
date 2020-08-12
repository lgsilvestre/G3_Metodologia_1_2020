package controlador;

import com.jfoenix.controls.JFXTextField;
import fuentes.CargadorFuentes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ControladorGeneral {
    //Elementos gráficos
    public JFXTextField fraseTF;
    public JFXTextField expresionTF;
    public JFXTextField RotacionTF;
    public TitledPane simbolosTP;
    public TitledPane opcionesTP;
    public AnchorPane lienzo;
    public Label fraseFormat;
    public Circle min;
    public Circle max;

    private int flag = -1;
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

    /**
     * detecta letras de alfabeto, en caso de ser cualquier  otra tecla, deshabilita la edicion del campo de texto
     * @param event
     */
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
        fraseTF.setText(texto + "\"");
        formatear();
    }

    public void simbolo4() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "\"");
        formatear();
    }

    public void simbolo5() throws IOException {
        String texto = fraseTF.getText();
        fraseTF.setText(texto + "'");
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

    /**
     * Metodo para invertir el orden de las palabras de una oración
     * @throws IOException
     */
    public void invertir() throws IOException {
        String[] texto = (fraseTF.getText()).split(" ");
        String aux = "";
        for (int i = texto.length-1; i >= 0; i--) {
            aux = aux + texto[i] + " ";
        }
        fraseTF.setText(aux);
        formatear();
    }

    /**
     * Metodo que se encarga de ir cambiando de valor el flag y así llamar a la función de puntos en función
     * de dicha flag
     * @throws IOException
     */
    public void mostrar() throws  IOException{
        flag = flag*-1;
        puntos(flag);
    }

    /**
     * Metodo que se encarga de asignarles coordenadas a los puntos de control para aparecer en el lienzo,
     * además aquí se hacen o no visibles según la flag
     * @param flag una variable para saber si ocultar o no los puntos de control
     * @throws IOException
     */
    public void puntos(int flag) throws IOException {
        double minX = fraseFormat.getBoundsInLocal().getMinX();
        double minY = fraseFormat.getBoundsInLocal().getMinY();
        double maxX = fraseFormat.getBoundsInLocal().getMaxX();
        double maxY = fraseFormat.getBoundsInLocal().getMaxY();
        min.setCenterX(minX);
        min.setCenterY(minY);
        min.setRadius(5.0f);
        max.setCenterX(maxX);
        max.setCenterY(maxY);
        max.setRadius(5.0f);
        if (flag == 1 && fraseFormat.getText().length() != 0){
            min.setVisible(true);
            max.setVisible(true);
        }else{
            min.setVisible(false);
            max.setVisible(false);
        }
    }

    /**
     * Metodo que carga la fuente descrita en fuentes/CargadorFuentes.java ,
     * donde es utilizada en una label dentro del lienzo del programa
     * @throws IOException
     */
    public void formatear() throws IOException {
        CargadorFuentes fuenteMaster= new CargadorFuentes();
        String frase= fraseTF.getText();
        fraseFormat.setFont(fuenteMaster.manuscrita);
        fraseFormat.setText(frase);
        System.out.println("done "+frase);
        System.out.println("Label X: "+fraseFormat.getLayoutX()+" Label Y: "+fraseFormat.getLayoutY());
        System.out.println("height: "+fraseFormat.getHeight()+" width: "+fraseFormat.getWidth());
        puntos(flag);
    }

    /**
     * Metodo que rota la frase formateada en base a grados en un rango de 0 - 180 grados, solo numeros enteros
     * @throws NumberFormatException
     */
    public void Rotacion(){
        try {
            System.out.println(RotacionTF.getCharacters());
            int angulo = Integer.parseInt(String.valueOf(RotacionTF.getCharacters()));
            if(angulo >= 0 && angulo <= 180){
                fraseFormat.setRotate(angulo);
                /* aca estoy probando los puntos(layout x,y) en base a los angulos para un posible acomodamiento en el caso si
                la la frase se saliese del canvas
                */
                System.out.println((fraseFormat.getLayoutX()*Math.asin(angulo)+fraseFormat.getLayoutX()*Math.acos(angulo))+","+fraseFormat.getLayoutY());
            }
        }catch (NumberFormatException y){
            System.out.println("no es valido la rotacion puesta");

        }finally{

        }
    }


}
