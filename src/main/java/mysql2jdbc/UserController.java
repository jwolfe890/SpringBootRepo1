package mysql2jdbc;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mysql2jdbc.jdbcclasses.UserRest;
import mysql2jdbc.jdbcclasses.UserService;
import mysql2jdbc.jdbcclasses.UserDetailsRequest;
import mysql2jdbc.jdbcclasses.UserDto;

@RestController   
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
		@RequestMapping(path="/getReq")
		public String something() {
			return "hello from something";
		}
	
	
//	   @CrossOrigin(origins = "http://localhost:3000")
	    @PostMapping(path="/postMethod")
	    public UserRest createUser(@RequestBody UserDetailsRequest userDetails) {	
	    	UserRest returnValue = new UserRest();
	    	
	    	UserDto userDto = new UserDto();
	        BeanUtils.copyProperties(userDetails, userDto);
	    	
	    	UserDto createdUser = userService.createUser(userDto);
	    	BeanUtils.copyProperties(createdUser, returnValue);
	    	
	    	return returnValue;
	    	
	    }

}