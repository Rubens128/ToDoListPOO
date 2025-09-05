/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist.aplicativo.controller;

import java.util.ArrayList;
import todolist.aplicativo.model.Tarefa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ruben
 */
public class TarefaServico {
    public static void criar(ArrayList<Tarefa> lista, String titulo, String descricao, int id){
        
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        
        novaTarefa.setID(id);
        
        lista.add(novaTarefa);
        
    }
    
    public static ArrayList<String> listar(ArrayList<Tarefa> lista){
        
        ArrayList<String> dadosTarefas = new ArrayList<>();
        
        for(Tarefa item: lista){
            
            DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            String dadosDaTarefa = "\nID: " + item.getID() + "\n" + "Titulo: " + item.getTitulo() + "\n";
            dadosDaTarefa += "Descricao: "+ item.getDescricao() + "\n";
            dadosDaTarefa += "Completado: "+(item.getComplete()? "Sim" : "Nao") + "\n";
            dadosDaTarefa += "Data de Inicio: " + (item.getDataAgora().format(dataFormato)) + "\n";
            if(item.getDataConclusao() != null) dadosDaTarefa += "Data de Conclusao: " + (item.getDataConclusao().format(dataFormato)) + "\n\n";
            else dadosDaTarefa += "Data de Conclusao: Nao concluido \n\n";
                
            dadosTarefas.add(dadosDaTarefa);
            
        }
        
        return dadosTarefas;
    }
}
