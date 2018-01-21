package org.farm.base.configure;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.FacesInitializer;

@Configuration
public class HibernateUtilConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory() {
		if(entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not hibernate");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
	
	@Bean
    public ServletRegistrationBean facesServletRegistration() {

        ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();

        return servletRegistrationBean;
    }

	    public class JsfServletRegistrationBean extends ServletRegistrationBean {

	        public JsfServletRegistrationBean() {
	            super();
	        }

	        @Override
	        public void onStartup(ServletContext servletContext)
	                throws ServletException {

	            FacesInitializer facesInitializer = new FacesInitializer();
	            Set<Class<?>> clazz = new HashSet<Class<?>>();
	            clazz.add(HibernateUtilConfig.class);
	            facesInitializer.onStartup(clazz, servletContext);
	        }
	    }
	
}
