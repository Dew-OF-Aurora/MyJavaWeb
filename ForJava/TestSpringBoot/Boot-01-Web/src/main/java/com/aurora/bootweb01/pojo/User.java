package com.aurora.bootweb01.pojo;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true) // 允许链式编程
@ToString
public class User {
    private String name;
    private String pwd;
}
