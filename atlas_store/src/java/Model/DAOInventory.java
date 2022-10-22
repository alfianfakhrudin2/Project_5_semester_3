/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojojo.TblBarang;
import pojojo.atlasUtil;

/**
 *
 * @author Alfian Fakhrudin
 */
public class DAOInventory {
    public List<TblBarang> retrieveTblBarang() {
        List<TblBarang> item = new ArrayList();
        Transaction trans = null;
        
        Session session = atlasUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblBarang");
            item = query.list();
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }   
    
        public List<TblBarang> getbyID1(int adm)
    {
        TblBarang admn = new TblBarang();
        List<TblBarang> admn2 = new ArrayList();
       
        Transaction trans = null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from TblBarang where barang_id= :id");
            query.setInteger("id", adm);
            admn=(TblBarang)query.uniqueResult();
            admn2=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admn2;
    }
        
        public void invUpdate(TblBarang inve)
    {
        Transaction trans = null;
        Session session= atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(inve);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }
        public void addInv(TblBarang invy){
        Transaction transaction = null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(invy);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        public void deleteInv(int IDemp)
    {
        Transaction trans = null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            TblBarang iv = (TblBarang)session.load(TblBarang.class, new Integer(IDemp));
            session.delete(iv);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
