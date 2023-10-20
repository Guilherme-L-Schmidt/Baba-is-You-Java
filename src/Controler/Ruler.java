package Controler;

import Auxiliar.Consts;
import Mapas.Mapa;
import Modelo.Personagem;
import java.util.ArrayList;

public class Ruler {
    public void AnalyseRules(Mapa mapa) {
        int[][] ruleMap = mapa.getRuleMap();
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                if(ruleMap[x][y] == 40 /*code for 'is' statement*/){
                    
                }
            }
        }
    }
    
    private void CheckSides(int xatual, int yatual, Mapa mapa) {
        int[][] ruleMap = mapa.getRuleMap();
        
        int xObj = xatual-1;
        int yObj = yatual;
        
        int xRul = xatual+1;
        int yRul = yatual;
        
        // Checks all rules horizontally
        for(;xObj >= 0;) {
            if(ruleMap[xObj][yObj] > 20 && ruleMap[xObj][yObj] < 40) {
                for(;xRul < Consts.RES_HOR;) {
                    if(ruleMap[xRul][yRul] > 40 && ruleMap[xRul][yRul] < 60) {
                        setRuleAll(mapa, ruleMap[xObj][yObj], ruleMap[xRul][yRul]);
                        if(xRul < Consts.RES_HOR-1 && ruleMap[xRul+1][yRul] == 60) {
                            xRul += 2;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                xRul = xatual+1;
                yRul = yatual;
                if (xObj > 0 && ruleMap[xObj-1][yObj] == 60) {   
                    xObj -= 2;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        
        xObj = xatual;
        yObj = yatual-1;
        
        xRul = xatual;
        yRul = yatual+1;
        
        // Checks all rules vertically
        for(; yObj >= 0;) {
            if(ruleMap[xObj][yObj] > 20 && ruleMap[xObj][yObj] < 40) {
                for(;yRul < Consts.RES_VER;) {
                    if(ruleMap[xRul][yRul] > 40 && ruleMap[xRul][yRul] < 60) {
                        setRuleAll(mapa, ruleMap[xObj][yObj], ruleMap[xRul][yRul]);
                        if(yRul < Consts.RES_VER-1 && ruleMap[xRul][yRul+1] == 60) {
                            yRul += 2;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                xRul = xatual;
                yRul = yatual+1;
                if (yObj > 0 && ruleMap[xObj][yObj-1] == 60) {   
                    yObj -= 2;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        
    }
    
    private void setRuleAll(Mapa mapa, int codeObj, int codeRule) {
        ArrayList<Personagem> faseAtual = mapa.getFaseAtual();
        
        for(int i = 0; i < faseAtual.size(); i++) {
            Personagem p = faseAtual.get(i);
            if(p.getCode() + 20 == codeObj) {
                applyRule(p, codeRule);
            }
        }
    }
    
    private void applyRule(Personagem p, int codeRule) {
        switch(codeRule) {
            case 41:
                p.setbTransponivel(false);
                p.setbMovivel(false);
                break;
            case 42:
                p.setbTransponivel(false);
                p.setbMovivel(true);
                break;
            case 43:
                break;
            case 44:
                break;
        }
    }
}
