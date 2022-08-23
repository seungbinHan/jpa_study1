package com.example.jpastudy1.controller;


import com.example.jpastudy1.entity.Member;
import com.example.jpastudy1.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping(value = "member")
    @ResponseBody
    public String memberTest(){
        memberRepository.save(
                Member.builder()
                        .userLoginId("hsben")
                        .password("12341234")
                        .name("test")
                        .build()
        );

        var list = memberRepository.findAll();
        var member = memberRepository.findById(1L);
        if(member.isPresent()){
            System.out.println("member = " + member);
        }
        System.out.println("list = " + list);

        return list.toString();

    }

}
