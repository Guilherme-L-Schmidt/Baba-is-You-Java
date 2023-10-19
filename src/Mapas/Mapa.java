package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Controler.ControleDeJogo;
import Modelo.Personagem;
import Modelo.Hero;
import Modelo.Caveira;

public class Mapa {
    
    private int[][] matrizMapa;
    
    public Mapa(int[][] matrizM) {
        matrizMapa = matrizM;
    }
    
    public void updateMapa(Personagem pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getColunaAnterior()][pos.getLinhaAnterior()] = 0;
        matrizMapa[pos.getColuna()][pos.getLinha()] = pers.getCode();
    }

    public void setRenderMapa(ControleDeJogo cj) {
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                switch(matrizMapa[y][x]) {
                    case 1:
                        Hero hero = new Hero("skoot.png");
                        hero.setPosicao(y,x);
                        cj.addPersonagem(hero);
                        break;
                    case 2:
                        Caveira caveira = new Caveira("caveira.png");
                        caveira.setPosicao(y,x);
                        cj.addPersonagem(caveira);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}