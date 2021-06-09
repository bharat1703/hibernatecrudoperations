package com.prasad;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Main {

	public static void main(String[] args) {
		// saveempdata();
		// getalldetails();
		//deleteemp(11);
		// updateempdetails(7,33333);
         	getmaxsalary();
		
		
	/*	 List<Employee> listobj1= getalldetails(); 
		for(Employee obj : listobj1)
		 {
		System.out.println("the details are : "+obj);
		
		 
		 }*/
			 
	/*		      if(obj.getEmpsal()< 1000000)
		     {                                                 //if you want to add condition then add here
		 updateempdetails(obj.getId(),obj.getEmpsal()+100);   
		  }
		 }*/
		 
		 /*	for (Object obj : listobj1) {
					Employee dstudentobj = (Employee)obj;            //if you use criteria query in displayall(),then you have to this
					System.out.println("details  :" + dstudentobj);  //On this case you have to downcast it

				}*/

			 
		 }

	private static void getmaxsalary() {
		
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		
		CriteriaBuilder builder=session.getCriteriaBuilder(); 
		  CriteriaQuery<Employee> criteriaquery=builder.createQuery(Employee.class);
		  Root<Employee> root=criteriaquery.from(Employee.class);
		
		  criteriaquery.multiselect(builder.max(root.get("empsal")));
		  Query query=session.createQuery(criteriaquery);   
		
		
		
	  tx.commit();
		session.close();
		
		
	}

	private static void updateempdetails(int id, int salary) {
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee empobj = session.get(Employee.class, id);
			System.out.println("Before updating empsal : " + empobj);
			empobj.setEmpsal(salary);
			session.saveOrUpdate(empobj);
			System.out.println("After updating empsal : " + empobj);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (tx.getStatus() != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
			
	}

	private static List<Employee> getalldetails() {
		System.out.println("Inside getalldetails");
		Session session = getSession();
		Transaction tx = null;
	 	tx=session.beginTransaction();
	/*	Query query = session.createQuery("from Employee"); 
		 List<Employee> detailslist=query.getResultList(); 
	 	  	tx.commit();
		session.close();
	  return detailslist;*/
	 			
	 /*	CriteriaBuilder builder=session.getCriteriaBuilder(); 
		  CriteriaQuery<Employee> criteriaquery=builder.createQuery(Employee.class);
		  Root<Employee> root=criteriaquery.from(Employee.class);
		 criteriaquery.select(root);                                                //select can be used to view all details
		 // criteriaquery.select(root).where(builder.equal(root.get("empexp"),3));  //we can select specific features also
		  Query query=session.createQuery(criteriaquery); 
		 List<Employee> detailslist=query.getResultList(); 
	 	  tx.commit();
		session.close();
	  return detailslist;
	*/

	  
	  /*	    Criteria criteria = session.createCriteria(Employee.class);
		//criteria.add(Restrictions.like("empname","prasa%"));  
	  //  criteria.add(Restrictions.between("empsal", 10000, 200000));  
	    criteria.add(Restrictions.like("empname","prasa%"));
	    criteria.add(Restrictions.lt("empsal",30000));
	    
		List criterialist = criteria.list();
		tx.commit();
		session.close();
		return criterialist;
   */
	  
	  return null; 
	
	}

	private static void deleteemp(int i) {
		System.out.println("Inside deleteemp");
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Employee empobj = new Employee();
		empobj.setId(i);
		session.delete(empobj);
		tx.commit();
		session.close();
		System.out.println("deletion is sucessful");
	}

	private static void saveempdata() {
		System.out.println("Inside saveEmpdata");
		Session session = getSession();
		session.beginTransaction();
		Employee empobj = new Employee("prasanna", 20000, 24, 1);

		session.save(empobj);
		System.out.println("outside saveEmpdata");

		session.getTransaction().commit();
		session.flush();
		session.close();

	}

	
	
	private static Session getSession() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

}
