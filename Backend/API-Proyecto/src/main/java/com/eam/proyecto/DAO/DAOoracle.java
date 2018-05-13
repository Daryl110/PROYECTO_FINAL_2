package com.eam.proyecto.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Daryl Ospina
 */
public class DAOoracle implements IDAO{

    private EntityManagerFactory entityManager;

    public DAOoracle(String unidad) {
        this.entityManager = new Conexion(unidad).getFactory();
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManager;
    }

    @Override
    public void setEntityManager(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager getEntityManager() {
        return this.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Object cargar(String nombreClase,String campos) {
        EntityManager manager = null;
        Object lista = null;

        try {
            manager = getEntityManager();
            Query query = manager.createQuery("SELECT "+campos+" FROM "+nombreClase+" p");
            lista = (Object) query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - "+e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }
    
    @Override
    public Object cargar(String nombreClase) {
        EntityManager manager = null;
        Object lista = null;

        try {
            manager = getEntityManager();
            Query query = manager.createQuery("SELECT p FROM "+nombreClase+" p");
            lista = (Object) query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - "+e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }
    
    @Override
    public boolean guardar(Object objeto) {
        EntityManager manager = null;
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return false;
    }
    
    @Override
    public boolean modificar(Object objeto) {
        EntityManager manager = null;
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            manager.merge(objeto);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return false;
    }
    
    @Override
    public Object buscar(Object valorId,Class clase) {
        EntityManager manager = null;
        try {
            manager = getEntityManager();
            return manager.find(clase, valorId);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    @Override
    public boolean eliminar(Object obj,Class clase) {
        EntityManager manager = null;
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            Object objeto = manager.merge(obj);
            manager.remove(objeto);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return false;
    }
}
