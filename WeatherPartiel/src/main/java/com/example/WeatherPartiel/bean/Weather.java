package com.example.WeatherPartiel.bean;


public class Weather {
    private int id;
    private String nom;
    private String code;
    private String pays;
    private String meteo;

    public Weather(int id, String nom,String code,String pays,String meteo ){
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.pays = pays;
        this.meteo = meteo;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public String getPays() {
        return pays;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                ", pays='" + pays + '\'' +
                ", meteo='" + meteo + '\'' +
                '}';
    }
}
