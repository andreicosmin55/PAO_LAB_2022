package Repositories;

import Entitati.Service.Programare;

import java.util.HashSet;

public class ProgramareRepository implements GenericRepository<Programare>{
    static private HashSet<Programare> programari = new HashSet<Programare>();
    static private Programare[] progr = programari.toArray(new Programare[programari.size()]);
    @Override
    public void add(Programare entity) {
        programari.add(entity);
    }

    @Override
    public Programare get(int id) {
        return progr[id];
    }

    @Override
    public void update(Programare entity, Programare newEntity) {
        for(Programare p :programari){
            if(p == entity){
                p = newEntity;
                return;
            }
        }
    }

    @Override
    public void delete(Programare entity) {
        programari.remove(entity);
    }

    @Override
    public int getSize() {
        return programari.size();
    }
}
