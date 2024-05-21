package com.estudos.projecspringboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("say-hello")
public class SayHellouController {

	@GetMapping
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	@GetMapping("html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> Pagina teste</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<p>Pagina teste</p>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

	@GetMapping("jsp")
	public String sayHelloJsp() {
		return "sayhello";
	}

}
