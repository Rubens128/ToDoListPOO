/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist.aplicativo.view;

import todolist.aplicativo.model.Tarefa;
import java.util.Scanner;
import java.util.ArrayList;
import todolist.aplicativo.controller.TarefaServico;

/**
 *
 * @author ruben
 */
public class ToDoList {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Tarefa> tarefas = new ArrayList<>();
    int contadorID = 1;
    int escolha = 0;
    
    
    while(escolha != 6) {
        System.out.println("### ToDo List ###\n" +
                           "1. Cadastrar tarefa\n" +
                           "2. Visualizar tarefas\n" +
                           "3. Editar tarefa\n" +
                           "4. Excluir tarefa\n" +
                           "5. Marcar tarefa como concluida\n" +
                           "6. Sair\n" +
                           "Digite o número correspondente à sua escolha: ");
        escolha = scan.nextInt();
        scan.nextLine();
    
        switch (escolha) {
            case 1:
                System.out.println("\nInsira o título da tarefa: ");
                String titulo = scan.nextLine();
                System.out.println("Insira a descrição da tarefa: ");
                String descricao = scan.nextLine();
                
                TarefaServico.criar(tarefas, titulo, descricao, contadorID);
                
                contadorID++;
                
                System.out.println("Tarefa adicionada com sucesso!");
                
                break;
            
            case 2:
                System.out.println("\nTarefas Cadastradas:");
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa encontrada.");
                } else {
                    ArrayList<String> registros = TarefaServico.listar(tarefas);
                    
                    for(String registro: registros){
                        
                        System.out.printf("%s", registro);
                    
                    }
                    
                }
                break;
                
            case 3:
                System.out.println("\nDigite o ID da tarefa que deseja editar: ");
                long escolhaID = scan.nextInt();
                scan.nextLine();
                
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa encontrada.");
                } else {
                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.getID() == escolhaID) {
                            System.out.println("Insira um novo título para a tarefa: ");
                            String novoTitulo = scan.nextLine();
                        
                            System.out.println("Insira uma nova descrição para a tarefa: ");
                            String novaDescricao = scan.nextLine();
                        
                            tarefa.setTitulo(novoTitulo);
                            tarefa.setDescricao(novaDescricao);
                            
                            System.out.println("Tarefa editada com sucesso!");
                        }
                    }
                }  
                
                break;
                
            case 4:
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa encontrada.");
                    break;
                }
                
                System.out.println("\nDigite o ID da tarefa que deseja excluir: ");
                long excluirID = scan.nextInt();
                scan.nextLine();
                
                for (Tarefa tarefa : tarefas) {
                        if (tarefa.getID() == excluirID) {
                        
                            tarefas.remove(tarefa);
                            
                            System.out.println("Tarefa excluida com sucesso!");
                        }
                        else {
                            System.out.println("Tarefa não encontrada.");
                        }
                    }
                break;
            
            case 5:
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa encontrada");
                    break;
                }
                
                System.out.println("\nDigite o ID da tarefa que deseja concluir: ");
                long concluirID = scan.nextInt();
                scan.nextLine();
                
                for (Tarefa tarefa : tarefas) {
                        if (tarefa.getID() == concluirID) {
                        
                            tarefa.setCompletar(true);
                            
                            System.out.println("Tarefa concluida com sucesso!");
                        }
                        else {
                            System.out.println("Tarefa não encontrada.");
                        }
                    }
                
                break;
                
            case 6:
                System.out.println("Saindo...");
                
                break;
                
            default:
                System.out.println("Opção inválida.");
        }
    
    }
    
    }
}