package com.crud1.crud1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userno;

    @Column(nullable = false)
    private String userid;
    
    @Column(nullable = false)
    private String userpass;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = true)
    private String useremail;
    
    @Column(nullable = true)
    private String userphone;

    public void change(String useremail, String userphone){
        this.useremail = useremail;
        this.userphone = userphone;
    }
}
