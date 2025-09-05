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
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDate dataAgora;
    private LocalDate dataConclusao;
    
    public Tarefa(long id, String titulo, String descricao, boolean completa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataAgora = LocalDate.now();
        this.dataConclusao = null;
    }
    
    public Tarefa(String titulo, String descricao) {
        this.id = 0;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataAgora = LocalDate.now();
        this.dataConclusao = null;
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
    
    public LocalDate getDataConclusao() {
    	return dataConclusao;
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
    
    public void setDataAgora(LocalDate dataAgora) {
    	this.dataAgora = dataAgora;
    }

    public void setDataConclusao(LocalDate dataConclusao){
        this.dataConclusao = dataConclusao;    
    }
    
    public void setCompletar(boolean completa) {
    	this.completa = completa;
    	if (completa) {
    		this.dataConclusao = LocalDate.now();
    	} else {
    		this.dataConclusao = null;
    	}
    }
}