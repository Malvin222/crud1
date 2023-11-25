package com.crud1.crud1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long userno;
    private String userid;
    private String userpass;
    private String username;
    private String useremail;
    private String userphone;
}
