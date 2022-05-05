package Services;

import Entitati.Angajat.Angajat;
import Entitati.Angajat.Job;
import Exceptii.InvalidDataException;
import Repositories.AngajatRepository;

import java.util.ArrayList;
import java.util.List;

public class AngajatService {
    private AngajatRepository angajatRepository = new AngajatRepository();

    public void adaugaUnAngajat(String nume, String prenume, double vechime, String pozitie, boolean functie_conducere, Job job) {

        Angajat angajat = new Angajat(nume, prenume, vechime, pozitie, functie_conducere, job);
        angajatRepository.add(angajat);
    }
    public Angajat[] afiseazaAngajatii() {
        List<Angajat> result = new ArrayList<Angajat>();
        for (int i = 0; i < angajatRepository.getSize(); i++) {
                result.add(angajatRepository.get(i));
        }
        return result.toArray(new Angajat[0]);
    }

    public Angajat[] afiseazaAngajatiCuVechimePeste3Ani(){
        List<Angajat> result = new ArrayList<Angajat>();
        for(int i=0;i<angajatRepository.getSize();i++){
            if(angajatRepository.get(i) != null && angajatRepository.get(i).getVechime() >= 3){
                result.add(angajatRepository.get(i));
            }
        }
        return result.toArray(new Angajat[0]);
    }
}
