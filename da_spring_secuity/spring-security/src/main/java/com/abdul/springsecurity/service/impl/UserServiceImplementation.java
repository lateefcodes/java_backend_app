package com.abdul.springsecurity.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abdul.springsecurity.entity.User;
import com.abdul.springsecurity.repository.UserRepository;
import com.abdul.springsecurity.service.UserService;
import com.abdul.springsecurity.util.StatusType;

@Service(value = "userDetailsService")
@Transactional
public class UserServiceImplementation implements UserDetailsService,UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImplementation.class);
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException {
	 * 
	 * return null; }
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public UserDetails loadUserByUsername(String userName) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet();
		try {
			User user = userRepository.findByUserName(userName);
			if (user == null) {
				throw new UsernameNotFoundException("Invalid username or password.");
			}
			/*
			 * if (null != user.getUserProfile() && null !=
			 * user.getUserProfile().getPermissions() &&
			 * !user.getUserProfile().getPermissions().isEmpty()) { for (Permissions
			 * permissions : user.getUserProfile().getPermissions()) {
			 * grantedAuthorities.add(new
			 * SimpleGrantedAuthority(permissions.getAuthorityTitle())); } }
			 */
			if (StatusType.OFFLINE.equals(user.getStatus())) {
				return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
						false, true, true, true, grantedAuthorities);
			} else {
				return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
						grantedAuthorities);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	
	public ResponseEntity<Object> getUserByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" })
	 * 
	 * @Override public ResponseEntity<Object> loadUserByUsername(String userName,
	 * String password,String deviceId) { Set<GrantedAuthority> grantedAuthorities =
	 * new HashSet(); try { return new ResponseEntity<>(getAccessToken(userName,
	 * CansCrypt.decrypt(password),deviceId).getBody(), HttpStatus.OK); } catch
	 * (Exception e) { logger.error("", e); } return null; }
	 * 
	 * ResponseEntity<String> getAccessToken(String userName, String password,
	 * String deviceId) { RestTemplate restTemplate = new RestTemplate();
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * headers.set("Authorization", appAuthenticationHeader); HttpEntity<String>
	 * entity = new HttpEntity<>("", headers); String authURL = appAuthenticationUrl
	 * + "?grant_type=password&username=" + userName + "&password=" + password+
	 * "&device_id=" + deviceId;
	 * logger.info(">>authURL SM app>"+authURL.toString()); return
	 * restTemplate.postForEntity(authURL, entity, String.class); }
	 */


}
