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

public abstract class Object implements Serializable {

    protected String name;
    protected int contador;
    protected int contador_frames;
    protected int code;              /*Codigo do personagem*/
    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bStop;         /*Pode passar por cima?*/
    protected boolean bPush;         /*Pode ser movido*/
    protected boolean bYou;          /*Se move com as setas*/
    protected boolean bWin;          /*Se You entra, vence*/
    protected boolean bDefeat;       /*Mata o You*/
    protected boolean bShut;         /*Algo fechado*/
    protected boolean bOpen;         /*Abre o algo fechado*/
    protected boolean bSink;         /*Afunda qualquer objeto sobre ele*/
    protected boolean bHot;          /*Derrete objetos melt*/
    protected boolean bMelt;         /*Derretido por objetos hot*/


    protected Object(String name, int code) {
        this.name = name;
        this.contador = 1;
        this.contador_frames = 0;
        this.code = code;
        this.pPosicao = new Posicao(1, 1, Desenho.acessoControleJogo().getOffset());
        this.bStop = false;
        this.bPush = false;
        this.bYou = false;
        this.bWin = false;
        this.bDefeat = false;
        this.bShut = false;
        this.bOpen = false;
        this.bSink = false;
        this.bHot = false;
        this.bMelt = false;
        this.setImage(name + "_1.png");
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
         diretamente sobre a posição do Object*/
        return pPosicao;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDefeat(boolean defeat) {
        this.bDefeat = defeat;
    }
    
    public boolean getDefeat() {
        return this.bDefeat;
    }
    
    public void setSink(boolean sink) {
        this.bSink = sink;
    }
    
    public boolean getSink() {
        return this.bSink;
    }
    
    public boolean getStop() {
        return bStop;
    }

    public void setStop(boolean stop) {
        this.bStop = stop;
    }
    
    public boolean getPush() {
        return bPush;
    }

    public void setPush(boolean push) {
        this.bPush = push;
    }
    
    public void setWin(boolean win) {
        this.bWin = win;
    }
    
    public boolean getWin() {
        return this.bWin;
    }

    public void autoDesenho() {
        this.contador_frames++;
        if(this.contador_frames == Consts.FRAMES_PER_ANIMATION) {
            if(this.contador == 3)
                this.contador = 1;
            else
                this.contador++;
            
            this.contador_frames = 0;
        }
        
        this.setImage(this.name + "_" + this.contador + ".png");
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }
    
    public void setYou(boolean you) {
        this.bYou = you;
    }
    
    public boolean getYou() {
        return this.bYou;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public boolean getShut() {
        return this.bShut;
    }
    
    public void setShut(boolean shut) {
        this.bShut = shut;
    }
    
    public boolean getOpen() {
        return this.bOpen;
    }
    
    public void setOpen(boolean open) {
        this.bOpen = open;
    }
    
    public boolean getHot() {
        return this.bHot;
    }
    
    public void setHot(boolean hot) {
        this.bHot = hot;
    }
    
    public boolean getMelt() {
        return this.bMelt;
    }
    
    public void setMelt(boolean melt) {
        this.bMelt = melt;
    }    

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public boolean validaPosicao(){
        if (!Desenho.acessoControleJogo().ehPosicaoValida(this)) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;
    }

    public abstract boolean moveUp();
    
    public abstract boolean moveRight();

    public abstract boolean moveDown();

    public abstract boolean moveLeft();
}
