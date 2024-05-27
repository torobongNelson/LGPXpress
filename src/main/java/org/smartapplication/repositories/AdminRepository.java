package org.smartapplication.repositories;

import org.smartapplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>  {
    
}
