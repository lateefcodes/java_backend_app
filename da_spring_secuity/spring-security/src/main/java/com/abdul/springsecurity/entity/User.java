package com.abdul.springsecurity.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.abdul.springsecurity.util.BaseEntity;


/**
 * The Class User.
 */
@Entity
@Table(name = "rp_user", uniqueConstraints = @UniqueConstraint(columnNames = "USER_ALIAS"))
public class User extends BaseEntity {

	/** The user name. */
	@Column(name = "USER_ALIAS")
	private String userName;

	/** The password. */
	@Column(name = "PASSWORD")
	private String password;

	/** The user profile. */
	/*
	 * @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade =
	 * CascadeType.ALL) private UserProfile userProfile;
	 */

	/** The password. */
	@Column(name = "QUICK_PIN")
	private String quickPin;
	
	/** The Web password. */
	@Column(name = "WEB_PASSWORD")
	private String webPassword;
	
	@Column(name = "PRIMARY_QUICK_PIN")
	private String primaryQuickPin;
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user profile.
	 *
	 * @return the user profile
	 */
	/*
	 * public UserProfile getUserProfile() { return userProfile; }
	 */

	/**
	 * Sets the user profile.
	 *
	 * @param userProfile the new user profile
	 */
	/*
	 * public void setUserProfile(UserProfile userProfile) { this.userProfile =
	 * userProfile; }
	 */

	/**
	 * Gets the quickPin.
	 *
	 * @return the quickPin
	 */
	public String getQuickPin() {
		return quickPin;
	}

	/**
	 * Sets the quickPin.
	 *
	 * @param quickPin the new quickPin
	 */
	public void setQuickPin(String quickPin) {
		this.quickPin = quickPin;
	}

	/**
	 * @return the webPassword
	 */
	public String getWebPassword() {
		return webPassword;
	}

	/**
	 * @param webPassword the webPassword to set
	 */
	public void setWebPassword(String webPassword) {
		this.webPassword = webPassword;
	}

	public String getPrimaryQuickPin() {
		return primaryQuickPin;
	}

	public void setPrimaryQuickPin(String primaryQuickPin) {
		this.primaryQuickPin = primaryQuickPin;
	}
}
