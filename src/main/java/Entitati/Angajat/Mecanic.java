package Entitati.Angajat;

public class Mecanic extends Angajat {
    String[] ce_masini_poate_repara;
    boolean are_curs_profesional;
    double rating_clienti;

    public Mecanic(){
        super();
        this.ce_masini_poate_repara = new String[1];
        this.ce_masini_poate_repara[0] = "";
        this.are_curs_profesional = false;
        this.rating_clienti = -1;

    }

    public Mecanic(String nume, String prenume, double vechime, String pozitie, boolean functie_conducere, Job job, String[] ce_masini_poate_repara, boolean are_curs_profesional, double rating_clienti){
        super(nume, prenume, vechime, pozitie, functie_conducere, job);
        this.ce_masini_poate_repara = new String[ce_masini_poate_repara.length];
        this.ce_masini_poate_repara = ce_masini_poate_repara;
        this.are_curs_profesional = false;
        this.rating_clienti = -1;
    }

    public double getRating_clienti() {
        return rating_clienti;
    }

    public String[] getCe_masini_poate_repara() {
        return ce_masini_poate_repara;
    }

    public boolean getAre_curs_profesional() {
        return are_curs_profesional;
    }

    public void setAre_curs_profesional(boolean are_curs_profesional) {
        this.are_curs_profesional = are_curs_profesional;
    }

    public void setCe_masini_poate_repara(String[] ce_masini_poate_repara) {
        this.ce_masini_poate_repara = ce_masini_poate_repara;
    }

    public void setRating_clienti(double rating_clienti) {
        this.rating_clienti = rating_clienti;
    }
}
