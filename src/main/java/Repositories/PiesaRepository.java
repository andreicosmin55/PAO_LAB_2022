package Repositories;

import Entitati.Service.Piesa;

import java.time.Period;
import java.util.ArrayList;

public class PiesaRepository implements GenericRepository<Piesa>{

    static private ArrayList<Piesa> piese = new ArrayList<Piesa>();
    @Override
    public void add(Piesa entity) {
        piese.add(entity);
    }

    @Override
    public Piesa get(int id) {
        return piese.get(id);
    }

    @Override
    public void update(Piesa entity, Piesa newEntity) {
        for(int i=0;i< piese.size();i++){
            if(piese.get(i) == entity){
                piese.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public void delete(Piesa entity) {
        piese.remove(entity);
    }

    @Override
    public int getSize() {
        return piese.size();
    }
}
