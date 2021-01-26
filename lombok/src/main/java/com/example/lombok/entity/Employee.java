package com.example.lombok.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Employee {
    // @Getter, @Setter, @ToString,
    // @RequiredArgsConstructor, @EqualsAndHashCode
    // 위의 어노테이션은 모두 @Data로 처리될 수 있다.
    private Long id;
    private String name;
    private Timestamp startDate;
    private String title;
    private String deptName;
    private Double salary;
}
