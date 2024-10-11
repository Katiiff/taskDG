package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String position;
    private UserStatus status;
    private Long departmentId;
    private String departmentCode;
}
