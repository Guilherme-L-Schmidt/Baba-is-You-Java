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


    protected Personagem(String sNomeImagePNG) {
        this.code = 0;
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMovivel = false;
        this.bMortal = false;
        this.seMove = false;
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

    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
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
        if (!Desenho.acessoControleJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
}