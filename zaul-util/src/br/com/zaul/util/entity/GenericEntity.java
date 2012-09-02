package br.com.zaul.util.entity;

import java.io.Serializable;

public interface GenericEntity extends Serializable {
	
	Object getId();

	String toString();
	
	int hashCode();
	
	boolean equals(Object obj);
	
}
