package com.kleens.db.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class SendConfirmationEmail {
	private JavaMailSender javaMailSender;
	@Autowired
	public  SendConfirmationEmail(JavaMailSender javaMailSender ) {
		this.javaMailSender= javaMailSender;
		
	}
	public void sendNotification(String user,String username ,String AuthKey)throws MailException {
		
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user);
		System.out.println("User===>"+user);
		mail.setFrom("kleensman8080@gmail.com");
		mail.setSubject("Email Account Verification");
		mail.setText("Dear "+ username+","+" \n Welcome to Kleensman services "+"\n This is your Activation Key: "+AuthKey);
		javaMailSender.send(mail);
	}
	
	
	// AutoGeneratePassword email
	public void AutoGeneratePassword(String user, String randomPassword) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user);
		System.out.println("User===>"+user);
		mail.setFrom("kleensman8080@gmail.com");
		mail.setSubject("Password Reset");
		mail.setText("\n Kleensman services(Reset Password) "+"\n\n This is your Auto-generated password: "+randomPassword +" \n\n Kindly use it to reset your password"+" \n" +"Thanks!");
		javaMailSender.send(mail);
	}
}
