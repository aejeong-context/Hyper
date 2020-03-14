package com.min.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.app.dto.User_Dto;
import com.min.app.model.user.User_IService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	BCryptPasswordEncoder passEncoder;

	@Autowired
	User_IService Uservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	//이메일 중복 체크
	@RequestMapping(value = "/checkemail",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkEmail(String email){
		Map<String, String> map = new HashMap<String, String>();
		//null or 사용불가
		String checke = Uservice.emailCheck(email);
		logger.info("mailcheck 결과 : \t{} ",checke);
		map.put("checke", checke+"");
		return map;
	}
	//닉네임 중복 체크
	@RequestMapping(value = "/checknick",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkNick(String nick){
		Map<String, String> map = new HashMap<String, String>();
		//null or 사용불가
		String checkn = Uservice.nckCheck(nick);
		logger.info("nick 결과 : \t{} ",checkn);
		map.put("checkn", checkn+"");
		return map;
	}
	//회원가입
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String Register(User_Dto dto) {
		String inputPass = dto.getUser_pw();
		String pass = passEncoder.encode(inputPass);
		dto.setUser_pw(pass);
		boolean isc = Uservice.signUp(dto);
		logger.info("register 결과",isc);
		return "/";
	}
	//로그인
	@RequestMapping(value="/signIn",method = RequestMethod.POST)
	public String SignIn(User_Dto dto,HttpSession session) {
		System.out.println(dto);
		User_Dto Ldto = Uservice.signIn(dto.getUser_email());
		System.out.println(Ldto);
		if(Ldto != null) {
			boolean passMatch = passEncoder.matches(dto.getUser_pw(),Ldto.getUser_pw());
			if(passMatch == true) {
				session.setAttribute("Ldto", Ldto);
				return "main";
			}else {
				return "/";
			}
		}
		return "/";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public  String logout(HttpSession session) {

		User_Dto Ldto  = (User_Dto)session.getAttribute("Ldto");
		if(Ldto!=null) {
			logger.info("로그아웃될것임");
			session.removeAttribute("Ldto");
			return "main";
		}
		return "/";
		
	}
	
	
}