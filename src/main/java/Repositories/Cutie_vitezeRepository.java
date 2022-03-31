package Repositories;

import Entitati.Service.Cutie_de_viteze;

import java.util.ArrayList;

public class Cutie_vitezeRepository implements GenericRepository<Cutie_de_viteze>{
    private ArrayList<Cutie_de_viteze> cutii_de_viteze = new ArrayList<Cutie_de_viteze>();

    @Override
    public void add(Cutie_de_viteze entity) {
        cutii_de_viteze.add(entity);
    }

    @Override
    public Cutie_de_viteze get(int id) {
        return cutii_de_viteze.get(id);
    }

    @Override
    public void update(Cutie_de_viteze entity, Cutie_de_viteze newEntity) {
        for(int i=0;i<cutii_de_viteze.size();i++)
        {
            if(cutii_de_viteze.get(i) == entity){
                cutii_de_viteze.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public void delete(Cutie_de_viteze entity) {
        cutii_de_viteze.remove(entity);
    }

    @Override
    public int getSize() {
        return cutii_de_viteze.size();
    }
}
