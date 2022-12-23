package fp.dam.pmdm.actividad2;

import android.app.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;

public class Actividad2Application extends Application {

    Map<String, List<Pais>> datos = new TreeMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        InputStream stream = getResources().openRawResource(R.raw.capitales);
        try (Scanner in = new Scanner(stream)) {
            in.useDelimiter(";");
            while (in.hasNext()) {
                Pais pais = new Pais(in.next(), in.next(), in.next());
                List<Pais> paises = datos.get(pais.nombre);
//                datos.computeIfAbsent(pais.continente, k -> new ArrayList<Pais>()).add(pais);

                datos.computeIfAbsent(pais.continente, new Function<String, List<Pais>>() {
                    @Override
                    public List<Pais> apply(String s) {
                        return new ArrayList<>();
                    }
                }).add(pais);

//                if (paises == null) {
//                    paises = new ArrayList<>();
//                    datos.put(pais.continente, paises);
//                }
//                paises.add(pais);
            }
        }
    }

    public List<Pais> getPaises(String continente) {
        return Collections.unmodifiableList(datos.get(continente));
    }

}
