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

  /**
   * @return the videos
   */
  public String[] getVideos() {
    return videos;
  }

  /**
   * @param videos the videos to set
   */
  public void setVideos(String[] videos) {
    this.videos = videos;
  }

    
    Elemento[] elementos;
    private String [] videos;
    
    public Tabla_Periodica(){
        
        JSONParser parser = new JSONParser();
        elementos = new Elemento[118];
        videos = new String[118];
        
        try {
        JSONArray arregloJson = (JSONArray) parser.parse(new FileReader("Tabla.json"));
        JSONArray videosJson = (JSONArray) parser.parse(new FileReader("Videos.json"));
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
            for(int i=0; i<videosJson.size();i++){
              JSONObject videoJson = (JSONObject) videosJson.get(i);
              String url = videoJson.get("URL").toString();
              videos[i]= url;
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
