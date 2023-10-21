package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Rules extends Object {
    
    public Rules(String sNomeImagePNG, int code) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovivel = true;
        this.code = code;
    }
    
    public boolean moveUp() {
        this.pPosicao.moveUp();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().updateMapa(this);
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        this.pPosicao.moveRight();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().updateMapa(this);
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        this.pPosicao.moveDown();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().updateMapa(this);
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        this.pPosicao.moveLeft();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().updateMapa(this);
            Desenho.acessoControleJogo().UpdateRules();
            return true;
        }
        return false;
    }
}
