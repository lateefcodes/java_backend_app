/*
 @author: lateef
 @project: digitalashram
 @created: 16/12/2022 - 7:44 pm
 */
package com.digitalashram.users.model;

import com.digitalashram.core.enums.NameTitleType;
import com.digitalashram.core.enums.StatusType;

public class CreateUser {

    /** The user id. */
    private Long userId;

    /** The user name. */
    private String userName;

    /** The role id. */
    private Long roleId;

    /** The role Name. */
    private String roleName;

    /** The status. */
    private StatusType status;

    /** The title. */
    private NameTitleType title;

    /** The first name. */
    private String firstName;

    /** The middle name. */
    private String middleName;

    /** The last name. */
    private String lastName;

    /** The email id. */
    private String emailId;

    /** The phone number. */
    private String phoneNumber;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public NameTitleType getTitle() {
        return title;
    }

    public void setTitle(NameTitleType title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
