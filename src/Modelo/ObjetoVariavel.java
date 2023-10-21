package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class ObjetoVariavel extends Object implements Serializable{
    private String name;    
    
    public ObjetoVariavel(String name, int code) {
        super(name + "0_1.png", code);
        this.name = name;
    }
    
    public boolean moveUp() {
        this.pPosicao.moveUp();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateObjetoVariavel(name, code);
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        this.pPosicao.moveRight();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateObjetoVariavel(name, code);
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        this.pPosicao.moveDown();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateObjetoVariavel(name, code);
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        this.pPosicao.moveLeft();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateObjetoVariavel(name, code);
            return true;
        }
        return false;
    }
}
