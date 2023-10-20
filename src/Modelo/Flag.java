package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Flag extends Personagem implements Serializable{
    
    public Flag(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.code = 5;
    }
}
