package net.chinaedu.security.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {
	private static final long serialVersionUID = 6335854663226475256L;
	/** 账号 */
    private String id;
    /** 密码 */
    private String pw;
    /** 状态 */
    private Integer status;
    /** 用户权限 */
    private UserType userType;

    public SecurityUser(String id, String pw, Integer status, UserType userType) {
		super();
		this.id = id;
		this.pw = pw;
		this.status = status;
		this.userType = userType;
	}

	public SecurityUser() {
		super();
	}

    // 用户类型-权限（spring security权限默认会以ROLE_开头，所以注册时候得加上ROLE_）
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<SimpleGrantedAuthority>();
		simpleAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.userType.toString()));
		return simpleAuthorities;
	}
 
	@Override
	public String getPassword() {
		return this.pw;
	}
	@Override
	public String getUsername() {
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
