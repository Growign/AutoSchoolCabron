package co.suo.autoschool.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	Page<UserDto> getAllUsers(Pageable pageable);

	User changeUserInfo(Long id, User userChanges);

	String getUserRole(String email);
}
