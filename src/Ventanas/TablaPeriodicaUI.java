/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Desktop; 
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import tabla.*;

/**
 *
 * @author kendall-mac
 */
public class TablaPeriodicaUI extends javax.swing.JFrame {

  /**
   * Creates new form TablaPeriodicaUI
   */
  public JButton[] buttons;
  public Tabla_Periodica tp;
  private Elemento[] elementos;

  public TablaPeriodicaUI() {
    initComponents();
    tp = new Tabla_Periodica();
    buttons = new JButton[]{
      jButton0, jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9,
      jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, jButton17, jButton18, jButton19,
      jButton20, jButton21, jButton22, jButton23, jButton24, jButton25, jButton26, jButton27, jButton28, jButton29,
      jButton30, jButton31, jButton32, jButton33, jButton34, jButton35, jButton36, jButton37, jButton38, jButton39,
      jButton40, jButton41, jButton42, jButton43, jButton44, jButton45, jButton46, jButton47, jButton48, jButton49,
      jButton50, jButton51, jButton52, jButton53, jButton54, jButton55, jButton56, jButton57, jButton58, jButton59,
      jButton60, jButton61, jButton62, jButton63, jButton64, jButton65, jButton66, jButton67, jButton68, jButton69,
      jButton70, jButton71, jButton72, jButton73, jButton74, jButton75, jButton76, jButton77, jButton78, jButton79,
      jButton80, jButton81, jButton82, jButton83, jButton84, jButton85, jButton86, jButton87, jButton88, jButton89,
      jButton90, jButton91, jButton92, jButton93, jButton94, jButton95, jButton96, jButton97, jButton98, jButton99,
      jButton100, jButton101, jButton102, jButton103, jButton104, jButton105, jButton106, jButton107, jButton108, jButton109,
      jButton110, jButton111, jButton112, jButton113, jButton114, jButton115, jButton116, jButton117
    };
    
    int indice = 0;
    
    for (JButton btn : ordenarBotones(buttons)) {
      final int c = indice;
      btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          showInfo(c);
        }
      });
      indice++;
    }

    cargarBotones(tp.getElementos());

  }

  /**
   * Asigna un elemento a cada botón en orden
   *
   * @param elems
   */
  private void cargarBotones(Elemento[] elems) {
    elementos = elems;
    Dimension d = new Dimension(100, 100);
    int contador = 0;
    for (JButton btn : ordenarBotones(buttons)) {
      int cantEspacios = 6;
      cantEspacios -= elems[contador].getSimbolo().length();
      cantEspacios -= contador < 10 ? 1 : (contador < 100 ? 2 : 3);
      String espacios = "";
      for (; cantEspacios > 0; cantEspacios--) {
        espacios += "&nbsp;";
      }
      String text = "<html><body style='color: white; font-weight: 900'><left><p>" + elems[contador].getSimbolo() + espacios + elems[contador].getNumeroAtomico() + "</p><br><left><p>" + elems[contador].getMasaAtomica() + "</p></body></html>";

      btn.setText(text);
      ImageIcon a = new ImageIcon(elems[contador].getNumeroAtomico() + ".gif");
      if (a.getIconHeight() == -1) {
        a = new ImageIcon(elems[contador].getNumeroAtomico() + ".jpg");
      }

      if (a.getIconHeight() == -1) {
        a = new ImageIcon(elems[contador].getNumeroAtomico() + ".png");
      }

      btn.setIcon(a);

      btn.setHorizontalTextPosition(JButton.CENTER);
      btn.setVerticalTextPosition(JButton.CENTER);
      final JFrame frame = this;

      contador++;

    }
  }
  /**
   * Muestra la ventana de informacion
   * @param index 
   */
  private void showInfo(int index) {
    int atomico = elementos[index].getNumeroAtomico();
    Informacion i;
    i = new Informacion(this, elementos[index], atomico);
    i.setVisible(true);
    this.setVisible(false);
  }

  /**
   * Obtiene el orden de un botón que se carga en forma vertical como si se
   * cargara en forma horizontal.
   *
   * @return int[] orden
   */
  private int[] getOrdenBotones() {
    int cantElementos = 118;
    int[] orden = new int[cantElementos];

    orden[0] = 0;
    orden[81] = 1;

    int indice = 1;
    int contador = 2;

    for (int i = 0; i < 2; i++) {
      orden[indice] = contador;
      indice += 6;
      contador++;
      orden[indice] = contador;
      indice += 44;
      contador++;
      for (int j = 0; j < 5; j++) {
        orden[indice] = contador;
        indice += 6;
        contador++;
      }
      indice += 1;
      orden[indice] = contador;
      contador++;
      indice -= 80;
    }

    for (int i = 0; i < 2; i++) {
      orden[indice] = contador;
      contador++;
      indice += 6;
      orden[indice] = contador;
      contador++;
      indice += 4;
      orden[indice] = contador;
      contador++;
      indice += 2;
      orden[indice] = contador;

      for (int j = 0; j < 8; j++) {
        indice += 4;
        contador++;
        orden[indice] = contador;
      }

      for (int j = 0; j < 5; j++) {
        indice += 6;
        contador++;
        orden[indice] = contador;
      }

      indice += 7;
      contador++;
      orden[indice] = contador;
      contador++;
      indice -= 80;
    }

    for (int i = 0; i < 2; i++) {
      orden[indice] = contador++;
      indice += 6;
      orden[indice] = contador++;
      indice += i == 0 ? 77 : 91;
      for (int j = 0; j < 15; j++) {
        orden[indice++] = contador++;
      }
      indice -= i == 0 ? 86 : 100;
      for (int j = 0; j < 9; j++) {
        orden[indice] = contador++;
        indice += 4;
      }
      indice += 2;
      for (int j = 0; j < 5; j++) {
        orden[indice] = contador++;
        indice += 6;
      }
      orden[++indice] = contador++;
      indice -= 80;
    }

    return orden;
  }

  /**
   * Ordena los JButtons que se cargan en forma vertical en un array como si se
   * cargaran en forma horizontal.
   *
   * @return Lista de JButtons
   */
  private JButton[] ordenarBotones(JButton[] componentes) {
    JButton[] botones = new JButton[118];
    int indice = 0;
    int[] orden = getOrdenBotones();
    for (JButton btn : componentes) {
      if (!(orden[indice] == 0 && indice != 0)) {
        botones[orden[indice]] = btn;
      }
      indice++;
    }
    return botones;
  }

  /**
   * This method is called fzom within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  //@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jButton0 = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jButton9 = new javax.swing.JButton();
    jButton10 = new javax.swing.JButton();
    jButton11 = new javax.swing.JButton();
    jButton12 = new javax.swing.JButton();
    jButton13 = new javax.swing.JButton();
    jButton14 = new javax.swing.JButton();
    jButton15 = new javax.swing.JButton();
    jButton16 = new javax.swing.JButton();
    jButton17 = new javax.swing.JButton();
    jButton18 = new javax.swing.JButton();
    jButton19 = new javax.swing.JButton();
    jButton20 = new javax.swing.JButton();
    jButton21 = new javax.swing.JButton();
    jButton22 = new javax.swing.JButton();
    jButton23 = new javax.swing.JButton();
    jButton24 = new javax.swing.JButton();
    jButton25 = new javax.swing.JButton();
    jButton26 = new javax.swing.JButton();
    jButton27 = new javax.swing.JButton();
    jButton28 = new javax.swing.JButton();
    jButton29 = new javax.swing.JButton();
    jButton30 = new javax.swing.JButton();
    jButton31 = new javax.swing.JButton();
    jButton32 = new javax.swing.JButton();
    jButton33 = new javax.swing.JButton();
    jButton34 = new javax.swing.JButton();
    jButton35 = new javax.swing.JButton();
    jButton36 = new javax.swing.JButton();
    jButton37 = new javax.swing.JButton();
    jButton38 = new javax.swing.JButton();
    jButton39 = new javax.swing.JButton();
    jButton40 = new javax.swing.JButton();
    jButton41 = new javax.swing.JButton();
    jButton42 = new javax.swing.JButton();
    jButton43 = new javax.swing.JButton();
    jButton44 = new javax.swing.JButton();
    jButton45 = new javax.swing.JButton();
    jButton46 = new javax.swing.JButton();
    jButton47 = new javax.swing.JButton();
    jButton48 = new javax.swing.JButton();
    jButton49 = new javax.swing.JButton();
    jButton50 = new javax.swing.JButton();
    jButton51 = new javax.swing.JButton();
    jButton52 = new javax.swing.JButton();
    jButton53 = new javax.swing.JButton();
    jButton54 = new javax.swing.JButton();
    jButton55 = new javax.swing.JButton();
    jButton56 = new javax.swing.JButton();
    jButton57 = new javax.swing.JButton();
    jButton58 = new javax.swing.JButton();
    jButton59 = new javax.swing.JButton();
    jButton60 = new javax.swing.JButton();
    jButton61 = new javax.swing.JButton();
    jButton62 = new javax.swing.JButton();
    jButton63 = new javax.swing.JButton();
    jButton64 = new javax.swing.JButton();
    jButton65 = new javax.swing.JButton();
    jButton66 = new javax.swing.JButton();
    jButton67 = new javax.swing.JButton();
    jButton68 = new javax.swing.JButton();
    jButton69 = new javax.swing.JButton();
    jButton70 = new javax.swing.JButton();
    jButton71 = new javax.swing.JButton();
    jButton72 = new javax.swing.JButton();
    jButton73 = new javax.swing.JButton();
    jButton74 = new javax.swing.JButton();
    jButton75 = new javax.swing.JButton();
    jButton76 = new javax.swing.JButton();
    jButton77 = new javax.swing.JButton();
    jButton78 = new javax.swing.JButton();
    jButton79 = new javax.swing.JButton();
    jButton80 = new javax.swing.JButton();
    jButton81 = new javax.swing.JButton();
    jButton82 = new javax.swing.JButton();
    jButton83 = new javax.swing.JButton();
    jButton84 = new javax.swing.JButton();
    jButton85 = new javax.swing.JButton();
    jButton86 = new javax.swing.JButton();
    jButton87 = new javax.swing.JButton();
    jButton88 = new javax.swing.JButton();
    jButton89 = new javax.swing.JButton();
    jButton90 = new javax.swing.JButton();
    jButton91 = new javax.swing.JButton();
    jButton92 = new javax.swing.JButton();
    jButton93 = new javax.swing.JButton();
    jButton94 = new javax.swing.JButton();
    jButton95 = new javax.swing.JButton();
    jButton96 = new javax.swing.JButton();
    jButton97 = new javax.swing.JButton();
    jButton98 = new javax.swing.JButton();
    jButton99 = new javax.swing.JButton();
    jButton100 = new javax.swing.JButton();
    jButton101 = new javax.swing.JButton();
    jButton102 = new javax.swing.JButton();
    jButton103 = new javax.swing.JButton();
    jButton104 = new javax.swing.JButton();
    jButton105 = new javax.swing.JButton();
    jButton106 = new javax.swing.JButton();
    jButton107 = new javax.swing.JButton();
    jButton108 = new javax.swing.JButton();
    jButton109 = new javax.swing.JButton();
    jButton110 = new javax.swing.JButton();
    jButton111 = new javax.swing.JButton();
    jButton112 = new javax.swing.JButton();
    jButton113 = new javax.swing.JButton();
    jButton114 = new javax.swing.JButton();
    jButton115 = new javax.swing.JButton();
    jButton116 = new javax.swing.JButton();
    jButton117 = new javax.swing.JButton();
    titulo = new javax.swing.JLabel();
    jButton118 = new javax.swing.JButton();
    ordenarNumero = new javax.swing.JButton();
    ordenarSimbolo = new javax.swing.JButton();
    ordenarMasa = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    fondo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setIconImage(new ImageIcon("play.jpg").getImage());
    setUndecorated(true);
    setPreferredSize(new java.awt.Dimension(1344, 900));

    jButton0.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton0.setMaximumSize(null);
    jButton0.setMinimumSize(null);
    jButton0.setPreferredSize(null);

    jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton1.setMaximumSize(null);
    jButton1.setMinimumSize(null);
    jButton1.setPreferredSize(null);

    jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton2.setMaximumSize(null);
    jButton2.setMinimumSize(null);
    jButton2.setPreferredSize(null);

    jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton3.setMaximumSize(null);
    jButton3.setMinimumSize(null);
    jButton3.setPreferredSize(null);

    jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton4.setMaximumSize(null);
    jButton4.setMinimumSize(null);
    jButton4.setPreferredSize(null);

    jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton5.setMaximumSize(null);
    jButton5.setMinimumSize(null);
    jButton5.setPreferredSize(null);

    jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton6.setMaximumSize(null);
    jButton6.setMinimumSize(null);
    jButton6.setPreferredSize(null);

    jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton7.setMaximumSize(null);
    jButton7.setMinimumSize(null);
    jButton7.setPreferredSize(null);

    jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton8.setMaximumSize(null);
    jButton8.setMinimumSize(null);
    jButton8.setPreferredSize(null);

    jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton9.setMaximumSize(null);
    jButton9.setMinimumSize(null);
    jButton9.setPreferredSize(null);

    jButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton10.setMaximumSize(null);
    jButton10.setMinimumSize(null);
    jButton10.setPreferredSize(null);

    jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton11.setMaximumSize(null);
    jButton11.setMinimumSize(null);
    jButton11.setPreferredSize(null);

    jButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton12.setMaximumSize(null);
    jButton12.setMinimumSize(null);
    jButton12.setPreferredSize(null);

    jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton13.setMaximumSize(null);
    jButton13.setMinimumSize(null);
    jButton13.setPreferredSize(null);

    jButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton14.setMaximumSize(null);
    jButton14.setMinimumSize(null);
    jButton14.setPreferredSize(null);

    jButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton15.setMaximumSize(null);
    jButton15.setMinimumSize(null);
    jButton15.setPreferredSize(null);

    jButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton16.setMaximumSize(null);
    jButton16.setMinimumSize(null);
    jButton16.setPreferredSize(null);

    jButton17.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton17.setMaximumSize(null);
    jButton17.setMinimumSize(null);
    jButton17.setPreferredSize(null);

    jButton18.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton18.setMaximumSize(null);
    jButton18.setMinimumSize(null);
    jButton18.setPreferredSize(null);

    jButton19.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton19.setMaximumSize(null);
    jButton19.setMinimumSize(null);
    jButton19.setPreferredSize(null);

    jButton20.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton20.setMaximumSize(null);
    jButton20.setMinimumSize(null);
    jButton20.setPreferredSize(null);

    jButton21.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton21.setMaximumSize(null);
    jButton21.setMinimumSize(null);
    jButton21.setPreferredSize(null);

    jButton22.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton22.setMaximumSize(null);
    jButton22.setMinimumSize(null);
    jButton22.setPreferredSize(null);

    jButton23.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton23.setMaximumSize(null);
    jButton23.setMinimumSize(null);
    jButton23.setPreferredSize(null);

    jButton24.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton24.setMaximumSize(null);
    jButton24.setMinimumSize(null);
    jButton24.setPreferredSize(null);

    jButton25.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton25.setMaximumSize(null);
    jButton25.setMinimumSize(null);
    jButton25.setPreferredSize(null);

    jButton26.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton26.setMaximumSize(null);
    jButton26.setMinimumSize(null);
    jButton26.setPreferredSize(null);

    jButton27.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton27.setMaximumSize(null);
    jButton27.setMinimumSize(null);
    jButton27.setPreferredSize(null);

    jButton28.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton28.setMaximumSize(null);
    jButton28.setMinimumSize(null);
    jButton28.setPreferredSize(null);

    jButton29.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton29.setMaximumSize(null);
    jButton29.setMinimumSize(null);
    jButton29.setPreferredSize(null);

    jButton30.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton30.setMaximumSize(null);
    jButton30.setMinimumSize(null);
    jButton30.setPreferredSize(null);

    jButton31.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton31.setMaximumSize(null);
    jButton31.setMinimumSize(null);
    jButton31.setPreferredSize(null);

    jButton32.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton32.setMaximumSize(null);
    jButton32.setMinimumSize(null);
    jButton32.setPreferredSize(null);

    jButton33.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton33.setMaximumSize(null);
    jButton33.setMinimumSize(null);
    jButton33.setPreferredSize(null);

    jButton34.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton34.setMaximumSize(null);
    jButton34.setMinimumSize(null);
    jButton34.setPreferredSize(null);

    jButton35.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton35.setMaximumSize(null);
    jButton35.setMinimumSize(null);
    jButton35.setPreferredSize(null);

    jButton36.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton36.setMaximumSize(null);
    jButton36.setMinimumSize(null);
    jButton36.setPreferredSize(null);

    jButton37.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton37.setMaximumSize(null);
    jButton37.setMinimumSize(null);
    jButton37.setPreferredSize(null);

    jButton38.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton38.setMaximumSize(null);
    jButton38.setMinimumSize(null);
    jButton38.setPreferredSize(null);

    jButton39.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton39.setMaximumSize(null);
    jButton39.setMinimumSize(null);
    jButton39.setPreferredSize(null);

    jButton40.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton40.setMaximumSize(null);
    jButton40.setMinimumSize(null);
    jButton40.setPreferredSize(null);

    jButton41.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton41.setMaximumSize(null);
    jButton41.setMinimumSize(null);
    jButton41.setPreferredSize(null);

    jButton42.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton42.setMaximumSize(null);
    jButton42.setMinimumSize(null);
    jButton42.setPreferredSize(null);

    jButton43.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton43.setMaximumSize(null);
    jButton43.setMinimumSize(null);
    jButton43.setPreferredSize(null);

    jButton44.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton44.setMaximumSize(null);
    jButton44.setMinimumSize(null);
    jButton44.setPreferredSize(null);

    jButton45.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton45.setMaximumSize(null);
    jButton45.setMinimumSize(null);
    jButton45.setPreferredSize(null);

    jButton46.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton46.setMaximumSize(null);
    jButton46.setMinimumSize(null);
    jButton46.setPreferredSize(null);

    jButton47.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton47.setMaximumSize(null);
    jButton47.setMinimumSize(null);
    jButton47.setPreferredSize(null);

    jButton48.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton48.setMaximumSize(null);
    jButton48.setMinimumSize(null);
    jButton48.setPreferredSize(null);

    jButton49.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton49.setMaximumSize(null);
    jButton49.setMinimumSize(null);
    jButton49.setPreferredSize(null);

    jButton50.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton50.setMaximumSize(null);
    jButton50.setMinimumSize(null);
    jButton50.setPreferredSize(null);

    jButton51.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton51.setMaximumSize(null);
    jButton51.setMinimumSize(null);
    jButton51.setPreferredSize(null);

    jButton52.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton52.setMaximumSize(null);
    jButton52.setMinimumSize(null);
    jButton52.setPreferredSize(null);

    jButton53.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton53.setMaximumSize(null);
    jButton53.setMinimumSize(null);
    jButton53.setPreferredSize(null);

    jButton54.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton54.setMaximumSize(null);
    jButton54.setMinimumSize(null);
    jButton54.setPreferredSize(null);

    jButton55.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton55.setMaximumSize(null);
    jButton55.setMinimumSize(null);
    jButton55.setPreferredSize(null);

    jButton56.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton56.setMaximumSize(null);
    jButton56.setMinimumSize(null);
    jButton56.setPreferredSize(null);

    jButton57.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton57.setMaximumSize(null);
    jButton57.setMinimumSize(null);
    jButton57.setPreferredSize(null);

    jButton58.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton58.setMaximumSize(null);
    jButton58.setMinimumSize(null);
    jButton58.setPreferredSize(null);

    jButton59.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton59.setMaximumSize(null);
    jButton59.setMinimumSize(null);
    jButton59.setPreferredSize(null);

    jButton60.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton60.setMaximumSize(null);
    jButton60.setMinimumSize(null);
    jButton60.setPreferredSize(null);

    jButton61.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton61.setMaximumSize(null);
    jButton61.setMinimumSize(null);
    jButton61.setPreferredSize(null);

    jButton62.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton62.setMaximumSize(null);
    jButton62.setMinimumSize(null);
    jButton62.setPreferredSize(null);

    jButton63.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton63.setMaximumSize(null);
    jButton63.setMinimumSize(null);
    jButton63.setPreferredSize(null);

    jButton64.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton64.setMaximumSize(null);
    jButton64.setMinimumSize(null);
    jButton64.setPreferredSize(null);

    jButton65.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton65.setMaximumSize(null);
    jButton65.setMinimumSize(null);
    jButton65.setPreferredSize(null);

    jButton66.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton66.setMaximumSize(null);
    jButton66.setMinimumSize(null);
    jButton66.setPreferredSize(null);

    jButton67.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton67.setMaximumSize(null);
    jButton67.setMinimumSize(null);
    jButton67.setPreferredSize(null);

    jButton68.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton68.setMaximumSize(null);
    jButton68.setMinimumSize(null);
    jButton68.setPreferredSize(null);

    jButton69.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton69.setMaximumSize(null);
    jButton69.setMinimumSize(null);
    jButton69.setPreferredSize(null);

    jButton70.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton70.setMaximumSize(null);
    jButton70.setMinimumSize(null);
    jButton70.setPreferredSize(null);

    jButton71.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton71.setMaximumSize(null);
    jButton71.setMinimumSize(null);
    jButton71.setPreferredSize(null);

    jButton72.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton72.setMaximumSize(null);
    jButton72.setMinimumSize(null);
    jButton72.setPreferredSize(null);

    jButton73.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton73.setMaximumSize(null);
    jButton73.setMinimumSize(null);
    jButton73.setPreferredSize(null);

    jButton74.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton74.setMaximumSize(null);
    jButton74.setMinimumSize(null);
    jButton74.setPreferredSize(null);

    jButton75.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton75.setMaximumSize(null);
    jButton75.setMinimumSize(null);
    jButton75.setPreferredSize(null);

    jButton76.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton76.setMaximumSize(null);
    jButton76.setMinimumSize(null);
    jButton76.setPreferredSize(null);

    jButton77.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton77.setMaximumSize(null);
    jButton77.setMinimumSize(null);
    jButton77.setPreferredSize(null);

    jButton78.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton78.setMaximumSize(null);
    jButton78.setMinimumSize(null);
    jButton78.setPreferredSize(null);

    jButton79.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton79.setMaximumSize(null);
    jButton79.setMinimumSize(null);
    jButton79.setPreferredSize(null);

    jButton80.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton80.setMaximumSize(null);
    jButton80.setMinimumSize(null);
    jButton80.setPreferredSize(null);

    jButton81.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton81.setMaximumSize(null);
    jButton81.setMinimumSize(null);
    jButton81.setPreferredSize(null);
    jButton81.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton81ActionPerformed(evt);
      }
    });

    jButton82.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton82.setMaximumSize(null);
    jButton82.setMinimumSize(null);
    jButton82.setPreferredSize(null);

    jButton83.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton83.setMaximumSize(null);
    jButton83.setMinimumSize(null);
    jButton83.setPreferredSize(null);

    jButton84.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton84.setMaximumSize(null);
    jButton84.setMinimumSize(null);
    jButton84.setPreferredSize(null);

    jButton85.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton85.setMaximumSize(null);
    jButton85.setMinimumSize(null);
    jButton85.setPreferredSize(null);

    jButton86.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton86.setMaximumSize(null);
    jButton86.setMinimumSize(null);
    jButton86.setPreferredSize(null);

    jButton87.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton87.setMaximumSize(null);
    jButton87.setMinimumSize(null);
    jButton87.setPreferredSize(null);

    jButton88.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton88.setMaximumSize(null);
    jButton88.setMinimumSize(null);
    jButton88.setPreferredSize(null);

    jButton89.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton89.setMaximumSize(null);
    jButton89.setMinimumSize(null);
    jButton89.setPreferredSize(null);

    jButton90.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton90.setMaximumSize(null);
    jButton90.setMinimumSize(null);
    jButton90.setPreferredSize(null);

    jButton91.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton91.setMaximumSize(null);
    jButton91.setMinimumSize(null);
    jButton91.setPreferredSize(null);

    jButton92.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton92.setMaximumSize(null);
    jButton92.setMinimumSize(null);
    jButton92.setPreferredSize(null);

    jButton93.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton93.setMaximumSize(null);
    jButton93.setMinimumSize(null);
    jButton93.setPreferredSize(null);

    jButton94.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton94.setMaximumSize(null);
    jButton94.setMinimumSize(null);
    jButton94.setPreferredSize(null);

    jButton95.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton95.setMaximumSize(null);
    jButton95.setMinimumSize(null);
    jButton95.setPreferredSize(null);

    jButton96.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton96.setMaximumSize(null);
    jButton96.setMinimumSize(null);
    jButton96.setPreferredSize(null);

    jButton97.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton97.setMaximumSize(null);
    jButton97.setMinimumSize(null);
    jButton97.setPreferredSize(null);

    jButton98.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton98.setMaximumSize(null);
    jButton98.setMinimumSize(null);
    jButton98.setPreferredSize(null);

    jButton99.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton99.setMaximumSize(null);
    jButton99.setMinimumSize(null);
    jButton99.setPreferredSize(null);

    jButton100.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton100.setMaximumSize(null);
    jButton100.setMinimumSize(null);
    jButton100.setPreferredSize(null);

    jButton101.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton101.setMaximumSize(null);
    jButton101.setMinimumSize(null);
    jButton101.setPreferredSize(null);

    jButton102.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton102.setMaximumSize(null);
    jButton102.setMinimumSize(null);
    jButton102.setPreferredSize(null);

    jButton103.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton103.setMaximumSize(null);
    jButton103.setMinimumSize(null);
    jButton103.setPreferredSize(null);

    jButton104.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton104.setMaximumSize(null);
    jButton104.setMinimumSize(null);
    jButton104.setPreferredSize(null);

    jButton105.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton105.setMaximumSize(null);
    jButton105.setMinimumSize(null);
    jButton105.setPreferredSize(null);

    jButton106.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton106.setMaximumSize(null);
    jButton106.setMinimumSize(null);
    jButton106.setPreferredSize(null);

    jButton107.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton107.setMaximumSize(null);
    jButton107.setMinimumSize(null);
    jButton107.setPreferredSize(null);

    jButton108.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton108.setMaximumSize(null);
    jButton108.setMinimumSize(null);
    jButton108.setPreferredSize(null);

    jButton109.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton109.setMaximumSize(null);
    jButton109.setMinimumSize(null);
    jButton109.setPreferredSize(null);

    jButton110.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton110.setMaximumSize(null);
    jButton110.setMinimumSize(null);
    jButton110.setPreferredSize(null);

    jButton111.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton111.setMaximumSize(null);
    jButton111.setMinimumSize(null);
    jButton111.setPreferredSize(null);

    jButton112.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton112.setMaximumSize(null);
    jButton112.setMinimumSize(null);
    jButton112.setPreferredSize(null);

    jButton113.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton113.setMaximumSize(null);
    jButton113.setMinimumSize(null);
    jButton113.setPreferredSize(null);

    jButton114.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton114.setMaximumSize(null);
    jButton114.setMinimumSize(null);
    jButton114.setPreferredSize(null);

    jButton115.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton115.setMaximumSize(null);
    jButton115.setMinimumSize(null);
    jButton115.setPreferredSize(null);

    jButton116.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton116.setMaximumSize(null);
    jButton116.setMinimumSize(null);
    jButton116.setPreferredSize(null);

    jButton117.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton117.setMaximumSize(null);
    jButton117.setMinimumSize(null);
    jButton117.setPreferredSize(null);

    titulo.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
    titulo.setForeground(new java.awt.Color(255, 255, 255));
    titulo.setText("Tabla Periodica");

    jButton118.setBackground(new java.awt.Color(51, 51, 255));
    jButton118.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jButton118.setForeground(new java.awt.Color(255, 255, 255));
    jButton118.setText("Salir");
    jButton118.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton118ActionPerformed(evt);
      }
    });

    ordenarNumero.setText("Número");
    ordenarNumero.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ordenarNumeroActionPerformed(evt);
      }
    });

    ordenarSimbolo.setText("Símbolo");
    ordenarSimbolo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ordenarSimboloActionPerformed(evt);
      }
    });

    ordenarMasa.setText("Masa");
    ordenarMasa.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ordenarMasaActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Ordenar:");

    fondo.setIcon(new javax.swing.ImageIcon("D:\\TEC\\Ingenieria en Computacion\\2018\\Semestre II 2018\\POO\\Tabla Periodica\\Tabla\\planet.jpg")); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                      .addGap(6, 6, 6)
                      .addComponent(ordenarNumero)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(ordenarMasa)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(ordenarSimbolo))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                  .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton111, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton118)))
        .addContainerGap(104, Short.MAX_VALUE))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1423, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(0, 0, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(ordenarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ordenarSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ordenarMasa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                  .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                      .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                          .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                          .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton89, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton91, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton95, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton93, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton104, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton106, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton110, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton108, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton111, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jButton118)
        .addGap(165, 165, 165))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(0, 114, Short.MAX_VALUE)))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void jButton118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton118ActionPerformed
    System.exit(0);
  }//GEN-LAST:event_jButton118ActionPerformed
  /**
   * Compara dos Strings
   *
   * @param s1
   * @param s2
   * @return 0 si iguales, 1 si si > s2, -1 si s2 > s1
   */
  private int compareStrings(String s1, String s2) {
    int i = 0;
    for (; i < s1.length(); i++) {
      if (i >= s2.length()) {
        return 1;
      } else if (s1.toCharArray()[i] > s2.toCharArray()[i]) {
        return 1;
      } else if (s2.toCharArray()[i] > s1.toCharArray()[i]) {
        return -1;
      }
    }
    return i == s2.length() - 1 ? 0 : -1;
  }
  private void ordenarSimboloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarSimboloActionPerformed
    Elemento[] elems = tp.getElementos();
    Arrays.sort(elems, (Elemento e1, Elemento e2) -> compareStrings(e1.getSimbolo(), e2.getSimbolo()));
    cargarBotones(elems);
  }//GEN-LAST:event_ordenarSimboloActionPerformed

  private void ordenarMasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarMasaActionPerformed
    Elemento[] elems = tp.getElementos();
    Arrays.sort(elems, (Elemento e1, Elemento e2) -> e1.getMasaAtomica() > e2.getMasaAtomica() ? 1 : (e2.getMasaAtomica() > e1.getMasaAtomica() ? -1 : 0));
    cargarBotones(elems);
//    for (Elemento)
  }//GEN-LAST:event_ordenarMasaActionPerformed

  private void ordenarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarNumeroActionPerformed
    Elemento[] elems = tp.getElementos();
    Arrays.sort(elems, (Elemento e1, Elemento e2) -> e1.getNumeroAtomico() - e2.getNumeroAtomico());
    cargarBotones(elems);
  }//GEN-LAST:event_ordenarNumeroActionPerformed

  private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton81ActionPerformed

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
      java.util.logging.Logger.getLogger(TablaPeriodicaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TablaPeriodicaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TablaPeriodicaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TablaPeriodicaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new TablaPeriodicaUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel fondo;
  private javax.swing.JButton jButton0;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton10;
  private javax.swing.JButton jButton100;
  private javax.swing.JButton jButton101;
  private javax.swing.JButton jButton102;
  private javax.swing.JButton jButton103;
  private javax.swing.JButton jButton104;
  private javax.swing.JButton jButton105;
  private javax.swing.JButton jButton106;
  private javax.swing.JButton jButton107;
  private javax.swing.JButton jButton108;
  private javax.swing.JButton jButton109;
  private javax.swing.JButton jButton11;
  private javax.swing.JButton jButton110;
  private javax.swing.JButton jButton111;
  private javax.swing.JButton jButton112;
  private javax.swing.JButton jButton113;
  private javax.swing.JButton jButton114;
  private javax.swing.JButton jButton115;
  private javax.swing.JButton jButton116;
  private javax.swing.JButton jButton117;
  private javax.swing.JButton jButton118;
  private javax.swing.JButton jButton12;
  private javax.swing.JButton jButton13;
  private javax.swing.JButton jButton14;
  private javax.swing.JButton jButton15;
  private javax.swing.JButton jButton16;
  private javax.swing.JButton jButton17;
  private javax.swing.JButton jButton18;
  private javax.swing.JButton jButton19;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton20;
  private javax.swing.JButton jButton21;
  private javax.swing.JButton jButton22;
  private javax.swing.JButton jButton23;
  private javax.swing.JButton jButton24;
  private javax.swing.JButton jButton25;
  private javax.swing.JButton jButton26;
  private javax.swing.JButton jButton27;
  private javax.swing.JButton jButton28;
  private javax.swing.JButton jButton29;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton30;
  private javax.swing.JButton jButton31;
  private javax.swing.JButton jButton32;
  private javax.swing.JButton jButton33;
  private javax.swing.JButton jButton34;
  private javax.swing.JButton jButton35;
  private javax.swing.JButton jButton36;
  private javax.swing.JButton jButton37;
  private javax.swing.JButton jButton38;
  private javax.swing.JButton jButton39;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton40;
  private javax.swing.JButton jButton41;
  private javax.swing.JButton jButton42;
  private javax.swing.JButton jButton43;
  private javax.swing.JButton jButton44;
  private javax.swing.JButton jButton45;
  private javax.swing.JButton jButton46;
  private javax.swing.JButton jButton47;
  private javax.swing.JButton jButton48;
  private javax.swing.JButton jButton49;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton50;
  private javax.swing.JButton jButton51;
  private javax.swing.JButton jButton52;
  private javax.swing.JButton jButton53;
  private javax.swing.JButton jButton54;
  private javax.swing.JButton jButton55;
  private javax.swing.JButton jButton56;
  private javax.swing.JButton jButton57;
  private javax.swing.JButton jButton58;
  private javax.swing.JButton jButton59;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton60;
  private javax.swing.JButton jButton61;
  private javax.swing.JButton jButton62;
  private javax.swing.JButton jButton63;
  private javax.swing.JButton jButton64;
  private javax.swing.JButton jButton65;
  private javax.swing.JButton jButton66;
  private javax.swing.JButton jButton67;
  private javax.swing.JButton jButton68;
  private javax.swing.JButton jButton69;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton70;
  private javax.swing.JButton jButton71;
  private javax.swing.JButton jButton72;
  private javax.swing.JButton jButton73;
  private javax.swing.JButton jButton74;
  private javax.swing.JButton jButton75;
  private javax.swing.JButton jButton76;
  private javax.swing.JButton jButton77;
  private javax.swing.JButton jButton78;
  private javax.swing.JButton jButton79;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton80;
  private javax.swing.JButton jButton81;
  private javax.swing.JButton jButton82;
  private javax.swing.JButton jButton83;
  private javax.swing.JButton jButton84;
  private javax.swing.JButton jButton85;
  private javax.swing.JButton jButton86;
  private javax.swing.JButton jButton87;
  private javax.swing.JButton jButton88;
  private javax.swing.JButton jButton89;
  private javax.swing.JButton jButton9;
  private javax.swing.JButton jButton90;
  private javax.swing.JButton jButton91;
  private javax.swing.JButton jButton92;
  private javax.swing.JButton jButton93;
  private javax.swing.JButton jButton94;
  private javax.swing.JButton jButton95;
  private javax.swing.JButton jButton96;
  private javax.swing.JButton jButton97;
  private javax.swing.JButton jButton98;
  private javax.swing.JButton jButton99;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JButton ordenarMasa;
  private javax.swing.JButton ordenarNumero;
  private javax.swing.JButton ordenarSimbolo;
  private javax.swing.JLabel titulo;
  // End of variables declaration//GEN-END:variables
}
