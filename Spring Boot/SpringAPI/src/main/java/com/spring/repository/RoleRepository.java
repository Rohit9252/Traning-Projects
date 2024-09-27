package com.spring.repository;

import com.spring.Model.MyRole;
import com.spring.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
    public Role findByRole(MyRole roles);
}
