package pl.lukasziwon.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukasziwon.UserRepository;
import pl.lukasziwon.io.entity.UserEntity;
import pl.lukasziwon.service.UserService;
import pl.lukasziwon.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
		
	@Override
	public UserDto createUser(UserDto user) {
		
		
		
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already exist in database");
		
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("Somo ID");
		userEntity.setUserId("userID");
		userEntity.setEmailVerificationStatus(false);
		
		
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails,returnValue);
		
		return returnValue;
	}

}
