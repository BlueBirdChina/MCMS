package com.core.model;

import java.util.Date;

public interface Object {

	public String getOid();

	public void setOid(String oid);

	public Date getCreatedOn();

	public void setCreatedOn(Date createdOn);

	public String getCreatedBy();

	public void setCreatedBy(String createdBy);

	public Date getUpdatedOn();

	public void setUpdatedOn(Date updatedOn);

	public String getUpdatedBy();

	public void setUpdatedBy(String updatedBy);

}