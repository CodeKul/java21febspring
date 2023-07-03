package com.codekul.java21febspring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("saveUser")
    public String saveUser(@RequestBody Users users) {
        usersRepository.save(users);
//        https://myaccount.google.com/u/0/apppasswords
        sendMail();
        return "user saved.";
    }


    @PostMapping("login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        String userNm = usersRepository.getLoginUser(loginRequestDto.getUserName(), loginRequestDto.getPassword());
        if (userNm != null) {
            return "login successfully..";
        } else {
            return "login failed";
        }
    }

    private void sendMail() {
        String from = "codekul.vaibhav@gmail.com";
        String to = "bandalricha99@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("This is a plain text email");
        message.setText("Hello guys! This is a plain text email.");

        mailSender.send(message);
    }
}
/*
select * from fn_login('ak123','12345')
CREATE OR REPLACE FUNCTION public.fn_login(
	userName character varying,
	pass character varying)
    RETURNS TABLE(_name character varying)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$

begin
	return query
		select name from users where user_name=userName and password = pass;
    end;
$BODY$;
 */