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
public class DAOLogin {
    public List<TblUser> getBy(String uName, String uPass) {
        TblUser us = new TblUser(); //instantiasi objek baru di dalam method TBLUser()
        /*List dibawah digunakan untuk mendapatkan data dari method TBLUser() 
        di class TBLUser, untuk mendapatkan data yang diinput ke user dan memasukkannya
        ke dalam array.*/ 
        List<TblUser> user = new ArrayList(); //variable ini akan menjadi return untuk fungsi public list

        Transaction trans = null;
        //Interface koneksi ke db
        Session session = atlasUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where username= :uName AND password= :uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (TblUser) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }    
    
}
