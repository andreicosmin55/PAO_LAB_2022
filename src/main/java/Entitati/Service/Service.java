package Entitati.Service;

import Entitati.Angajat.Angajat;

import java.util.ArrayList;

public class Service {
    private String nume;
    private String an_infiintare;
    private ArrayList<Angajat> angajati;

    public Service() {
        this.nume = "";
        this.an_infiintare = "-1";
        this.angajati = null;
    }

    public Service(String nume, String an_infiintare, ArrayList<Angajat> angajati) {
        this.nume = nume;
        this.an_infiintare = an_infiintare;
        this.angajati = angajati;
    }

    public String getNume() {
        return nume;
    }

    public ArrayList<Angajat> getAngajati() {
        return angajati;
    }

    public String getAn_infiintare() {
        return an_infiintare;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAn_infiintare(String an_infiintare) {
        this.an_infiintare = an_infiintare;
    }

    public void setAngajati(ArrayList<Angajat> angajati) {
        this.angajati = angajati;
    }
}
