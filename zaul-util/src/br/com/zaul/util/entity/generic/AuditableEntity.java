package br.com.zaul.util.entity.generic;

import java.util.Calendar;

import br.com.zaul.util.entity.impl.User;

public interface AuditableEntity {

	User getAuthorChange();
	
	Calendar getDate();
	
	Long getVersion();
}
