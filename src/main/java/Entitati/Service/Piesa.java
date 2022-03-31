package Entitati.Service;

import Entitati.Preturi.Preturi;

public class Piesa {
    protected long nr_total_piese;
    protected boolean in_stoc;
    protected String furnizor;
    protected String[] masini_compatibile;
    protected String nume_piesa;
    protected Preturi pret;

    public Piesa() {
        this.nr_total_piese = -1;
        this.in_stoc = false;
        this.furnizor = "";
        this.masini_compatibile = new String[1];
        this.masini_compatibile[0] = "";
        this.nume_piesa = "";
        this.pret = null;
    }
    public Piesa(long nr_total_piese, boolean in_stoc, String furnizor, String[] masini_compatibile, String nume_piesa, Preturi pret)
    {
        this.nr_total_piese = nr_total_piese;
        this.in_stoc = in_stoc;
        this.furnizor = furnizor;
        this.masini_compatibile = masini_compatibile;
        this.nume_piesa = nume_piesa;
        this.pret = pret;
    }

    public long getNr_total_piese() {
        return nr_total_piese;
    }

    public String getFurnizor() {
        return furnizor;
    }

    public String getNume_piesa() {
        return nume_piesa;
    }

    public String[] getMasini_compatibile() {
        return masini_compatibile;
    }

    public boolean getIn_stoc() {
        return in_stoc;
    }

    public Preturi getPret() {
        return pret;
    }

    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }

    public void setIn_stoc(boolean in_stoc) {
        this.in_stoc = in_stoc;
    }

    public void setMasini_compatibile(String[] masini_compatibile) {
        this.masini_compatibile = masini_compatibile;
    }

    public void setNr_total_piese(long nr_total_piese) {
        this.nr_total_piese = nr_total_piese;
    }

    public void setNume_piesa(String nume_piesa) {
        this.nume_piesa = nume_piesa;
    }

    public void setPret(Preturi pret) {
        this.pret = pret;
    }
}

