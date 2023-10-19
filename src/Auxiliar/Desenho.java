package Auxiliar;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import Controler.Tela;
import Controler.ControleDeJogo;

public class Desenho implements Serializable {
    static Tela jCenario;
    static ControleDeJogo cJogo;
    public static void setCenario(Tela umJCenario) {
        jCenario = umJCenario;
    }
    
    public static void setControle(ControleDeJogo controle) {
        cJogo = controle;
    }

    public static ControleDeJogo acessoControleJogo() {
        return cJogo;
    }
    
    public static Tela acessoATelaDoJogo() {
        return jCenario;
    }

    public static Graphics getGraphicsDaTela() {
        return jCenario.getGraphicsBuffer();
    }
    
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        iImage.paintIcon(jCenario,getGraphicsDaTela(),iColuna * Consts.CELL_SIDE, iLinha * Consts.CELL_SIDE);
    }
}
