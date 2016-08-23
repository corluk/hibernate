package com.blogspot.aknowakowski;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.model.Address;
import com.test.model.Employee;
import com.test.model.Model1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory;
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	org.hibernate.Transaction tx = session.beginTransaction(); 
    	Employee employee1 = new Employee();
    	Address address1 = new Address(); 
    	address1.setAddress("test adress 1" );
    	employee1.setName("first emplyee");
    	
    	employee1.setAddress(address1);
    	session.saveOrUpdate(address1);
    	session.saveOrUpdate(employee1);
    	List<Model1> model1List = session.createCriteria(Model1.class).list();
    	for(Model1 m1 : model1List){
    		System.out.println("model 1 :" +m1.getName() );
    	}
    	Model1 model1=  new Model1(); 
    	// model1.setId(new Long(1));
    	model1.setName("test name updated !");
    	session.saveOrUpdate(model1);
    	 
    	Model1 model2 = new Model1();
    	
     	model2.setName("model 2");
    	session.saveOrUpdate(model2);
    	tx.commit();
    	session.close();
        System.out.println( "Hello World!" );
    }
}
