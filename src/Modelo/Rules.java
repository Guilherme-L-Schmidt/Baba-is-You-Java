package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import Controler.Ruler;

public class Rules extends Personagem implements Serializable{
    
    public Rules(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovivel = true;
        this.code = 20;
    }
    
    public boolean moveUp() {
        this.pPosicao.moveUp();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        this.pPosicao.moveRight();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        this.pPosicao.moveDown();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        this.pPosicao.moveLeft();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }
}
