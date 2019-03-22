package net.chinaedu.security.demo.datasource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import net.chinaedu.security.demo.security.SecurityUser;
import net.chinaedu.security.demo.security.UserType;

public class UserDataSource {

	public static List<SecurityUser> userList = Arrays.asList(
		new SecurityUser("admin", "admin", 0, UserType.ADMIN),
		new SecurityUser("user", "user", 0, UserType.USER),
		new SecurityUser("other", "other", 0, UserType.OTHER),
		new SecurityUser("bad", "bad", 1, UserType.OTHER)
	);

	public static SecurityUser getSecurityUser(String id) {
		Optional<SecurityUser> optional = userList.parallelStream()
			.filter(i -> i.getId().equalsIgnoreCase(id))
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
}
