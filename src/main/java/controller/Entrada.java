package controller; 

import java.util.ArrayList;
import java.util.Date;
import model.Exportacao;
import model.Modelo;


public class Entrada {      

    Modelo model;

    public Entrada(String dateParametro){
        Date date = Utilitaria.convertStringToDate(dateParametro);  
        this.model = new Modelo(new ArrayList<>(), date, new ArrayList<>());      
    }

    public void addWord(String word){
        this.model.setPalavraTexto(word);
    }

    public void adicionaCategoria(String word){
        // método que recebe uma palavra do texto da entrada e 
        // determina se ela se encaixa em uma das categorias
        // padrão, cuja lista foi determinada na classe
        // Utilitaria 

        ArrayList <String> array = Utilitaria.getCategoriasPadrao();

        for (String s : array){
            if (word.equalsIgnoreCase(s)){
                ArrayList<String> aux = this.model.getCategorias();
                aux.add(word);
                this.model.setCategorias(aux);
            }
        }

    }

    public void exportarEntrada(){
        Exportacao ex = new Exportacao();
        ex.exportaObjeto(this.model);
    }

}
