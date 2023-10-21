package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Caveira extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public Caveira(String sNomeImagePNG) {
        super(sNomeImagePNG, 2);
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER){
            this.iContaIntervalos = 0;
            Fogo f = new Fogo("fire.png");
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            Desenho.acessoControleJogo().addObject(f);
        }
    }    
}
