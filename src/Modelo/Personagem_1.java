package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Personagem_1 extends Object {
    
    /**
     *
     * @param sNomeImagePNG
     */
    public Personagem_1(String sNomeImagePNG) {
        super(sNomeImagePNG, 0);
        this.setImage(sNomeImagePNG);
    }
    
    public void setImage(String sNomeImagePNG) {
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.RES_HOR * Consts.CELL_SIDE, Consts.RES_VER*Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.RES_HOR * Consts.CELL_SIDE, Consts.RES_VER * Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void autoDesenho() {
        Desenho.desenhar(this.iImage, 0, 0);
    }

    @Override
    public boolean moveUp() {return true;}

    @Override
    public boolean moveRight()  {return true;}

    @Override
    public boolean moveDown() {return true;}

    @Override
    public boolean moveLeft() {return true;}
    
}
