package com.demo.controllers;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.models.DBConnectivity;
import com.demo.models.Login_Model;
import com.demo.pojo.users;


@Controller
public class LoginController {

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView gotoLogin(HttpServletResponse response, @CookieValue(value="hits",defaultValue="0")Long hits){
		
		ModelAndView mav = new ModelAndView("login");
		
		
	/*	hits++;
		Cookie cookie = new Cookie("hits",hits.toString());
		//cookie.setMaxAge(1000);
		mav.addObject("visits",hits);
		User user = new User();
		mav.addObject("user",user);
		
		response.addCookie(cookie);*/
		
		return mav;
	}
	
	



	@RequestMapping(value="/vishnu", method=RequestMethod.GET, params = {"id"})
	
	public @ResponseBody users goto2Login(HttpServletResponse response, @CookieValue(value="hits",defaultValue="0")Long hits,@RequestParam("id") String name ){
		System.out.println("vishnugt accessed");
		Login_Model loginModel = new Login_Model();
		System.out.println(name);
		//loginModel.validateLogin("", "");
		//loginModel.doHibernateLogin("", "");
		
		users user = new users();
		user.setId(123);
		user.setloginName("gt");
		user.setname("vishnugt");
	//	return user;
		
			try{
			
			DBConnectivity db = new DBConnectivity();
			Statement statement = db.doConnection();
			ResultSet resultSet = statement.executeQuery("select * from users where id=" + name);                                  
			String result = "";
			while(resultSet.next()){
				user.setname(resultSet.getString("name"));
				user.setloginName(resultSet.getString("login_name"));
				user.setId(Integer.parseInt(name));
			}
			System.out.println(result);
			resultSet.close();
			/*
			if(count == 1 ){
				return "success";
			}else{
				return "failed";
			}
			*/
			
			//users ab = new users();
			//user.add("asdf");
			return user;
			
			
		}catch(Exception e){
			return user;
		}
		
		
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String gotoLoginByPost(HttpServletRequest req, Model model, HttpSession session,@Valid users user,BindingResult br){
		try{
			
			int errorCount = br.getAllErrors().size();
			if(errorCount >0){
				return "login";
			}else{
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				System.out.println("username :"+username+ "password :"+password);
				
				Login_Model loginModel = new Login_Model();
				
				
				//Type of login java or hibernate 
				String message = loginModel.validateLogin(username, password);
				//String message = loginModel.doHibernateLogin(username, password);
				System.out.println(message);
				
				if(message.equals("success")){
					session.setAttribute("username", username);
					return "redirect:/myprofile";
				}
				else{
					model.addAttribute("error_msg", message);
				}
				return "login";
			}
			
			
		}catch(Exception e){
			return "login";
		}
		
	}
	
	
}
