package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.entity.User;
import com.zensar.repository.UserRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> userName2 = userRepository.findByUserName(username);
		if(userName2==null) {
			throw new UsernameNotFoundException("User is not available!!");
		}
		
		User user1 = userName2.get(0);
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(user1.getRoles()));
		return new org.springframework.security.core.userdetails.User(username, user1.getPassword(),authority);
	}

}
