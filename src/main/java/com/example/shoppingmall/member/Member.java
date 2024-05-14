package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Member {
    private int id;
//    @JsonProperty("user_id")
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
