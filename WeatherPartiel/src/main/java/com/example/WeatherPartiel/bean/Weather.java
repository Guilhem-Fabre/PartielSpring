package com.example.WeatherPartiel.bean;


import io.swagger.annotations.ApiModelProperty;

public class Weather {
    @ApiModelProperty(notes = "Weather's Id", name = "id", required = true, value = "1")
    private int id;
    @ApiModelProperty(notes = "Weather's Nom", name = "nom", required = true, value = "Nice")
    private String nom;
    @ApiModelProperty(notes = "Weather's Code", name = "code", required = true, value = "06000")
    private String code;
    @ApiModelProperty(notes = "Weather's Pays", name = "pays", required = true, value = "France")
    private String pays;
    @ApiModelProperty(notes = "Weather's Meteo", name = "meteo", required = true, value = "soleil")
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
