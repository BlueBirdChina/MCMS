package com.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class ObjectImpl implements Object {

	// @Id
	// @GeneratedValue(generator = "hilo")
	// @GenericGenerator(name = "hilo", strategy = "hilo")
	// @Column(name = "id", nullable = false)
	// @Id
	// @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	// @GeneratedValue(generator = "hibernate-uuid")
	// @Column(name = "id", nullable = false)
	@Id
	@Column(unique = true, length = 36, nullable = false)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	protected String oid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(length = 8)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(length = 8)
	private String updatedBy;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#getCreatedOn()
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#setCreatedOn(java.util.Date)
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#getCreatedBy()
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#setCreatedBy(java.lang.String)
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#getUpdatedOn()
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#setUpdatedOn(java.util.Date)
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#getUpdatedBy()
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jx.core.model.Object#setUpdatedBy(java.lang.String)
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
