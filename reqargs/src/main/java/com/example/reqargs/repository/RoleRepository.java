package com.example.reqargs.repository;

import com.example.reqargs.entity.Role;
import com.example.reqargs.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType type);
}
