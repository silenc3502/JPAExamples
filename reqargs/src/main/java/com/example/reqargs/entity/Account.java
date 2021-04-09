package com.example.reqargs.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Entity
@Table(
        name = "user",
        uniqueConstraints = @UniqueConstraint(name = "account_uq_email", columnNames = {"email"})
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String email;

    private String password;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<AccountRole> accountRoles = new HashSet<>();

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean hasRole(RoleType... types) {
        final Set<Role> roleSet = accountRoles.stream().map(AccountRole::getRole).collect(Collectors.toSet());
        return roleSet.containsAll(Arrays.asList(types));
    }
}
