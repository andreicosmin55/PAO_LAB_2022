package Entitati.Preturi;

import Entitati.Service.Piesa;

public class Preturi implements Reducere{
    private boolean client_fidel;
    private double pret_piesa;
    private double pret_manopera;

    public Preturi() {
        this.client_fidel = false;
        this.pret_piesa = -1;
        this.pret_manopera = -1;
    }
    public Preturi(boolean client_fidel, double pret_manopera, double pret_piesa) {
        this.client_fidel = client_fidel;
        this.pret_piesa = pret_piesa;
        this.pret_manopera = pret_manopera;
    }

    public double getPret_manopera() {
        return pret_manopera;
    }

    public double getPret_piesa() {
        return pret_piesa;
    }

    public double calculeaza_pret(Piesa piesa){
        Preturi pret = new Preturi();
        double total = 0;
        pret = piesa.getPret();
        total = pret.getPret_piesa() + pret.getPret_manopera();
        return total;
    };

    @Override
    public int calc_reducere(Piesa piesa){
        Preturi pret = piesa.getPret();
        if(piesa.getNume_piesa().equals( "Cutie de viteze") || piesa.getNume_piesa().equals("cutie de viteze"))
            return 15;
        if(pret.getPret_piesa() > 1000)
            return 20;
        if(getPret_manopera() > 1000)
            return 10;
        return 0;
    };
}
