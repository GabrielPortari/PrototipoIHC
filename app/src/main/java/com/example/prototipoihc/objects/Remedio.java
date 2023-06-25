package com.example.prototipoihc.objects;

public class Remedio {
    private String nome;
    private String tipo;
    private int hora;
    private int min;

    public Remedio(String nome, String tipo, int hora, int min) {
        this.nome = nome;
        this.tipo = tipo;
        this.hora = hora;
        this.min = min;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
