package br.com.pokemon.dao;

import br.com.pokemon.model.Pokemon;
import br.com.pokemon.util.conexao.FabricaConexao;
import br.com.pokemon.util.exception.ErroSistema;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PokemonDao implements Dao<Pokemon> {

    private EntityManager manager;

    public PokemonDao(EntityManager manager) {
        this.manager = manager;
    }

    private void inicializar() {
        if (manager == null)
            this.manager = new FabricaConexao().createEntityManager();
    }

    @Override
    public List<Pokemon> findAll() throws ErroSistema {
        inicializar();
        try {
            return manager.createQuery("Select u from Pokemon u ").getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar pokemons", ex);
        }
    }

    @Override
    public Pokemon findById(Long id) throws ErroSistema {
        inicializar();
        try {
            Query query = manager.createQuery("Select u from Pokemon u where u.id = :pid");
            query.setParameter("pid", id);
            return (Pokemon) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar pokemon por id", ex);
        }
    }

    @Override
    public List<Pokemon> findByName(String name) throws ErroSistema {
        inicializar();
        try {
            Query query = manager.createQuery("Select u from Pokemon u where upper(u.nome) like :pnome");
            query.setParameter("pnome", "%" + name.toUpperCase() + "%");
            return query.getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar buscar pokemon por nome", ex);
        }
    }

    @Override
    public boolean save(Pokemon t) throws ErroSistema {
        inicializar();
        try {
            if (t.getId() != null) {
                manager.merge(t);
            } else {
                manager.persist(t);
            }
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar salvar o pokemon", ex);
        }
        return true;
    }

    @Override
    public boolean delete(Pokemon t) throws ErroSistema {
        inicializar();
        try {
            manager.remove(t);
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar remover o pokemon", ex);
        }
        return true;
    }
}
