package co.suo.autoschool.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper = UserMapper.INSTANCE;

	@Override
	public Page<UserDto> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable).map(userMapper::toDto);
	}

	@Override
	public User changeUserInfo(Long id, User userChanges) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setEmail(_user.getEmail());
			_user.setPassword(_user.getPassword());
			_user.setActive(userChanges.isActive());
			_user.setRole(userChanges.getRole());
			return userRepository.save(_user);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public String getUserRole(String email) {
		Optional<User> userData = userRepository.findByEmail(email);
		return userData.get().getRole().toString();
	}
}
