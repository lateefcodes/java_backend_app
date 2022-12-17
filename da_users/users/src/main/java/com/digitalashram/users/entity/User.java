/*
 @author: lateef
 @project: digitalashram
 @created: 16/12/2022 - 6:50 pm
 */
package com.digitalashram.users.entity;

import com.digitalashram.core.entity.BaseEntity;

import javax.persistence.*;




@Entity
@Table(name = "da_user", uniqueConstraints = @UniqueConstraint(columnNames = "USER_ALIAS"))
public class User extends BaseEntity {

    /** The user name. */
    @Column(name = "USER_ALIAS")
    private String userName;

    /** The password. */
    @Column(name = "PASSWORD")
    private String password;

    /** The user profile. */
//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
//    private UserProfile userProfile;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public UserProfile getUserProfile() {
//        return userProfile;
//    }
//
//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }
}
