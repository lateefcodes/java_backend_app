package com.abdul.springsecurity.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class BaseEntity.
 */
@MappedSuperclass
public class BaseEntity {

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OID", unique = true, nullable = false)
	private Long oid;

	/** The status. */
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private StatusType status;

	/** The created time. */
	@CreationTimestamp
	@Column(name = "CREATION_TIME", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	/** The modified time. */
	@UpdateTimestamp
	@Column(name = "MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	/** The created by. */
	@Column(name = "CREATED_BY", updatable = false)
	private Long createdBy;

	/** The modified by. */
	@Column(name = "MODIFIED_BY")
	private Long modifiedBy;

	/**
	 * Gets the oid.
	 *
	 * @return the oid
	 */
	public Long getOid() {
		return this.oid;
	}

	/**
	 * Sets the oid.
	 *
	 * @param oid
	 *            the new oid
	 */
	public void setOid(Long oid) {
		this.oid = oid;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public StatusType getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(StatusType status) {
		this.status = status;
	}

	/**
	 * Gets the created time.
	 *
	 * @return the created time
	 */
	@JsonFormat(pattern = "dd-MM-yyyy")
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * Sets the created time.
	 *
	 * @param createdTime
	 *            the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * Gets the modified time.
	 *
	 * @return the modified time
	 */
	@JsonFormat(pattern = "dd-MM-yyyy")
	public Date getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * Sets the modified time.
	 *
	 * @param modifiedTime
	 *            the new modified time
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy
	 *            the new modified by
	 */
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
