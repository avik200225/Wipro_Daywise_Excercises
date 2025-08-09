package com.wipro.hibernatedemo.repo;
	import java.util.List;
	import java.util.Scanner;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.query.Query;
	import com.wipro.hibernatedemo.entity.Pan;
	import com.wipro.hibernatedemo.util.HibernateUtil;

	public class PanRepo {
		
		public static void updatePan() {
		    Scanner sc = new Scanner(System.in);

		    System.out.println("Please enter PAN id");
		    int id = sc.nextInt();

		    // Fetch the existing PAN from DB
		    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    Transaction transaction = session.beginTransaction();

		    Pan existing = session.find(Pan.class, id);
		    if (existing != null) {
		        System.out.println("Please enter new PAN name");
		        String panName = sc.next();
		        System.out.println("Please enter new PAN Number");
		        String panNumber = sc.next();

		        existing.setPanHolderName(panName);
		        existing.setPanNumber(panNumber);
		        transaction.commit();
		        System.out.println("PAN updated successfully.");
		    } else {
		        System.out.println("PAN with ID " + id + " not found.");
		        transaction.rollback();
		    }
		}

		    
		 public static void createPan()
		    {
		    	Scanner sc= new Scanner(System.in); 	    	
		    	System.out.println("Please enter PAN name");
		    	String panName= sc.next();
		    	System.out.println("Please enter PAN Number");
		    	String panNumber= sc.next();
		    	Pan p= new Pan(panName,panNumber);
		    	save(p); 	
		    }
		    //insert and update
		 public static void save(Pan p) {
			    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			    Transaction transaction = session.beginTransaction();

			    if (p.getId() != 0) {
			        Pan existing = session.find(Pan.class, p.getId());
			        existing.setPanHolderName(p.getPanHolderName());
			        existing.setPanNumber(p.getPanNumber());
			        session.persist(existing);
			    } else {
			        session.persist(p);
			    }
			    transaction.commit();
			}

		    
		 public static Pan findById(int id)
		    {
		     	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		    	Transaction transaction=session.beginTransaction();
		    	Pan p=session.find(Pan.class, id);
		    	return p;   	
		    }
		    
		 public static Pan deleteById(int id)
		    {
		     	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		    	Transaction transaction=session.beginTransaction();
		    	Pan p=session.find(Pan.class, id);
		    	session.remove(p);
		    	transaction.commit();
		    	return p;   	
		    }
		    
		 public static List<Pan> findAll() {
			    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			    Transaction transaction = session.beginTransaction();
			    String hqlQuery = "from Pan";
			    Query<Pan> query = session.createQuery(hqlQuery, Pan.class);
			    List<Pan> list = query.list();
			    transaction.commit();
			    return list;
			}

		    
		 public static List<String> findAllPanNames() {
			    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			    Transaction transaction = session.beginTransaction();
			    String hqlQuery = "SELECT panHolderName FROM Pan";
			    Query<String> query = session.createQuery(hqlQuery, String.class);
			    List<String> list = query.list();
			    transaction.commit();
			    return list;
			}

		 public static List<Pan> findByPanNumber(String panNumber) {
			    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			    Transaction transaction = session.beginTransaction();
			    String hqlQuery = "from Pan where panNumber = :pnumber";
			    Query<Pan> query = session.createQuery(hqlQuery, Pan.class);
			    query.setParameter("pnumber", panNumber);
			    List<Pan> list = query.list();
			    transaction.commit();
			    return list;
			}
	}


