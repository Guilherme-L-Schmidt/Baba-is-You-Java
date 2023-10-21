package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Personagem implements Serializable {

    protected int code;              /*Codigo do personagem*/
    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMovivel;      /*Pode mover?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected boolean seMove;        /*Se move com as setas*/
    protected boolean bWin;        /*Se move com as setas*/


    protected Personagem(String sNomeImagePNG) {
        this.code = 0;
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMovivel = false;
        this.bMortal = false;
        this.seMove = false;
        this.bWin = false;
        this.setImage(sNomeImagePNG);
    }
    
    public void setImage(String sNomeImagePNG) {
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Posicao getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
         diretamente sobre a posição do Personagem*/
        return pPosicao;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }
    
    public boolean isbMovivel() {
        return bMovivel;
    }

    public void setbMovivel(boolean bMovivel) {
        this.bMovivel = bMovivel;
    }
    
    public void setbWin(boolean bWin) {
        this.bWin = bWin;
    }
    
    public boolean getbWin() {
        return this.bWin;
    }

    public void autoDesenho() {
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }
    
    public void setSeMove(boolean seMove) {
        this.seMove = seMove;
    }
    
    public boolean getSeMove() {
        return this.seMove;
    }
    
    public int getCode() {
        return this.code;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public boolean validaPosicao(){
        if (!Desenho.acessoControleJogo().ehPosicaoValida(this)) {
            this.voltaAUltimaPosicao();
            return false;
        }
        Desenho.acessoControleJogo().updateMapa(this);
        return true;
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
