package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Win extends Rules implements Serializable{
    
    public R_Win() {
        super("Win.png");
        this.code = 50;
    }
}
