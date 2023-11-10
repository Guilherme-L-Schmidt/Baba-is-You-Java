package Modelo;

import java.io.Serializable;

public class PersonagemAnimado extends Personagem{
    private String subname;
    private int contaAnima;
    private static final long serialVersionUID = 6529685098267757695L;
    
    public PersonagemAnimado(String name, int code) {
        super(name + "0", code);
        this.subname = name;
        this.contaAnima = 0;
    }
    
    public boolean moveUp() {
        boolean success = super.moveUp();
        if(contaAnima > 2)
            this.contaAnima = 0;
        else
            this.contaAnima++;
        this.setName(subname + (8 + contaAnima));
        return success;
    }

    public boolean moveRight() {
        boolean success = super.moveRight();
        if(contaAnima > 2)
            this.contaAnima = 0;
        else
            this.contaAnima++;
        this.setName(subname + (0 + contaAnima));
        return success;
    }

    public boolean moveDown() {
        boolean success = super.moveDown();
        if(contaAnima > 2)
            this.contaAnima = 0;
        else
            this.contaAnima++;
        this.setName(subname + (24 + contaAnima));
        return success;
    }

    public boolean moveLeft() {
        boolean success = super.moveLeft();
        if(contaAnima > 2)
            this.contaAnima = 0;
        else
            this.contaAnima++;
        this.setName(subname + (16 + contaAnima));
        return success;
    }
}
