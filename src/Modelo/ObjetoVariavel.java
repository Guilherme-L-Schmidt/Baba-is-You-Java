package Modelo;

import Auxiliar.Desenho;

public class ObjetoVariavel extends Objeto {
    private String subname;
    private static final long serialVersionUID = 6529685098267757693L;
    
    public ObjetoVariavel(String name, int code) {
        super(name + "0", code);
        this.subname = name;
    }
    
    public boolean moveUp() {
        if(this.pPosicao.moveUp())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().UpdateObjetoVariavel(subname, code);
                return true;
            }
        return false;
    }

    public boolean moveRight() {
        if(this.pPosicao.moveRight())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().UpdateObjetoVariavel(subname, code);
                return true;
            }
        return false;
    }

    public boolean moveDown() {
        if(this.pPosicao.moveDown())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().UpdateObjetoVariavel(subname, code);
                return true;
            }
        return false;
    }

    public boolean moveLeft() {
        if(this.pPosicao.moveLeft())
            if(validaPosicao()) {
                Desenho.acessoControleJogo().UpdateObjetoVariavel(subname, code);
                return true;
            }
        return false;
    }
}
