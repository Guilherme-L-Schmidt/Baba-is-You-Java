package Modelo;

import java.io.Serializable;

public class Personagem extends Object implements Serializable{
    
    private static final long serialVersionUID = 6529685098267757694L;
    
    public Personagem(String sNomeImagePNG, int code) {
        super(sNomeImagePNG, code);
    }
    
    public boolean moveUp() {
        if(this.pPosicao.moveUp()) {
            return validaPosicao();
        }
        return false;
    }

    public boolean moveRight() {
        if(this.pPosicao.moveRight()) {
            return validaPosicao();
        }
        return false;
    }

    public boolean moveDown() {
        if(this.pPosicao.moveDown()) {
            return validaPosicao();
        }
        return false;
    }

    public boolean moveLeft() {
        if(this.pPosicao.moveLeft()) {
            return validaPosicao();
        }
        return false;
    }
}
