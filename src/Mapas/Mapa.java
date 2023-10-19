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
    private int[][] matrizIndex;
    private ArrayList<Personagem> faseAtual;    
    
    public Mapa(int[][] matrizM) {
        matrizMapa = matrizM;
        matrizIndex = new int[Consts.RES_VER][Consts.RES_HOR];
        faseAtual = new ArrayList<Personagem>();
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                switch(matrizMapa[y][x]) {
                    case 1:
                        Hero hero = new Hero("skoot.png");
                        hero.setPosicao(y,x);
                        faseAtual.add(hero);
                        matrizIndex[y][x] = faseAtual.size() - 1;
                        break;
                    case 2:
                        Caveira caveira = new Caveira("caveira.png");
                        caveira.setPosicao(y,x);
                        faseAtual.add(caveira);
                        matrizIndex[y][x] = faseAtual.size() - 1;
                        break;
                    case 3:
                        Rock rock = new Rock("Rock.png");
                        rock.setPosicao(y,x);
                        faseAtual.add(rock);
                        matrizIndex[y][x] = faseAtual.size() - 1;
                        break;
                    default:
                        matrizIndex[y][x] = -1;
                        break;
                }
            }
        }
    }
    
    public Personagem checaVizinhoMapa(Posicao p, int direcao) {
        int index;
        switch(direcao) {
            case 1:
                index = this.matrizIndex[p.getLinha()][p.getColuna()];
                return faseAtual.get(index);
            case 2:
                index = this.matrizIndex[p.getLinha()][p.getColuna()];
                return faseAtual.get(index);
            case 3:
                index = this.matrizIndex[p.getLinha()][p.getColuna()];
                return faseAtual.get(index);
            case 4:
                index = this.matrizIndex[p.getLinha()][p.getColuna()];
                return faseAtual.get(index);
            default:
                return null;
        }
    }
    
    public ArrayList<Personagem> getFaseAtual() {
        return this.faseAtual;
    }
    
    public void updatePosMapa(Personagem pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        matrizMapa[pos.getLinha()][pos.getColuna()] = pers.getCode();
        matrizIndex[pos.getLinha()][pos.getColuna()] = matrizIndex[pos.getLinhaAnterior()][pos.getColunaAnterior()];
        matrizIndex[pos.getLinhaAnterior()][pos.getColunaAnterior()] = -1;
    }
}