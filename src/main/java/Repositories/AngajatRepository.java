package Repositories;

import Entitati.Angajat.Angajat;

import java.util.ArrayList;
import java.util.List;

public class AngajatRepository implements GenericRepository<Angajat> {
    static private ArrayList<Angajat> angajati = new ArrayList<Angajat>();
    @Override
    public void add(Angajat entity) {
        angajati.add(entity);
    }

    @Override
    public Angajat get(int id) {
        return angajati.get(id);
    }

    @Override
    public void update(Angajat entity, Angajat newEntity) {
        for(int i=0;i<angajati.size();i++){
            if(angajati.get(i) == entity)
                angajati.set(i, newEntity);
            return;
        }
    }

    @Override
    public void delete(Angajat entity) {
        angajati.remove(entity);
    }

    @Override
    public int getSize() {
        return angajati.size();
    }

}
