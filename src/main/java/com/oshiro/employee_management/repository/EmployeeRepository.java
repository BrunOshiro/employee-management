package com.oshiro.employee_management.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, BigInteger> {
    Optional<EmployeeEntity> findById(BigInteger id);
}
