package com.example.sbd_tp2_intelij;

import java.sql.Timestamp;

public class Aluguer {


    private String ID_Aluguer;
    private Timestamp Inicio;
    private Timestamp Fim;
    private String Coordenadas_Recolha;
    private String Coordenadas_Entrega;
    private int Custo_Final;
    private int Desconto;
    private String Matricula;
    private int NIF;

    public Aluguer(String ID_Aluguer, Timestamp inicio, Timestamp fim, String coordenadas_Recolha, String coordenadas_Entrega, int custo_Final, int desconto, String matricula, int NIF) {
        this.ID_Aluguer = ID_Aluguer;
        this.Inicio = inicio;
        this.Fim = fim;
        this.Coordenadas_Recolha = coordenadas_Recolha;
        this.Coordenadas_Entrega = coordenadas_Entrega;
        this.Custo_Final = custo_Final;
        this.Desconto = desconto;
        this.Matricula = matricula;
        this.NIF = NIF;
    }
    // Construtor, getters e setters
    public String getID_Aluguer() {
        return ID_Aluguer;
    }
    public void setID_Aluguer(String ID_Aluguer) {
        this.ID_Aluguer = ID_Aluguer;
    }
    public Timestamp getInicio() {
        return Inicio;
    }
    public void setInicio(Timestamp inicio) {
        this.Inicio = inicio;
    }
    public Timestamp getFim() {
        return Fim;
    }
    public void setFim(Timestamp fim) {
        this.Fim = fim;
    }
    public String getCoordenadas_Recolha() {
        return Coordenadas_Recolha;
    }
    public void setCoordenadas_Recolha(String coordenadas_Recolha) {

        this.Coordenadas_Recolha = coordenadas_Recolha;
    }
    public String getCoordenadas_Entrega() {
        return Coordenadas_Entrega;
    }
    public void setCoordenadas_Entrega(String coordenadas_Entrega) {
        this.Coordenadas_Entrega = coordenadas_Entrega;
    }
    public int getCusto_Final() {
        return Custo_Final;
    }
    public void setCusto_Final(int custo_Final) {
        Custo_Final = custo_Final;
    }
    public int getDesconto() {
        return Desconto;
    }
    public void setDesconto(int desconto) {
        Desconto = desconto;
    }
    public String getMatricula() {
        return Matricula;
    }
    public void setMatricula(String matricula) {
        Matricula = matricula;
    }
    public int getNIF() {
        return NIF;
    }
    public void setNIF(int nif) {
        this.NIF = nif;
    }
}

