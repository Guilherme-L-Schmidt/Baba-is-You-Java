package Auxiliar;

import java.io.Serializable;

public class Posicao  implements Serializable, Cloneable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;
    
    private int[] offsets;

    public Posicao(int linha, int coluna, int[] offsets) {
        this.offsets = offsets;
        this.setPosicao(linha,coluna);
        linhaAnterior = linha;
        colunaAnterior = coluna;
    }

    public boolean setPosicao(int linha, int coluna) {  
        if(linha < offsets[0] || linha >= Auxiliar.Consts.RES_VER - offsets[0])
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < offsets[1] || coluna >= Auxiliar.Consts.RES_HOR - offsets[1])
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        
        return true;
    }
    public Posicao clone() throws CloneNotSupportedException{
        return (Posicao) super.clone();
    }
    
    public int getDirecao() {
        if (linha - linhaAnterior == 1) {
            return 3;
        }
        if (linha - linhaAnterior == -1) {
            return 1;
        }
        if (coluna - colunaAnterior == 1) {
            return 2;
        }
        if (coluna - colunaAnterior == -1) {
            return 4;
        }
        return 0;
    }
    
    public int getLinha(){
        return linha;
    }

    public int getColuna(){
        return coluna;
    }
    
    public int getLinhaAnterior(){
        return linhaAnterior;
    }

    public int getColunaAnterior(){
        return colunaAnterior;
    }
   
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }

    public boolean igual(Posicao posicao){
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }

    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    
    
    public boolean moveUp(){
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
    public boolean moveDown(){
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
    public boolean moveRight(){
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
    public boolean moveLeft(){
        return this.setPosicao(this.getLinha(), this.getColuna()-1);        
    }
}
