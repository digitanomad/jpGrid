package com.digitanomad.gridtest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.digitanomad.gridtest.service.UserService;
import com.digitanomad.gridtest.service.UserServiceExcelUploader;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserServiceExcelUploader userServiceExcelUploader;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "jqgrid";
	}
	
	@RequestMapping(value = "/getJson", method = RequestMethod.POST)
	public @ResponseBody Map<?, ?> getJson() {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("data", userService.getUserList());
		
		return result;
	}
	
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		
		// excel view resolver에 의해 resolve될 view를 리턴
		return new ModelAndView("excelView", "userList", userService.getUserList());
	}
	
	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public ModelAndView uploadExcel(MultipartHttpServletRequest request) {
		MultipartFile file = request.getFile("excelUploadFile");
		
		userServiceExcelUploader.uploadExcelFile(file);
		
		return new ModelAndView("jqgrid");
	}
}
