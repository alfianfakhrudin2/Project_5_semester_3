/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojojo.atlasUtil;
import pojojo.TblEmploye;

@ManagedBean
/**
 *
 * @author Alfian Fakhrudin
 */
public class DAOEmploye {
    
    public List<TblEmploye> retrieveTblEmployes(){
        List stud = new ArrayList();
        TblEmploye stud1 = new TblEmploye();
        
        Transaction trans = null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblEmploye");
            stud = query.list();
            stud.add(stud1.getEmployeId());
            stud.add(stud1.getEmployeName());
            stud.add(stud1.getEmployeAddress());
            
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return stud;
    }    
    
        public List<TblEmploye> getbyID1(int adm)
    {
        TblEmploye admn = new TblEmploye();
        List<TblEmploye> admn2 = new ArrayList();
       
        Transaction trans=null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from TblEmploye where id= :id");
            query.setInteger("id", adm);
            admn=(TblEmploye)query.uniqueResult();
            admn2=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admn2;
    }
        
        public void empUpdate(TblEmploye empi)
    {
        Transaction trans = null;
        Session session= atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(empi);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }
        
    public void addEmply(TblEmploye empyo){
        Transaction transaction = null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(empyo);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        
        public void deleteEmply(int IDemp)
    {
        Transaction trans=null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            TblEmploye kar = (TblEmploye)session.load(TblEmploye.class, new Integer(IDemp));
            session.delete(kar);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
