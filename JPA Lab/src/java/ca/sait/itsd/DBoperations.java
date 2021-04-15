/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;

/**
 *
 * @author john, jonghyun Park
 * @version Nov 11, 2020
 * 
 */
public class DBoperations {

    public String getInCartItems() {

        String result = new String();

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT l FROM Listitems l WHERE l.listitemincart = true";
        TypedQuery<Listitems> listitemincart = em.createQuery(jpql, Listitems.class);

        List<Listitems> inCartitems;

        try {

            inCartitems = listitemincart.getResultList();

            for (Listitems l : inCartitems) {
                result = result + l.getListitemid() + "," + l.getListitemdesc() + ";";
            }
        } finally {
            em.close();
        }

        return result;
    }

    public String getNotInCartItems() {

        String result = new String();

        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String jpql = "SELECT l FROM Listitems l WHERE l.listitemincart = false";
        TypedQuery<Listitems> listitemincart = em.createQuery(jpql, Listitems.class);

        List<Listitems> inCartitems;

        try {

            inCartitems = listitemincart.getResultList();

            for (Listitems l : inCartitems) {
                result = result + l.getListitemid() + "," + l.getListitemdesc() + ";";
            }
        } finally {
            em.close();
        }

        return result;
    }

    public boolean addListItem(String listItem) {

        boolean result = false;

        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();

            em.persist(new Listitems(0L, listItem, false));

            trans.commit();

            result = true;

        } catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return result;
    }

    public boolean deleteListItem(int itemID) {
        boolean result = false;

        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();

            Listitems listItem = (Listitems) em.createNamedQuery("Listitems.findByListitemid").setParameter("listitemid", itemID).getSingleResult();
            em.remove(listItem);

            trans.commit();

            result = true;
        } catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return result;
    }

    public boolean toggleInCartStatus(int itemID) {
        boolean result = false;

        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();

            Listitems listItem = (Listitems) em.createNamedQuery("Listitems.findByListitemid").setParameter("listitemid", itemID).getSingleResult();
            
            if(listItem.getListitemincart() == true) {
                
                listItem.setListitemincart(false);
            
            } else {
            
                listItem.setListitemincart(true);
            
            }

            em.persist(listItem);

            trans.commit();

            result = true;
        } catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return result;
    }

}
