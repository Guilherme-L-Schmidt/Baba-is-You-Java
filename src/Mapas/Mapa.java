package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Controler.ControleDeJogo;
import Modelo.Personagem;
import Modelo.Baba;
import Modelo.Caveira;
import Modelo.Rock;
import Modelo.Flag;
import Modelo.Wall;
import Modelo.R_Baba;
import Modelo.R_Rock;
import Modelo.R_Flag;
import Modelo.R_Wall;
import Modelo.R_Is;
import Modelo.R_You;
import Modelo.R_Stop;
import Modelo.R_Push;
import Modelo.R_Win;
import Modelo.R_And;
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
                        Baba baba = new Baba("Baba.png");
                        baba.setPosicao(y,x);
                        faseAtual.add(baba);
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
                    case 5:
                        Flag flag = new Flag("Flag.png");
                        flag.setPosicao(y, x);
                        faseAtual.add(flag);
                        break;
                    case 10:
                        Wall wall = new Wall();
                        wall.setPosicao(y, x);
                        faseAtual.add(wall);
                        break;
                    case 21:
                        R_Baba r_baba = new R_Baba();
                        r_baba.setPosicao(y, x);
                        faseAtual.add(r_baba);
                        break;
                    case 23:
                        R_Rock r_rock = new R_Rock();
                        r_rock.setPosicao(y, x);
                        faseAtual.add(r_rock);
                        break;
                    case 25:
                        R_Flag r_flag = new R_Flag();
                        r_flag.setPosicao(y, x);
                        faseAtual.add(r_flag);
                        break;
                    case 30:
                        R_Wall r_wall = new R_Wall();
                        r_wall.setPosicao(y, x);
                        faseAtual.add(r_wall);
                        break;
                    case 40:
                        R_Is r_is = new R_Is();
                        r_is.setPosicao(y, x);
                        faseAtual.add(r_is);
                        break;
                    case 41:
                        R_You r_you = new R_You();
                        r_you.setPosicao(y, x);
                        faseAtual.add(r_you);
                        break;
                    case 42:
                        R_Stop r_stop = new R_Stop();
                        r_stop.setPosicao(y, x);
                        faseAtual.add(r_stop);
                        break;
                    case 43:
                        R_Push r_push = new R_Push();
                        r_push.setPosicao(y, x);
                        faseAtual.add(r_push);
                        break;
                    case 50:
                        R_Win r_win = new R_Win();
                        r_win.setPosicao(y, x);
                        faseAtual.add(r_win);
                        break;
                    case 60:
                        R_And r_and = new R_And();
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
    
    public ArrayList<Personagem> getFaseAtual() {
        return this.faseAtual;
    }
    
    public void updateRuleMap(Personagem pers) {
        Posicao pos = pers.getPosicao();
        ruleMap[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        ruleMap[pos.getLinha()][pos.getColuna()] = pers.getCode();        
    }
    
    public void updatePosMapa(Personagem pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        matrizMapa[pos.getLinha()][pos.getColuna()] = pers.getCode();
    }
}