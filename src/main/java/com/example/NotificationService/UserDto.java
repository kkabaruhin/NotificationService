package com.example.NotificationService;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private long id;
    private String name;
    private String email;
    private int age;
    private String createdAt;

}