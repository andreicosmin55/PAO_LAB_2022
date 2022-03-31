package Entitati.Service;

import Entitati.Preturi.Preturi;

public class Cutie_de_viteze extends Piesa{

    private boolean hidramata;
    private int nr_viteze;
    private String masina_compatibila;
    private char pentru_benzina_diesel_sau_eletrica;

    public Cutie_de_viteze() {
        super();
        this.hidramata = false;
        this.nr_viteze = -1;
        this.masina_compatibila = "";
        this.pentru_benzina_diesel_sau_eletrica = '!';
    }

    public Cutie_de_viteze(long nr_total_piese, boolean in_stoc, String furnizor, String[] masini_compatibile, String nume_piesa, Preturi preturi, boolean hidramata, int nr_viteze, String masina_compatibila, char pentru_benzina_diesel_sau_eletrica)
    {
        super(nr_total_piese, in_stoc, furnizor, masini_compatibile, nume_piesa, preturi);
        this.hidramata = hidramata;
        this.nr_viteze = nr_viteze;
        this.masina_compatibila = masina_compatibila;
        this.pentru_benzina_diesel_sau_eletrica = pentru_benzina_diesel_sau_eletrica;
    }

    public int getNr_viteze() {
        return nr_viteze;
    }

    public String getMasina_compatibila() {
        return masina_compatibila;
    }

    public char getPentru_benzina_diesel_sau_eletrica() {
        return pentru_benzina_diesel_sau_eletrica;
    }

    public boolean getHidramata() {
        return getHidramata();
    }

    public void setHidramata(boolean hidramata) {
        this.hidramata = hidramata;
    }

    public void setPentru_benzina_diesel_sau_eletrica(char pentru_benzina_diesel_sau_eletrica) {
        this.pentru_benzina_diesel_sau_eletrica = pentru_benzina_diesel_sau_eletrica;
    }

    public void setNr_viteze(int nr_viteze) {
        this.nr_viteze = nr_viteze;
    }

    public void setMasina_compatibila(String masina_compatibila) {
        this.masina_compatibila = masina_compatibila;
    }
}
