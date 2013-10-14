/**
 * 
 */
package com.publisher.admin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

/**
 * @author brajbhar
 *
 */

public class BaseDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @return session
	 */
	public Session getCurrentSession(){
		
		return SessionFactoryUtils.getSession(sessionFactory, true);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
