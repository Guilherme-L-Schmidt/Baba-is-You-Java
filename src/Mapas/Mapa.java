package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Controler.ControleDeJogo;
import Modelo.Personagem;
import Modelo.Baba;
import Modelo.Caveira;
import Modelo.Rock;
import Modelo.R_Baba;
import Modelo.R_Is;
import Modelo.R_You;
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
                    case 21:
                        R_Baba r_baba = new R_Baba();
                        r_baba.setPosicao(y, x);
                        faseAtual.add(r_baba);
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