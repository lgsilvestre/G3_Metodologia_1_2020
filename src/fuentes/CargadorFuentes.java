package fuentes;

import javafx.scene.text.Font;

import java.io.IOException;
import java.io.InputStream;

public class CargadorFuentes {

    public Font manuscrita;

    /**
     * metodo que escoge la fuente para formatear la frase, en caso de cambiar la fuente,
     * guardar fuente en la carpeta fuentes y reemplazar su nombre en la linea 18
     * @throws IOException
     */
    public CargadorFuentes() throws IOException {
        String currentFontFile = "Sacramento.ttf";
        InputStream fontStream = CargadorFuentes.class.getResourceAsStream(currentFontFile);
        if (fontStream != null) {
            manuscrita = Font.loadFont(fontStream, 36);
            fontStream.close();
        }
        else {
            throw new IOException("Could not create font: " + currentFontFile);
        }
    }
}