package com.blog.apis.service.ipl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entities.User;
import com.blog.apis.exceptions.*;
import com.blog.apis.payloads.UserDto;
import com.blog.apis.repositoy.UserRepositoy;
import com.blog.apis.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositoy userRepositoy;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUser(userDto);
		User saveUser = this.userRepositoy.save(user);
		return this.userToUserDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepositoy.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepositoy.save(user);
		UserDto userDto1 = this.userToUserDto(updateUser);
		
		return userDto1;
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepositoy.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepositoy.findAll();
		List<UserDto> userDto = users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepositoy.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		this.userRepositoy.delete(user);
		
	}

	public User userDtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		//User user = new User();
		
		/*user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());*/
		return user;
		
	}

	public UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		/*
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		*/
		return userDto;
		
	}

		
}
