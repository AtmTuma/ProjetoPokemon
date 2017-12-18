package br.com.pokemon.dao;

import br.com.pokemon.model.Ataque;
import br.com.pokemon.util.conexao.FabricaConexao;
import br.com.pokemon.util.exception.ErroSistema;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AtaqueDao implements Dao<Ataque> {

    private EntityManager manager;

    public AtaqueDao(EntityManager manager) {
        this.manager = manager;
    }

    private void inicializar() {
        if (manager == null)
            this.manager = new FabricaConexao().createEntityManager();
    }

    @Override
    public List<Ataque> findAll() throws ErroSistema {
        inicializar();
        try {
            return manager.createQuery("Select u from Ataque u ").getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar ataques", ex);
        }
    }

    @Override
    public Ataque findById(Long id) throws ErroSistema {
        inicializar();
        try {
            Query query = manager.createQuery("Select u from Ataque u where u.id = :pid");
            query.setParameter("pid", id);
            return (Ataque) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar ataque por id", ex);
        }
    }

    @Override
    public List<Ataque> findByName(String name) throws ErroSistema {
        inicializar();
        try {
            Query query = manager.createQuery("Select u from Atque u where upper(u.nome) like :pnome");
            query.setParameter("pnome", "%" + name.toUpperCase() + "%");
            return query.getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar ataque por nome", ex);
        }
    }

    @Override
    public boolean save(Ataque t) throws ErroSistema {
        inicializar();
        try {
            if (t.getId() != null) {
                manager.merge(t);
            } else {
                manager.persist(t);
            }
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar salvar o ataque", ex);
        }
        return true;
    }

    @Override
    public boolean delete(Ataque t) throws ErroSistema {
        inicializar();
        try {
            manager.remove(t);
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar remover o ataque", ex);
        }
        return true;
    }
}
