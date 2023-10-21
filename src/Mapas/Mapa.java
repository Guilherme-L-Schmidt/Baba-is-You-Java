package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Modelo.Object;
import Modelo.Personagem;
import Modelo.Caveira;
import Modelo.ObjetoVariavel;
import Modelo.Rules;
import java.util.ArrayList;

public class Mapa {
    
    private int[][] matrizMapa;
    private int[][] ruleMap;
    private ArrayList<Object> faseAtual;   
    
    public Mapa(int[][] matrizM) {
        matrizMapa = matrizM;
        ruleMap = new int[Consts.RES_VER][Consts.RES_HOR];
        faseAtual = new ArrayList<Object>();
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                switch(matrizMapa[y][x]) {
                    case 1:
                        Personagem baba = new Personagem("Baba.png", 1);
                        baba.setPosicao(y,x);
                        faseAtual.add(baba);
                        break;
                    case 2:
                        Caveira caveira = new Caveira("caveira.png");
                        caveira.setPosicao(y,x);
                        faseAtual.add(caveira);
                        break;
                    case 3:
                        Personagem rock = new Personagem("Rock.png", 3);
                        rock.setPosicao(y,x);
                        faseAtual.add(rock);
                        break;
                    case 5:
                        Personagem flag = new Personagem("Flag.png", 5);
                        flag.setPosicao(y, x);
                        faseAtual.add(flag);
                        break;
                    case 10:
                        ObjetoVariavel wall = new ObjetoVariavel("Walls/wall_", 10);
                        wall.setPosicao(y, x);
                        faseAtual.add(wall);
                        break;
                    case 11:
                        ObjetoVariavel water = new ObjetoVariavel("Water/water_", 11);
                        water.setPosicao(y, x);
                        faseAtual.add(water);
                        break;
                    case 21:
                        Rules r_baba = new Rules("T_Baba.png", 21);
                        r_baba.setPosicao(y, x);
                        faseAtual.add(r_baba);
                        break;
                    case 23:
                        Rules r_rock = new Rules("T_Rock.png", 23);
                        r_rock.setPosicao(y, x);
                        faseAtual.add(r_rock);
                        break;
                    case 25:
                        Rules r_flag = new Rules("T_Flag.png", 25);
                        r_flag.setPosicao(y, x);
                        faseAtual.add(r_flag);
                        break;
                    case 30:
                        Rules r_wall = new Rules("T_Wall.png", 30);
                        r_wall.setPosicao(y, x);
                        faseAtual.add(r_wall);
                        break;
                    case 40:
                        Rules r_is = new Rules("Is.png", 40);
                        r_is.setPosicao(y, x);
                        faseAtual.add(r_is);
                        break;
                    case 41:
                        Rules r_you = new Rules("You.png", 41);
                        r_you.setPosicao(y, x);
                        faseAtual.add(r_you);
                        break;
                    case 42:
                        Rules r_stop = new Rules("Stop.png", 42);
                        r_stop.setPosicao(y, x);
                        faseAtual.add(r_stop);
                        break;
                    case 43:
                        Rules r_push = new Rules("Push.png", 43);
                        r_push.setPosicao(y, x);
                        faseAtual.add(r_push);
                        break;
                    case 50:
                        Rules r_win = new Rules("Win.png", 50);
                        r_win.setPosicao(y, x);
                        faseAtual.add(r_win);
                        break;
                    case 60:
                        Rules r_and = new Rules("And.png", 60);
                        r_and.setPosicao(y, x);
                        faseAtual.add(r_and);
                        break; 
                    default:
                        break;
                }
                if(matrizMapa[y][x] >= 20)
                    ruleMap[y][x] = matrizMapa[y][x];
                else
                    ruleMap[y][x] = 0;
            }
        }
    }
    
    public int[][] getRuleMap() {
        return this.ruleMap;
    }
    
    public ArrayList<Object> getFaseAtual() {
        return this.faseAtual;
    }
    
    public void updateRuleMap(Object pers) {
        Posicao pos = pers.getPosicao();
        ruleMap[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        ruleMap[pos.getLinha()][pos.getColuna()] = pers.getCode();        
    }
    
    public void updatePosMapa(Object pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        matrizMapa[pos.getLinha()][pos.getColuna()] = pers.getCode();
    }
}