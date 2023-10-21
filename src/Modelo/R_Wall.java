package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Wall extends Rules implements Serializable{
    
    public R_Wall() {
        super("T_Wall.png");
        this.code = 30;
    }
}
