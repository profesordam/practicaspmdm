package fp.dam.pmdm.actividad2;

import android.app.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Actividad2Application extends Application {

    Map<String, List<Pais>> datos = new TreeMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        InputStream stream = getResources().openRawResource(R.raw.capitales);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = in.readLine()) != null) {
                String [] items = linea.split(";");
                Pais pais = new Pais(items[1], items[2], items[0]);
                List<Pais> paises = datos.get(items[0]);
                if (paises == null) {
                    paises = new ArrayList<>();
                    datos.put(items[0], paises);
                }
                paises.add(pais);
            }
        } catch (IOException e) {
            datos = null;
        }
    }


}
