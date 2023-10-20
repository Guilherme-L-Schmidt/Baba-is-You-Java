package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Controler.ControleDeJogo;
import Modelo.Personagem;
import Modelo.Hero;
import Modelo.Caveira;
import Modelo.Rock;
import java.util.ArrayList;

public class Mapa {
    
    private int[][] matrizMapa;
    private int[][] ruleMap;
    private ArrayList<Personagem> faseAtual;   
    
    public Mapa(int[][] matrizM) {
        matrizMapa = matrizM;
        ruleMap = new int[Consts.RES_VER][Consts.RES_HOR];
        faseAtual = new ArrayList<Personagem>();
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                switch(matrizMapa[y][x]) {
                    case 1:
                        Hero hero = new Hero("skoot.png");
                        hero.setPosicao(y,x);
                        faseAtual.add(hero);
                        break;
                    case 2:
                        Caveira caveira = new Caveira("caveira.png");
                        caveira.setPosicao(y,x);
                        faseAtual.add(caveira);
                        break;
                    case 3:
                        Rock rock = new Rock("Rock.png");
                        rock.setPosicao(y,x);
                        faseAtual.add(rock);
                        break;
                    default:
                        ruleMap[y][x] = 0;
                        break;
                }
            }
        }
    }
    
    public int[][] getRuleMap() {
        return this.ruleMap;
    }
    
    public ArrayList<Personagem> getFaseAtual() {
        return this.faseAtual;
    }
    
    public void updatePosMapa(Personagem pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        matrizMapa[pos.getLinha()][pos.getColuna()] = pers.getCode();
    }
}