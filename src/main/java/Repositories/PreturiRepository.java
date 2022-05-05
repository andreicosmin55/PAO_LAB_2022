package Repositories;

import Entitati.Preturi.Preturi;

import java.util.ArrayList;

public class PreturiRepository implements GenericRepository<Preturi>{
    static private ArrayList<Preturi> preturi = new ArrayList<Preturi>();
    @Override
    public void add(Preturi entity) {
        preturi.add(entity);
    }

    @Override
    public Preturi get(int id) {
        return preturi.get(id);
    }

    @Override
    public void update(Preturi entity, Preturi newEntity) {
        for(int i=0;i< preturi.size();i++){
            if(preturi.get(i) == entity){
                preturi.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public void delete(Preturi entity) {
        preturi.remove(entity);
    }

    @Override
    public int getSize() {
        return preturi.size();
    }
}
