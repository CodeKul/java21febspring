package com.codekul.java21febspring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("saveUser")
    public String saveUser(@RequestBody Users users) {
        usersRepository.save(users);
        return "user saved.";
    }

    @PostMapping("login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        String userNm = usersRepository.getLoginUser(loginRequestDto.getUserName(), loginRequestDto.getPassword());
        if(userNm != null){
            return "login successfully..";
        }else {
            return "login failed";
        }
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