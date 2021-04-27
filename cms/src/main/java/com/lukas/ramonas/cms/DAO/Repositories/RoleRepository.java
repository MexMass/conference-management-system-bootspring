package com.lukas.ramonas.cms.DAO.Repositories;

import com.lukas.ramonas.cms.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
