package org.farm.base.configure;

import java.util.List;
import java.util.Map;

import org.farm.base.jsf.viewbeans.Record;
import org.farm.base.jsf.viewbeans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void createEntity(Object object,Class className) {
		if(object instanceof User) {
			User user=(User)object;
			Session session=sessionFactory.openSession();
			session.save(user);
			session.flush();
			session.close();
		} 
		if(object instanceof Record) {
			Record record=(Record)object;
			Session session=sessionFactory.openSession();
			session.saveOrUpdate(record);
			session.flush();
			session.close();
		}		
	}
	
	public List findByProperties(Map<String,Object> properties,Class className) {
		String query="from "+className.getSimpleName();
		if(properties != null && properties.size()>0) {
			query=query+" where ";
			for(Map.Entry<String, Object> entry:properties.entrySet()) {
				query=query+" "+entry.getKey()+"=";
					if(entry.getValue() instanceof String) {
						query=query+"'"+entry.getValue()+"'";
					} else if(entry.getValue() instanceof Integer) {
						query=query+entry.getValue();
					}
			}
			System.out.println("Query:=>   "+query);
			Session session=sessionFactory.openSession();
			return session.createQuery(query).list();
		}
		return null;
	}
	
	public List<User> loadAllEntities(Object object) {
		if(object instanceof User) {
			Session session=sessionFactory.openSession();
			List<User> users=(List<User>) session.createQuery("from User").list();
			return users;
		}
		return null;
	}
	
	public List<Record> loadAllRecord() {
		Session session=sessionFactory.openSession();
		List<Record> records=(List<Record>) session.createQuery("from Record").list();
		session.close();
		return records;
	}
	

}
