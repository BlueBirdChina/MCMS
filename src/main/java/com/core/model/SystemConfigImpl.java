package com.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "com.jx.core.model.SystemConfigImpl")
@Table(name = "System_Config")
public class SystemConfigImpl extends ObjectImpl implements SystemConfig {

	@Column(length = 128)
	private String name;

	@Column(length = 512)
	private String description;

	@Type(type = "yes_no")
	private boolean inited;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getInited() {
		return inited;
	}

	public void setInited(Boolean inited) {
		this.inited = inited;
	}

}
