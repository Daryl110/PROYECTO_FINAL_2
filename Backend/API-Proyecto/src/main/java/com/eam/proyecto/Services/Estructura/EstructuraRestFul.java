/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.Estructura;

import com.eam.proyecto.DAO.DAOoracle;
import com.eam.proyecto.DAO.IDAO;
import java.util.List;

/**
 *
 * @author Daryl Ospina
 */
public abstract class EstructuraRestFul<T> {

    private final Class<T> entityClass;
    protected IDAO dao = new DAOoracle("ConexioonBD");

    public EstructuraRestFul(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        dao.guardar(entity);
    }

    public void edit(T entity) {
        dao.getEntityManagerFactory().createEntityManager().merge(entity);
    }

    public void remove(T entity) {
        dao.eliminar(entity, entityClass);
    }

    public T find(Object id) {
        return (T) dao.buscar(id, entityClass);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return dao.getEntityManagerFactory().createEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = dao.getEntityManagerFactory().createEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = dao.getEntityManagerFactory().createEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
