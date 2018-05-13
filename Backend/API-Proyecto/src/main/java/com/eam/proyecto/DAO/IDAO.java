/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DAO;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Daryl Ospina
 */
public interface IDAO<T> {
    
    public abstract Object cargar(String nombreClase,String campos);
    public abstract Object cargar(String nombreClase);
    public abstract boolean guardar(Object objeto);
    public abstract boolean modificar(Object objeto);
    public abstract Object buscar(Object valorId,Class<T> clase);
    public abstract boolean eliminar(Object valorId,Class<T> clase);
    public abstract EntityManagerFactory getEntityManagerFactory();
    public abstract void setEntityManager(EntityManagerFactory entityManager);
}
