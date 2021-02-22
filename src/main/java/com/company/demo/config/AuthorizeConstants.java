package com.company.demo.config;

public interface AuthorizeConstants {

	public final static String HAS_ROLE_ADMIN 			= "hasRole('ROLE_ADMIN')";
	public static final String HAS_ROLE_ADMIN_AND_USER 	= "hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')";
}
