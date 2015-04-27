package com.digitanomad.jsontest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digitanomad.jsontest.vo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JsonController {
	
	@RequestMapping("/")
	public String home(Model model) {
		return "jpgrid";
	}
	
	@RequestMapping(value="/getJson", method=RequestMethod.POST)
	public @ResponseBody Map<?, ?> getJson(Model model) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User("digitanomad", "ÀÌÇõ±â"));
		userList.add(new User("helloWorld", "Çï·Î¿ì¿ùµå"));
		
		result.put("data", userList);
		
		return result;
	}
	
}
