package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Rock extends Personagem implements Serializable{
    
    public Rock(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.code = 3;
    }
}
