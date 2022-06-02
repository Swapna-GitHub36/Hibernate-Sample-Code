package com.gl.hibernateexample.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	/*
	 * Services that need Hibernate
	 */
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			
			try {
				//create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				
				//create MetaDataSources
				MetadataSources sources = new MetadataSources(registry);
				
				//create MetaData
				Metadata metadata = sources.getMetadataBuilder().build();
				
				//create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if(registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

