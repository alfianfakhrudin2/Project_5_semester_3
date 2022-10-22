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
import pojojo.TblUser;
import pojojo.atlasUtil;

/**
 *
 * @author Alfian Fakhrudin
 */
public class DAOAdmin {
    public List<TblUser> retrieveTblAdmin(){
        List stud = new ArrayList();
        TblUser stud1 = new TblUser();
        
        Transaction trans = null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser");
            stud = query.list();
            stud.add(stud1.getId());
            stud.add(stud1.getUsername());
            stud.add(stud1.getPassword());
            
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return stud;
    }    
    
        public List<TblUser> getbyID1(int adm)
    {
        TblUser admn = new TblUser();
        List<TblUser> admn2 = new ArrayList();
       
        Transaction trans=null;
        Session session = atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from TblUser where id= :id");
            query.setInteger("id", adm);
            admn=(TblUser)query.uniqueResult();
            admn2=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admn2;
    }

    public void adminUpdate(TblUser admin)
    {
        Transaction trans=null;
        Session session= atlasUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(admin);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        
    }
}
