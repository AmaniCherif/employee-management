package org.acme.entity.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//for login endpoint
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class  AuthRequest {
	
	public String username;
	public String password;
}

