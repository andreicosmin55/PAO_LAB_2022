package Entitati.Angajat;

public class Angajat {
    protected String nume;
    protected String prenume;
    protected double vechime;
    protected String pozitie;
    protected boolean functie_conducere;
    protected Job job;

    public Angajat()
    {
        this.nume = "";
        this.prenume = "";
        this.vechime = -1;
        this.pozitie = "";
        this.functie_conducere = false;
        this.job = new Job();
    }
    public Angajat(String nume, String prenume, double vechime, String pozitie, boolean functie_conducere, Job job)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.vechime = vechime;
        this.pozitie = pozitie;
        this.functie_conducere = functie_conducere;
        this.job = job;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public double getVechime() {
        return vechime;
    }

    public Job getJob() {
        return job;
    }

    public String getPozitie() {
        return pozitie;
    }

    public boolean getFunctie_conducere(){
        return functie_conducere;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setVechime(double vechime) {
        this.vechime = vechime;
    }

    public void setFunctie_conducere(boolean functie_conducere) {
        this.functie_conducere = functie_conducere;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    public void setJob(Job job) {
        this.job = job;
    }


}
