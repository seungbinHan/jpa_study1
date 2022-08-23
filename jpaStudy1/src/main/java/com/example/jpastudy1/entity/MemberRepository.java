package com.example.jpastudy1.entity;

import com.example.jpastudy1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long> {
}
