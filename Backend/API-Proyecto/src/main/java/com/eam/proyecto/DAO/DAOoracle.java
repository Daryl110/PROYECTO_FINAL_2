package com.eam.proyecto.DAO;

import com.eam.proyecto.util.Herramientas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author Daryl Ospina
 */
public class DAOoracle implements IDAO {

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
    public Object cargar(String nombreClase, String campos) {
        EntityManager manager = null;
        Object lista = null;

        try {
            manager = getEntityManager();
            Query query = manager.createQuery("SELECT " + campos + " FROM " + nombreClase + " p");
            lista = (Object) query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - " + e);
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
            Query query = manager.createQuery("SELECT p FROM " + nombreClase + " p");
            lista = (Object) query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }

    @Override
    public Response guardar(Object objeto) {
        EntityManager manager = null;
        JSONObject objRespuesta = new JSONObject();
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
            objRespuesta.put("Resultado", true);
            return Herramientas.construirResponse(objRespuesta.toString());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        objRespuesta.put("Resultado", false);
        return Herramientas.construirResponse(objRespuesta.toString());
    }

    @Override
    public Response modificar(Object objeto) {
        EntityManager manager = null;
        JSONObject objRespuesta = new JSONObject();
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            manager.merge(objeto);
            manager.getTransaction().commit();
            objRespuesta.put("Resultado", true);
            return Herramientas.construirResponse(objRespuesta.toString());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        objRespuesta.put("Resultado", false);
        return Herramientas.construirResponse(objRespuesta.toString());
    }

    @Override
    public Object buscar(Object valorId, Class clase) {
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
    public Response eliminar(Object obj, Class clase) {
        EntityManager manager = null;
        JSONObject objRespuesta = new JSONObject();
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            Object objeto = manager.merge(obj);
            manager.remove(objeto);
            manager.getTransaction().commit();
            objRespuesta.put("Resultado", true);
            return Herramientas.construirResponse(objRespuesta.toString());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        objRespuesta.put("Resultado", false);
        return Herramientas.construirResponse(objRespuesta.toString());
    }
}
