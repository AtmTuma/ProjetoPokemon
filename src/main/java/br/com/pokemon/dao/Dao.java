package br.com.pokemon.dao;

import br.com.pokemon.util.exception.ErroSistema;

import java.util.List;

public interface Dao<T> {
    public List<T> findAll() throws ErroSistema;

    public T findById(Long id) throws ErroSistema;

    public List<T> findByName(String name) throws ErroSistema;

    public boolean save(T t) throws ErroSistema;

    public boolean delete(T t) throws ErroSistema;
}
