package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Rock extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public Rock(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovivel = true;
        this.iContaIntervalos = 0;
        this.code = 3;
    }
}
