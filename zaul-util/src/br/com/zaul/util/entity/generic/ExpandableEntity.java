package br.com.zaul.util.entity.generic;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import br.com.zaul.util.entity.impl.User;

@MappedSuperclass
public abstract class ExpandableEntity implements GenericEntity, AuditableEntity {

	@ManyToOne
	private User authorChange;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Calendar date;
	@Version
	private Long version;
	
	/**
	 * 
	 * @return
	 */
	public boolean isNew() {
		
		if (this.getId() == null) {
			return true;
		}
		
		return false;
	}

	public User getAuthorChange() {
		return authorChange;
	}

	public void setAuthorChange(User authorChange) {
		this.authorChange = authorChange;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	

	
	
}
