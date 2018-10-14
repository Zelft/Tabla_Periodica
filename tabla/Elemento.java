package tabla;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XPC
 */
public class Elemento{

    private String clasificacion; 
    private String simbolo;
    private String nombre;
    private float masaAtomica;
    private String densidad;
    private String puntoFusion;
    private String puntoEbulicion;
    private String electronegatividad;
    private String URL_video;
    private String URL_visualizacion;
    private String aspectoMolecular;
    private String espectro;
    private int numeroAtomico;
       
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws org.json.simple.parser.ParseException
     */
    Elemento(String pNombre, String numeroAtomico, String pClasificacion, String pSimbolo, String pMasaAtomica, String pDensidad, String pPuntoFusion, String pPuntoEbullicion, String pElectronegatividad){
        this.nombre = pNombre;
        this.simbolo = pSimbolo;
        this.clasificacion = pClasificacion;
        this.masaAtomica = calcularMasaAtomica(pMasaAtomica);
        this.densidad = pDensidad;
        this.puntoFusion = pPuntoFusion;
        this.puntoEbulicion = pPuntoEbullicion;
        this.electronegatividad = pElectronegatividad;
        this.numeroAtomico = Integer.parseInt(numeroAtomico);
        
    }
    
    /**
     * Obtiene la masa atómica desde un String
     * @param masaAtomica
     * @return Flotante
     */
    static float calcularMasaAtomica(String masaAtomica) {
      float masa = 0;
      boolean afterComma = false;
      int contComma = 0;
      for (char c : masaAtomica.toCharArray()) {
        if (c >= '0' && c <= '9') {
          if (afterComma) {
            String number = "0.";
            for (int i = 0; i < contComma; i++) {
              number += "0";
            }
            contComma++;
            masa += Float.parseFloat(number + c);
          } else {
            masa *= 10;
            masa += c - '0';
          }
        } else if (c == ',' || c == '.') afterComma = true;
        else if (c != ' ' && afterComma) break;
      }
      return masa;
    }
    
    
    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the masaAtomica
     */
    public float getMasaAtomica() {
        return masaAtomica;
    }

    /**
     * @param masaAtomica the masaAtomica to set
     */
    public void setMasaAtomica(float masaAtomica) {
        this.masaAtomica = masaAtomica;
    }

    /**
     * @return the densidad
     */
    public String getDensidad() {
        return densidad;
    }

    /**
     * @param densidad the densidad to set
     */
    public void setDensidad(String densidad) {
        this.densidad = densidad;
    }

    /**
     * @return the puntoFusion
     */
    public String getPuntoFusion() {
        return puntoFusion;
    }

    /**
     * @param puntoFusion the puntoFusion to set
     */
    public void setPuntoFusion(String puntoFusion) {
        this.puntoFusion = puntoFusion;
    }

    /**
     * @return the puntoEbulicion
     */
    public String getPuntoEbulicion() {
        return puntoEbulicion;
    }

    /**
     * @param puntoEbulicion the puntoEbulicion to set
     */
    public void setPuntoEbulicion(String puntoEbulicion) {
        this.puntoEbulicion = puntoEbulicion;
    }

    /**
     * @return the electronegatividad
     */
    public String getElectronegatividad() {
        return electronegatividad;
    }

    /**
     * @param electronegatividad the electronegatividad to set
     */
    public void setElectronegatividad(String electronegatividad) {
        this.electronegatividad = electronegatividad;
    }

    /**
     * @return the URL_video
     */
    public String getURL_video() {
        return URL_video;
    }

    /**
     * @param URL_video the URL_video to set
     */
    public void setURL_video(String URL_video) {
        this.URL_video = URL_video;
    }

    /**
     * @return the URL_visualizacion
     */
    public String getURL_visualizacion() {
        return URL_visualizacion;
    }

    /**
     * @param URL_visualizacion the URL_visualizacion to set
     */
    public void setURL_visualizacion(String URL_visualizacion) {
        this.URL_visualizacion = URL_visualizacion;
    }

    /**
     * @return the aspectoMolecular
     */
    public String getAspectoMolecular() {
        return aspectoMolecular;
    }

    /**
     * @param aspectoMolecular the aspectoMolecular to set
     */
    public void setAspectoMolecular(String aspectoMolecular) {
        this.aspectoMolecular = aspectoMolecular;
    }

    /**
     * @return the espectro
     */
    public String getEspectro() {
        return espectro;
    }

    /**
     * @param espectro the espectro to set
     */
    public void setEspectro(String espectro) {
        this.espectro = espectro;
    }

  public int getNumeroAtomico() {
    return numeroAtomico;
  }

  public void setNumeroAtomico(int numeroAtomico) {
    this.numeroAtomico = numeroAtomico;
  }
}