package Ventanas;

import Ventanas.nueva_Tabla;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import tabla.Elemento;
import tabla.Tabla_Periodica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author XPC
 */
public class Informacion extends javax.swing.JFrame {

  JFrame anterior;
  int atomico;

  /**
   * Creates new form Informacion
   */
  public Informacion() {
    initComponents();
  }

  /**
   *
   * @param frame
   * @param elemento
   */
  public Informacion(JFrame frame, Elemento elemento, int atomico) {
    this.atomico = atomico;
    anterior = frame;
    initComponents();
    nombre.setText(elemento.getNombre());
    simboloValor.setText(elemento.getSimbolo());
    clasificacionValor.setText(elemento.getClasificacion());
    masaAtomicaValor.setText("" + elemento.getMasaAtomica());
    densidadValor.setText(elemento.getDensidad());
    ptoFusionValor.setText(elemento.getPuntoFusion());
    ptoEbullicionValor.setText(elemento.getPuntoEbulicion());
    electronegatividadValor.setText(elemento.getElectronegatividad());
    URL url;

    try {
      url = new URL("http://chemistry.bd.psu.edu/jircitano/" + elemento.getSimbolo() + ".gif");
      BufferedImage c = ImageIO.read(url);
      ImageIcon image = new ImageIcon(c);
      jLabel1.setIcon(new ImageIcon(image.getImage().getScaledInstance(290, 100, Image.SCALE_DEFAULT)));
    } catch (MalformedURLException ex) {
    } catch (IOException ex) {
    }
    ImageIcon a = new ImageIcon(elemento.getNumeroAtomico() + ".gif");
    if (a.getIconHeight() == -1) {
      a = new ImageIcon(elemento.getNumeroAtomico() + ".jpg");
    }

    if (a.getIconHeight() == -1) {
      a = new ImageIcon(elemento.getNumeroAtomico() + ".png");
    }

    int width = 400;
    int height = 276;
    gif.setIcon(new ImageIcon(a.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
  }
  
    /**
   * Abre una pagina web con un enlace dado
   * @param uri
   * @return 
   */
  public static boolean openWebpage(URI uri) {

    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}
    /**
     *  Abre una pagina web con un enlace dado
     * @param url
     * @return 
     */
    public static boolean openWebpage(URL url) {
    try {
        return openWebpage(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
    return false;
}

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    gif = new javax.swing.JLabel();
    regresar = new javax.swing.JButton();
    nombre = new javax.swing.JLabel();
    clasificacion = new javax.swing.JLabel();
    simbolo = new javax.swing.JLabel();
    masaAtomica = new javax.swing.JLabel();
    densidad = new javax.swing.JLabel();
    ptoFusion = new javax.swing.JLabel();
    ptoEbullicion = new javax.swing.JLabel();
    electronegatividad = new javax.swing.JLabel();
    video = new javax.swing.JLabel();
    espectro = new javax.swing.JLabel();
    simboloValor = new javax.swing.JLabel();
    masaAtomicaValor = new javax.swing.JLabel();
    clasificacionValor = new javax.swing.JLabel();
    densidadValor = new javax.swing.JLabel();
    ptoFusionValor = new javax.swing.JLabel();
    ptoEbullicionValor = new javax.swing.JLabel();
    electronegatividadValor = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    play = new javax.swing.JButton();
    fondo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(0, 0, 0));
    setUndecorated(true);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(gif, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 420, 230));

    regresar.setBackground(new java.awt.Color(0, 0, 153));
    regresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    regresar.setForeground(new java.awt.Color(255, 255, 255));
    regresar.setText("Regresar");
    regresar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        regresarActionPerformed(evt);
      }
    });
    getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 770, 100, 40));

    nombre.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
    nombre.setForeground(new java.awt.Color(255, 255, 255));
    getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 240, 40));

    clasificacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    clasificacion.setForeground(new java.awt.Color(240, 240, 240));
    clasificacion.setText("Clasificación: ");
    getContentPane().add(clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 130, 40));

    simbolo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    simbolo.setForeground(new java.awt.Color(240, 240, 240));
    simbolo.setText("Simbolo:");
    getContentPane().add(simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 100, 40));

    masaAtomica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    masaAtomica.setForeground(new java.awt.Color(240, 240, 240));
    masaAtomica.setText("Masa Atomica:");
    getContentPane().add(masaAtomica, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 130, 40));

    densidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    densidad.setForeground(new java.awt.Color(240, 240, 240));
    densidad.setText("Densidad: ");
    getContentPane().add(densidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, 40));

    ptoFusion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    ptoFusion.setForeground(new java.awt.Color(240, 240, 240));
    ptoFusion.setText("Punto de Fusion: ");
    getContentPane().add(ptoFusion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 150, 40));

    ptoEbullicion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    ptoEbullicion.setForeground(new java.awt.Color(240, 240, 240));
    ptoEbullicion.setText("Punto de Ebullición:");
    getContentPane().add(ptoEbullicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 170, 40));

    electronegatividad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    electronegatividad.setForeground(new java.awt.Color(240, 240, 240));
    electronegatividad.setText("Electronegatividad:");
    getContentPane().add(electronegatividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 170, 40));

    video.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    video.setForeground(new java.awt.Color(240, 240, 240));
    video.setText("Video:");
    getContentPane().add(video, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 150, 40));

    espectro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    espectro.setForeground(new java.awt.Color(240, 240, 240));
    espectro.setText("Espectro:");
    getContentPane().add(espectro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 80, 40));

    simboloValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    simboloValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(simboloValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 100, 40));

    masaAtomicaValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    masaAtomicaValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(masaAtomicaValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 130, 40));

    clasificacionValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    clasificacionValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(clasificacionValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, 40));

    densidadValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    densidadValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(densidadValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 130, 40));

    ptoFusionValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    ptoFusionValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(ptoFusionValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 150, 40));

    ptoEbullicionValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    ptoEbullicionValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(ptoEbullicionValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 170, 40));

    electronegatividadValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    electronegatividadValor.setForeground(new java.awt.Color(240, 240, 240));
    getContentPane().add(electronegatividadValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 170, 40));

    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Imagen no disponible");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 290, -1));

    play.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    play.setIcon(new javax.swing.ImageIcon("C:\\Users\\XPC\\Desktop\\Nueva Tabla\\play.jpg")); // NOI18N
    play.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        playActionPerformed(evt);
      }
    });
    getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 50));

    fondo.setIcon(new javax.swing.ImageIcon("D:\\TEC\\Ingenieria en Computacion\\2018\\Semestre II 2018\\POO\\Tabla Periodica\\Tabla\\black.jpg")); // NOI18N
    fondo.setText("Simbolo");
    getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 618, 833));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed

      anterior.setVisible(true);
      this.setVisible(false);


    }//GEN-LAST:event_regresarActionPerformed

  private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
    try {
      // TODO add your handling code here:
      int index = this.atomico -1;
      Tabla_Periodica videos = new Tabla_Periodica();
      System.out.println(index);
      URL url = new URL(videos.getVideos()[index]);
      openWebpage(url);

    } catch (MalformedURLException ex) {
      Logger.getLogger(Informacion.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }//GEN-LAST:event_playActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Informacion().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel clasificacion;
  private javax.swing.JLabel clasificacionValor;
  private javax.swing.JLabel densidad;
  private javax.swing.JLabel densidadValor;
  private javax.swing.JLabel electronegatividad;
  private javax.swing.JLabel electronegatividadValor;
  private javax.swing.JLabel espectro;
  private javax.swing.JLabel fondo;
  private javax.swing.JLabel gif;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel masaAtomica;
  private javax.swing.JLabel masaAtomicaValor;
  private javax.swing.JLabel nombre;
  private javax.swing.JButton play;
  private javax.swing.JLabel ptoEbullicion;
  private javax.swing.JLabel ptoEbullicionValor;
  private javax.swing.JLabel ptoFusion;
  private javax.swing.JLabel ptoFusionValor;
  private javax.swing.JButton regresar;
  private javax.swing.JLabel simbolo;
  private javax.swing.JLabel simboloValor;
  private javax.swing.JLabel video;
  // End of variables declaration//GEN-END:variables
}
