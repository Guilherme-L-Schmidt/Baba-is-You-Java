package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import Controler.Tela;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Baba extends Personagem {
    public Baba(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.code = 1;
    }
    
    
    public boolean setPosicao(int linha, int coluna){
        return this.pPosicao.setPosicao(linha, coluna);
    }
}
