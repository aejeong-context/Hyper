package com.min.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.app.dto.User_Dto;
import com.min.app.model.user.User_IService;

@Controller
public class BasicController {

	private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

	@Autowired
	BCryptPasswordEncoder passEncoder;

	@Autowired
	User_IService Uservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(HttpSession session) {
		return "index";
	}

	//테스트
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
		return "redirect:/";
	}
	//로그인
	@RequestMapping(value="/signIn",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> SignIn(String email, String password,HttpSession session) {
		System.out.println("받은 email"+email+"비밀번호"+password);
		User_Dto Ldto = Uservice.signIn(email);
		Map<String, String> map = new HashMap<String, String>();

		if(Ldto != null) {
			boolean passMatch = passEncoder.matches(password,Ldto.getUser_pw());
			if (passMatch) {
				session.setAttribute("Ldto", Ldto);
				map.put("checkl", "true");
				return map;
			}
		}
		map.put("checkl", "false");
		return map;
	}

	//로그아웃

	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
	@RequestMapping(value="/updateSm",method = RequestMethod.POST)
	public String updateSm(User_Dto dto,HttpSession session) {
		return "main";
	}
	//닉네임 변경
	//회원탈퇴
	
	//파일업로드
	@RequestMapping(value = "/fileup",method = RequestMethod.GET)
	public String fileup() {
		return "user/ImageUpload";
	}



}