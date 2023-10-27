package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Rules extends Object implements Serializable{
    
    private static final long serialVersionUID = 6529685098267757696L;
    
    public Rules(String sNomeImagePNG, int code) {
        super(sNomeImagePNG, code);
        this.bStop = true;
        this.bPush = true;
    }
    
    public boolean moveUp() {
        if(this.pPosicao.moveUp())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().updateMapa(this);
                Desenho.acessoControleJogo().UpdateRules();
                return true;
            }
        return false;
    }

    public boolean moveRight() {
        if(this.pPosicao.moveRight())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().updateMapa(this);
                Desenho.acessoControleJogo().UpdateRules();
                return true;
            }
        return false;
    }

    public boolean moveDown() {
        if(this.pPosicao.moveDown())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().updateMapa(this);
                Desenho.acessoControleJogo().UpdateRules();
                return true;
            }
        return false;
    }

    public boolean moveLeft() {
        if(this.pPosicao.moveLeft()) 
            if(validaPosicao()) {
                Desenho.acessoControleJogo().updateMapa(this);
                Desenho.acessoControleJogo().UpdateRules();
                return true;
            }
        return false;
    }
}
