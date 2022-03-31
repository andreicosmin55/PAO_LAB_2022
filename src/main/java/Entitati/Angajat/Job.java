package Entitati.Angajat;

public class Job {
    private String nume_job;
    private double salariu_minim;
    private double salariu_maxim;
    private short nr_maxim_angajati;
    private boolean sunt_locuri_libere;

    public Job() {
        this.nume_job = "";
        this.salariu_maxim = -1;
        this.salariu_minim = -1;
        this.nr_maxim_angajati = -1;
        this.sunt_locuri_libere = false;
    }

    public Job(String nume_job, double salariu_maxim, double salariu_minim, short nr_maxim_angajati, boolean sunt_locuri_libere) {
        this.nume_job = nume_job;
        this.salariu_maxim = salariu_maxim;
        this.salariu_minim = salariu_minim;
        this.nr_maxim_angajati = nr_maxim_angajati;
        this.sunt_locuri_libere = sunt_locuri_libere;
    }

    public double getSalariu_maxim() {
        return salariu_maxim;
    }

    public double getSalariu_minim() {
        return salariu_minim;
    }

    public short getNr_maxim_angajati() {
        return nr_maxim_angajati;
    }

    public String getNume_job() {
        return nume_job;
    }

    public boolean getSunt_locuri_libere() {
        return sunt_locuri_libere;
    }

    public void setNr_maxim_angajati(short nr_maxim_angajati) {
        this.nr_maxim_angajati = nr_maxim_angajati;
    }

    public void setNume_job(String nume_job) {
        this.nume_job = nume_job;
    }

    public void setSalariu_maxim(double salariu_maxim) {
        this.salariu_maxim = salariu_maxim;
    }

    public void setSalariu_minim(double salariu_minim) {
        this.salariu_minim = salariu_minim;
    }

    public void setSunt_locuri_libere(boolean sunt_locuri_libere) {
        this.sunt_locuri_libere = sunt_locuri_libere;
    }
}
