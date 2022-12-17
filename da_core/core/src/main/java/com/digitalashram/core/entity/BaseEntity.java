/*
 @author: lateef
 @project: digitalashram
 @created: 16/12/2022 - 6:24 pm
 */
package com.digitalashram.core.entity;

import com.digitalashram.core.enums.StatusType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
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

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
