package com.example.jpastudy1.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
class MemberTest {

    @MockBean
    MemberRepository memberRepository;

    @Test
    @Transactional
    void test(){
        var member1 = Member.builder()
                .userLoginId("id입니당")
                .password("123")
                .name("한승빈")
                .build();
        memberRepository.save(member1);

        var list = memberRepository.findAll();
        System.out.println("list = " + list);
    }

}