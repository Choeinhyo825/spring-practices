package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVo;

/*
 *  RequestMapping
 *  Class + Method
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = { "/join", "/j" }, method = RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/*
		 * 만약 n의 이름을 가진 파라미터가 없다? 400 Bad Request 오류 발생
		 */
		System.out.println(name);
		return "userController : update";
	}

	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value = "n", required = true, defaultValue = "홍길동") String name,
			@RequestParam(value = "a", required = true, defaultValue = "0") int age) {
		/*
		 * required는 true가 기본값 flase를 주면 파라미터가 없어도 에러가 안남! 만약 n의 이름을 가진 파라미터가 없다? null을
		 * 넘겨줌 근데 defaultValue를 주면 그 값이 들어감! required=true 이지만 기본값을 지정해줬으니 에러 안남
		 */
		System.out.println("----" + name + "----");
		System.out.println("----" + age + "----");
		return "userController : update2";
	}

}
