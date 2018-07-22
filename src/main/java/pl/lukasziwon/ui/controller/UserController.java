package pl.lukasziwon.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.lukasziwon.service.UserService;
import pl.lukasziwon.shared.dto.UserDto;
import pl.lukasziwon.ui.model.request.UserDetailsRequestModel;
import pl.lukasziwon.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/{id}")
	public UserRest getUser(@PathVariable String id) {

		UserRest returnValue = new UserRest();
		UserDto userDto = userService.getUserByUserID(id);
		BeanUtils.copyProperties(userDto,returnValue);

		return returnValue;
		}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createUser ,returnValue);
		
		return returnValue;
		
		
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
