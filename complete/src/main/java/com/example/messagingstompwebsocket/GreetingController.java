package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	/**
	 * //nếu message sent tới /app/hello thì greeting() sẽ được gọi
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@MessageMapping("/hello")
	/**
	 * đây là kênh được subcribe, mỗi khi response từ method bên dưới sẽ được gửi tên kênh này,
	 * 	tất cả các client subcribe /top/greetings đều nhận được response.
	 */
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
