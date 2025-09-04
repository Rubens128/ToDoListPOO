/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package todolist.aplicativo.model;

import java.time.LocalDate;

/**
 *
 * @author ruben
 */

public class Tarefa {

private long id;
  
    private long id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDate dataAgora = LocalDate.now();
    private LocalDate dataConclusao;
    
    public Tarefa(long id, String titulo, String descricao, boolean completa, LocalDate dataAgora) {
        this.Id = id;
        this.Titulo = titulo;
        this.Descricao = descricao;
        this.Completa = false;
        this.DataAgora = dataAgora;
    }
    
    public Tarefa(String titulo, String descricao) {
        this.id = 0;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataCriacao = LocalDate.now();
    }
    /* so para teste */
    public long getID() {
        return id;
    }

    public String getTitulo() {
    	return titulo;
    }
    
    public String getDescricao() {
    	return descricao;
    }
    
    public boolean getComplete() {
    	return completa;
    }
    
    public LocalDate getDataAgora() {
    	return dataAgora;
    }
    
    public String getListarTarefa(String titulo, String descricao) {
        this(titulo, descricao);
    }

    public void completar(boolean Completa){
        this.Completa = true;
    }
    
    public void setID(long id) {
    	this.id = id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setDataAgora(LocalData dataAgora) {
    	this.dataAgora = dataAgora;
    }
    
    public void setCompletar(boolean completa) {
    	this.completa = completa;
    	if (completa) {
    		this.dataConclusao = LocalDate.now();
    	} else {
    		this.dataConclusao = null;
    	}
    }
    
    public void completar() {
    	setCompletar = true;
    }
}
