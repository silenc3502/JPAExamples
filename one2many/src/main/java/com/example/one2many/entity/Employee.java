package com.example.one2many.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "s_emp")
public class Employee {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    // Many2One은 Many에 해당하는 Entity가
    // One에 해당하는 Entity를 참조할 때 Many에 해당하는 Entity에 설정한다.
    // @ManyToOne(targetEntity = com.example.many2one2.entity.Department.class)
    // Null을 허용하지 않으므로 inner join 형태로 갈 수 있으며
    // FetchType.LAZY를 통해 리눅스 커널의 Lazy Buddy와 같이 필요한 시점까지 데이터를 준비하지 않는다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department dept;
}
