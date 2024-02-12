package in.anil.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to, String subject, String body) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setSubject(subject);
		mailMessage.setTo(to);
		mailMessage.setText(body);
		
		javaMailSender.send(mailMessage);
		
		return true;
	}

}
