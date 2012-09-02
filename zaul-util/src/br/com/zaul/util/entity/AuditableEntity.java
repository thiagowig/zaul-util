package br.com.zaul.util.entity;

import java.util.Calendar;

public interface AuditableEntity {

	User getAuthorChange();
	
	Calendar getDate();
	
	Long getVersion();
}
