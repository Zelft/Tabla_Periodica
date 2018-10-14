package tabla;
import tabla.Elemento;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Tabla_Periodica {

    
    Elemento[] elementos;
    
    public Tabla_Periodica(){
        
        JSONParser parser = new JSONParser();
        elementos = new Elemento[118];
        
        try {
        JSONArray arregloJson = (JSONArray) parser.parse(new FileReader("Tabla.json"));
            for(int i=0; i<arregloJson.size();i++){
                JSONObject elementoJson = (JSONObject) arregloJson.get(i);
                String nombre = elementoJson.get("name").toString();
                String clasificacion = elementoJson.get("groupBlock").toString();
                String simbolo = elementoJson.get("symbol").toString();
                String masaAtomica = elementoJson.get("atomicMass").toString();
                String densidad = elementoJson.get("density").toString();
                String puntoFusion = elementoJson.get("meltingPoint").toString();
                String puntoEbullicion = elementoJson.get("boilingPoint").toString();
                String electronegatividad = elementoJson.get("electronegativity").toString();
                String numeroAtomico = elementoJson.get("atomicNumber").toString();
                elementos[i] = new Elemento(nombre, numeroAtomico, clasificacion, simbolo, masaAtomica, densidad, puntoFusion, puntoEbullicion, electronegatividad);
            }
    
        } catch (FileNotFoundException ex) {   
            //Logger.getLogger(Tabla_Periodica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Tabla_Periodica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.json.simple.parser.ParseException ex) {
            //Logger.getLogger(Tabla_Periodica.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public Elemento[] getElementos(){
        return elementos;
    }
}
