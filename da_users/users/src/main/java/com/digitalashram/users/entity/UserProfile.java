/*
 @author: lateef
 @project: digitalashram
 @created: 16/12/2022 - 6:54 pm
 */
package com.digitalashram.users.entity;

import com.digitalashram.core.enums.GenderEnum;
import com.digitalashram.core.enums.NameTitleType;
import com.digitalashram.core.enums.StatusType;
import com.digitalashram.core.enums.UserType;
import com.digitalashram.role.entity.Role;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "da_user_profile")
public class UserProfile {

    /** The oid. */
    @GenericGenerator(name = "entity.userProfileIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
    @Id
    @GeneratedValue(generator = "entity.userProfileIdGenerator")
    @Column(name = "OID", unique = true, nullable = false)
    private Long oid;

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

    /** The status. */
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    /** The user type. */
    @Column(name = "USER_TYPE", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    /** The title. */
    @Column(name = "TITLE")
    @Enumerated(EnumType.STRING)
    private NameTitleType titleType;

    /** The first name. */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /** The middle name. */
    @Column(name = "MIDDLE_NAME")
    private String middleName;

    /** The last name. */
    @Column(name = "LAST_NAME")
    private String lastName;

    /** The full name. */
    @Column(name = "FULL_NAME")
    private String fullName;

    /** The email id. */
    @Column(name = "EMAIL_ID")
    private String emailId;

    /** The phone number. */
    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    /** The phone number. */
    @Column(name = "MOBILE_NUMBER")
    private String phoneNumber;

    /** The role. */
    @ManyToOne
    @JoinColumn(name = "ROLE_OID", nullable = true)
    private Role role;

    /** The gender. */
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    /** The dateOfBirth. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    /** The address. */
    @Column(name = "ADDRESS")
    private String address;

    /** The profileImage. */
    @Column(name = "PROFILE_IMAGE")
    private String profileImage;

    /** The dobUpdateCount. */
    @Column(name = "DOB_UPDATE_COUNT")
    private Integer dobUpdateCount;


    /** The lastLoginTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /** The lastActiveTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_ACTIVE_TIME")
    private Date lastActiveTime;

    /** The forgotPasswordTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FORGOT_PASSWORD_TIME")
    private Date forgotPasswordTime;

    @Column(name = "IS_EMAIL_VERIFIED")
    private Boolean isEmailVerified;


}
