package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * Class 단독 매핑
 */
@Controller
@RequestMapping("/guestbook")
public class GuestController {

	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "GuestController : list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public String delete() {
		return "GuestController : delete";
	}

}
