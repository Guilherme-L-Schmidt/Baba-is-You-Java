package Modelo;

import java.util.ArrayList;
import Auxiliar.Desenho;
import java.io.Serializable;

public class Wall extends Object implements Serializable{
    
    public Wall() {
        super("Walls/wall_0_1.png");
        this.code = 10;
    }
    
    public boolean moveUp() {
        this.pPosicao.moveUp();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateWalls();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        this.pPosicao.moveRight();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateWalls();
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        this.pPosicao.moveDown();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateWalls();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        this.pPosicao.moveLeft();
        if(validaPosicao()) {
            Desenho.acessoControleJogo().UpdateWalls();
            return true;
        }
        return false;
    }
}
