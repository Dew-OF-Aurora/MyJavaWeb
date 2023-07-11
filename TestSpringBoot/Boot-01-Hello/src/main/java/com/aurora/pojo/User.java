package com.aurora.pojo;

import lombok.*;

/**
 * @author:Aurora
 * @create: 2023-06-14 16:11
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private String username;
    private Integer age;
}
