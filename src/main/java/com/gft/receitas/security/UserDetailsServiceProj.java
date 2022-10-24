package com.gft.receitas.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.receitas.entities.Usuario;
import com.gft.receitas.repositories.UsuarioRepository;

@Service("userDetailsService")
public class UserDetailsServiceProj implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getPrivilegio());
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(authority);
			User user = new User(usuario.getEmail(), usuario.getSenha(), authorities);
			return user;
		}

		return null;
	}

}
