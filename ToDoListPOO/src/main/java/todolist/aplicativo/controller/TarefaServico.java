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
    
    ArrayList<Tarefa> tarefas = new ArrayList<>();
    int contadorID = 1;
    
    public boolean verificarID(int id) {
        
        if (tarefas.isEmpty()) return false;
    
        for (Tarefa tarefa : tarefas) if (tarefa.getID() == id) return true;         
        
        return false;
    }
    
    public Tarefa criar(String titulo, String descricao){
        
        Tarefa novaTarefa = new Tarefa(contadorID++, titulo, descricao, false);
        
        tarefas.add(novaTarefa);
        
        return novaTarefa;
        
    }
    
    public ArrayList<String> listar(){
        
        if(tarefas.isEmpty()){
            return null;
        }
        
        ArrayList<String> dadosTarefas = new ArrayList<>();
        
        for(Tarefa item: tarefas){
            
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
    
    public void atualizar(long ID, String novoTitulo, String novaDescricao, String novoStatus){
        
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
    
    public void remover(int id) {
        
        tarefas.removeIf(t -> t.getID() == id);
    }
}