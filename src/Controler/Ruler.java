package Controler;

import Auxiliar.Consts;
import Mapas.Mapa;
import Modelo.Personagem;
import java.util.ArrayList;

public class Ruler {
    public Ruler(Mapa mapa) {
        this.AnalyseRules(mapa);
    }
    
    public void AnalyseRules(Mapa mapa) {
        this.FreeRules(mapa);
        
        int[][] ruleMap = mapa.getRuleMap();
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                if(ruleMap[y][x] == 40 /*code for 'is' statement*/) {
                    CheckSides(x, y, mapa);
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
            if(ruleMap[yObj][xObj] > 20 && ruleMap[yObj][xObj] < 40) {
                for(;xRul < Consts.RES_HOR;) {
                    if(ruleMap[yRul][xRul] > 40 && ruleMap[yRul][xRul] < 60) {
                        setRuleAll(mapa, ruleMap[yObj][xObj], ruleMap[yRul][xRul]);
                        if(xRul < Consts.RES_HOR-1 && ruleMap[yRul][xRul+1] == 60) {
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
                if (xObj > 0 && ruleMap[yObj][xObj-1] == 60) {   
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
            if(ruleMap[yObj][xObj] > 20 && ruleMap[yObj][xObj] < 40) {
                for(;yRul < Consts.RES_VER;) {
                    if(ruleMap[yRul][xRul] > 40 && ruleMap[yRul][xRul] < 60) {
                        setRuleAll(mapa, ruleMap[yObj][xObj], ruleMap[yRul][xRul]);
                        if(yRul < Consts.RES_VER-1 && ruleMap[yRul+1][xRul] == 60) {
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
                if (yObj > 0 && ruleMap[yObj-1][xObj] == 60) {   
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
    
    public void FreeRules(Mapa mapa) {
        for(int i = 0; i < mapa.getFaseAtual().size(); i++) {
            Personagem p = mapa.getFaseAtual().get(i);
            if(p.getCode() < 20)
                applyRule(p, 0);
        }
    }
    
    private void applyRule(Personagem p, int codeRule) {
        System.out.println("Apliquei uma regra " + codeRule);
        switch(codeRule) {
            case 0:
                p.setbTransponivel(true);
                p.setbMovivel(false);
                p.setSeMove(false);
                break;
            case 41: /*You*/
                p.setbTransponivel(false);
                p.setbMovivel(false);
                p.setSeMove(true);
                break;
            case 42: /*Stop*/
                p.setbTransponivel(false);
                p.setbMovivel(false);
                break;
            case 43: /*Push*/
                p.setbTransponivel(false);
                p.setbMovivel(true);
                break;
            case 44:
                break;
        }
    }
}
