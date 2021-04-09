package com.example.reqargs.service;

import com.example.reqargs.entity.Account;
import com.example.reqargs.entity.AccountRole;
import com.example.reqargs.entity.Role;
import com.example.reqargs.entity.RoleType;
import com.example.reqargs.repository.AccountRepository;
import com.example.reqargs.repository.AccountRoleRepository;
import com.example.reqargs.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    private final AccountRepository repository;
    private final AccountRoleRepository accountRoleRepository;
    private final RoleRepository roleRepository;

    public SignUpServiceImpl(AccountRepository repository, AccountRoleRepository accountRoleRepository, RoleRepository roleRepository) {
        this.repository = repository;
        this.accountRoleRepository = accountRoleRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void signUp(SignUpRequest request) {
        final Account account = request.toAccount();
        repository.save(account);

        final Role role = new Role(RoleType.CUSTOMER);
        roleRepository.save(role);

        final AccountRole accountRole = new AccountRole(account, role);
        accountRoleRepository.save(accountRole);
    }
}
