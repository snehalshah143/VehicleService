package com.snehal.carservice.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

private static final long serialVersionUID = -8091879091924046844L;
private final String jwttoken;

private final Long userId;

public JwtResponse(Long userId,String jwttoken) {
this.jwttoken = jwttoken;
this.userId=userId;
}

public String getToken() {
return this.jwttoken;
}

public Long getUserId() {
	return userId;
}

}
