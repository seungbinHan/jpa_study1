package com.example.jpastudy1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String userLoginId;
    private String password;
    private String name;
}
