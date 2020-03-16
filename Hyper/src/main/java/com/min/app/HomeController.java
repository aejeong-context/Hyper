package com.min.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.validation.BindingResult;
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
	public String home() {
		return "redirect:/index";
	}
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(HttpSession session) {
		User_Dto Ldto  = (User_Dto)session.getAttribute("Ldto");
		System.out.println(Ldto);
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
		System.out.println("받은 dto"+dto);
		User_Dto Ldto = Uservice.signIn(dto.getUser_email());
		if(Ldto != null) {
			boolean passMatch = passEncoder.matches(dto.getUser_pw(),Ldto.getUser_pw());
			if(passMatch == true) {
				session.setAttribute("Ldto", Ldto);
				System.out.println("로그인성공이다요");
				return "user/main";
			}else {
				System.out.println("야래야래 비밀번호 틀렸다고네!");
			}
		}
		return "redirect:/";
	}

	//로그아웃

	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public  String logout(HttpSession session) {
		User_Dto Ldto = (User_Dto)session.getAttribute("Ldto");
		System.out.println(session.getAttribute("세션 무효화 전"+"Ldto"));
		if(Ldto!=null) {
			//session.removeAttribute("Ldto");
			session.invalidate();
			return "redirect:/";
		}
		return "user/main";
	}
	//비밀번호 변경
	@RequestMapping(value = "/pwChange",method = RequestMethod.POST)
	public String resetPw(User_Dto dto,HttpSession session) {
		System.out.println(dto);

		User_Dto Ldto = (User_Dto)session.getAttribute("Ldto");
		if(Ldto!=null) {
			String inputPass = dto.getUser_pw();
			String pass = passEncoder.encode(inputPass);
			Ldto.setUser_pw(pass);
			boolean isc =Uservice.resetPw(Ldto);
			if(isc) {
				logger.info("비밀번호 변경된다");
				return "redirect:/";
			}
		}

		return "redirect:/";
	}
	//상태메세지 변경
	@RequestMapping(value="./updateSm",method = RequestMethod.POST)
	public String updateSm(User_Dto dto,HttpSession session) {
		return "main";
	}
	//닉네임 변경
	//회원탈퇴



}