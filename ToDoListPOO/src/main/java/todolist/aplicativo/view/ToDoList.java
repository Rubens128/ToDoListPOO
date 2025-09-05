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
    
    TarefaServico servico = new TarefaServico();
    
    int escolha = 0;
    
    
    while(escolha != 7) {
        System.out.println("### ToDo List ###\n" +
                           "1. Cadastrar tarefa\n" +
                           "2. Listar tarefas\n" +
                           "3. Editar tarefa\n" +
                           "4. Excluir tarefa\n" +
                           "5. Pesquisar tarefa\n" +
                           "6. Tarefas concluidas\n" +
                           "7. Sair\n" +
                           "Digite o número correspondente à sua escolha: ");
        escolha = scan.nextInt();
        scan.nextLine();
    
        switch (escolha) {
            case 1:
                System.out.println("###################################");
                System.out.println("\nInsira o título da tarefa: ");
                String titulo = scan.nextLine();
                System.out.println("Insira a descrição da tarefa: ");
                String descricao = scan.nextLine();
                
                Tarefa novaTarefa = servico.criar(titulo, descricao);
                
                System.out.printf("Tarefa adicionada com sucesso! Titulo: %s\n", novaTarefa.getTitulo());
                System.out.println("###################################");
                
                break;
            
            case 2:
                System.out.println("###################################");
                System.out.println("\nTarefas Cadastradas:");
                
                ArrayList<String> registros = servico.listar();
                
                if (registros == null) {
                    System.out.println("Nenhuma tarefa encontrada.\n");
                    
                } else {
                  
                    for(String registro: registros){
                        
                        System.out.printf("%s", registro);
                    }
                }
                
                System.out.println("###################################");

                break;
                
            case 3:
                
                int escolhaID = 0;
                
                System.out.println("###################################");
                System.out.println("\nDigite o ID da tarefa que deseja editar: ");
                escolhaID = scan.nextInt();
                scan.nextLine();

                if(!servico.verificarID(escolhaID)){
                
                    System.out.println("Tarefa não encontrada!\n");
                    break;
                }
                
                System.out.println("\nDIGITE 0 PARA OS ATRIBUTOS QUE NÃO DESEJA ALTERAR");
                
                System.out.println("\nNovo titulo: ");
                String novoTitulo = scan.nextLine();
                
                System.out.println("\nNova descrição: ");
                String novaDescricao = scan.nextLine();
                
                System.out.println("\nNovo status (1 - Para concluida, 2 - Para não concluida): ");
                String novoStatus = scan.nextLine();
                
                servico.atualizar(escolhaID, novoTitulo, novaDescricao, novoStatus);
                System.out.println("###################################");

                
                break;
                
            case 4:
                System.out.println("###################################");
                System.out.println("\nDigite o ID da tarefa que deseja excluir: ");
                int excluirID = scan.nextInt();
                scan.nextLine();
                
                if(!servico.verificarID( excluirID)){
                
                    System.out.println("Tarefa não encontrada!\n");
                    break;
                    
                } else {
                    
                    servico.remover( excluirID);
                    System.out.println("Tarefa removida com sucesso!\n");
                }
                System.out.println("###################################");                

                break;
                
            case 5:
                System.out.println("###################################");
                System.out.println("\nDigite o ID da tarefa que deseja pesquisar: ");
                int pesquisarID = scan.nextInt();
                scan.nextLine();
                
                if(!servico.verificarID( pesquisarID)){
                
                    System.out.println("Tarefa não encontrada!\n");
                    break;
                    
                } else {
                    
                    System.out.println("Tarefa encontrada com sucesso:");
                    System.out.println(servico.exibir(pesquisarID));   
                    
                }
                System.out.println("###################################");
  
                break;
                
            case 6:
                System.out.println("###################################");
                System.out.println("\nTarefas Concluidas:");
                
                ArrayList<String> registrosConcluidas = servico.listarConcluidas();
                
                if (registrosConcluidas == null) {
                    System.out.println("Nenhuma tarefa concluida.\n");
                    
                } else {
                  
                    for(String registro: registrosConcluidas){
                        
                        System.out.printf("%s", registro);
                    }
                }
                
                System.out.println("###################################");

                break;
            
            case 7:
                System.out.println("Saindo...");
                
                break;
                
            default:
                System.out.println("Opção inválida.\n");
        }
    
    }

    }
}
