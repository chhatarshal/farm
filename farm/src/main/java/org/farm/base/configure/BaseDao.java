package org.farm.base.configure;

import java.util.List;

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
