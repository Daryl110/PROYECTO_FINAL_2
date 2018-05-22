/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.Estructura;

import com.eam.proyecto.DAO.DAOoracle;
import com.eam.proyecto.DAO.IDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daryl Ospina
 */
public abstract class EstructuraRestFul<T> {

    private final Class<T> entityClass;
    protected IDAO dao = new DAOoracle("ConexionBD");

    public EstructuraRestFul(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Response guardar(T entity) {
        return dao.guardar(entity);
    }

    public Response modificar(T entity) {
        return dao.modificar(entity);
    }

    public Response eliminar(T entity) {
        return dao.eliminar(entity, entityClass);
    }

    public T buscar(Object id) {
        return (T) dao.buscar(id, entityClass);
    }

    public List<T> listar() {
        try {
            EntityManager manager = dao.getEntityManagerFactory().createEntityManager();
            javax.persistence.criteria.CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return manager.createQuery(cq).getResultList();
        } catch (Exception e) {
            System.out.println("[Error] : " + e);
            return new ArrayList<>();
        }
    }

    public List<T> buscarRango(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = dao.getEntityManagerFactory().createEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(dao.getEntityManagerFactory().createEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = dao.getEntityManagerFactory().createEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
