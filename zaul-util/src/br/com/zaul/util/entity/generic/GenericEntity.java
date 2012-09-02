package br.com.zaul.util.entity.generic;

import java.io.Serializable;

public interface GenericEntity extends Serializable {
	
	Object getId();

	String toString();
	
	int hashCode();
	
	boolean equals(Object obj);
	
}
