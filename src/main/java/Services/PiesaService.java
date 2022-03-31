package Services;

import Entitati.Preturi.Preturi;
import Entitati.Service.Piesa;
import Exceptii.InvalidDataException;
import Repositories.PiesaRepository;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.ArrayList;
import java.util.List;

public class PiesaService {
    private PiesaRepository piesaRepository = new PiesaRepository();

    public void adaugaPiesa(long nr_total_piese, boolean in_stoc, String furnizor, String[] masini_compatibile, String nume_piesa, Preturi pret) {

        Piesa piesa = new Piesa(nr_total_piese, in_stoc, furnizor, masini_compatibile, nume_piesa, pret);
        piesaRepository.add(piesa);
    }

    public Piesa[] AfiseazaToatePiesele(){
        List<Piesa> result = new ArrayList<Piesa>();
        for(int i=0;i<piesaRepository.getSize();i++){
            result.add(piesaRepository.get(i));
        }
        return result.toArray(new Piesa[0]);
    }
    public Piesa[] AfiseazaPieseleDeLaFurnizorul(String furnizor){
        List<Piesa> result = new ArrayList<Piesa>();
        for(int i=0;i<piesaRepository.getSize();i++){
            if(piesaRepository.get(i).getFurnizor().equals(furnizor)) {
                result.add(piesaRepository.get(i));
            }
        }
        return result.toArray(new Piesa[0]);
    }
}
