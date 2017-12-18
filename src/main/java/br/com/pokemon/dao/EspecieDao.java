package br.com.pokemon.dao;

import br.com.pokemon.model.Especie;
import br.com.pokemon.util.conexao.FabricaConexao;
import br.com.pokemon.util.exception.ErroSistema;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EspecieDao implements Dao<Especie> {

    private EntityManager manager;

    public EspecieDao(EntityManager manager) {
        this.manager = manager;
    }

    private void inicializar() {
        if (manager == null)
            this.manager = new FabricaConexao().createEntityManager();
    }

    @Override
    public List<Especie> findAll() throws ErroSistema {
        inicializar();
        try {
            return manager.createQuery("Select u from Especie u ").getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar especies", ex);
        }
    }

    @Override
    public Especie findById(Long id) throws ErroSistema {
        inicializar();
        try {
            Query query = manager.createQuery("Select u from Especie u where u.id = :pid");
            query.setParameter("pid", id);
            return (Especie) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar especie por id", ex);
        }
    }

    @Override
    public List<Especie> findByName(String name) throws ErroSistema {
        inicializar();
        try {
            Query query = manager.createQuery("Select u from Especie u where upper(u.nome) like :pnome");
            query.setParameter("pnome", "%" + name.toUpperCase() + "%");
            return query.getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar especie por nome", ex);
        }
    }

    @Override
    public boolean save(Especie t) throws ErroSistema {
        inicializar();
        try {
            if (t.getId() != null) {
                manager.merge(t);
            } else {
                manager.persist(t);
            }
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar salvar o especie", ex);
        }
        return true;
    }

    @Override
    public boolean delete(Especie t) throws ErroSistema {
        inicializar();
        try {
            manager.remove(t);
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar remover o especie", ex);
        }
        return true;
    }
}
