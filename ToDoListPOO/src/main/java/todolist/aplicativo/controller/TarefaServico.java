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
    
    public static boolean verificarID(ArrayList<Tarefa> tarefas, int id) {
        
        if (tarefas.isEmpty()) return false;
    
        for (Tarefa tarefa : tarefas) if (tarefa.getID() == id) return true;         
        
        return false;
    }
    
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
    
    public static void atualizar(ArrayList<Tarefa> tarefas, long ID, String
    novoTitulo, String novaDescricao, String novoStatus){
        
        for (Tarefa tarefa : tarefas) {
            
            if(tarefa.getID() == ID) {
            
                if(!novoTitulo.trim().equals("0")) tarefa.setTitulo(novoTitulo);
                if(!novaDescricao.trim().equals("0")) tarefa.setDescricao(novaDescricao);
                if(!novoStatus.trim().equals("0")) {
                    
                    if (novoStatus.equals("1")) tarefa.setCompletar(true);
                    else if (novoStatus.equals("2")) tarefa.setCompletar(false);
                }
                
                break;
            }
        }
    }
    
    public static void remover(ArrayList<Tarefa> tarefas, int id) {
        
        tarefas.removeIf(t -> t.getID() == id);
    }
}