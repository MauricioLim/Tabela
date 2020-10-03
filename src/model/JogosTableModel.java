/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mauri
 */
public class JogosTableModel extends AbstractTableModel {
    
    private List<Jogos> dados = new ArrayList<>();
    private String[] colunas = {"Jogos","Placar","Minimo da Temp","Maximo da Temp","Quebra min.","Quebra max."};
    

    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }
  

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getJogo();
            case 1:
                return dados.get(linha).getPlacar();
            case 2:
                return dados.get(linha).getMinimo();
            case 3:
                return dados.get(linha).getMaximo();
            case 4:
                return dados.get(linha).getQuebramin();
            case 5:
                return dados.get(linha).getQuebramax();
        }
        
        return null;
        
    }
    
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
        switch(coluna){
            case 0:
                dados.get(linha).setJogo(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setPlacar(Integer.parseInt((String) valor));
                break;
            case 2:
                dados.get(linha).setMinimo(Integer.parseInt((String) valor));
                break;
            case 3:
                dados.get(linha).setMaximo(Integer.parseInt((String) valor));
                break;
            case 4:
                dados.get(linha).setQuebramin(Integer.parseInt((String) valor));
                break;
            case 5:
                dados.get(linha).setQuebramax(Integer.parseInt((String) valor));
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRown(Jogos j){
        this.dados.add(j);
        this.fireTableDataChanged();
    }
    
    public void remoreRown(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
