package com.oshiro.employee_management.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Builder
@Table(name = "employee")
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @Column(name = "id", unique = true, updatable = false)
    private BigInteger id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private BigDecimal salary;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Default constructor for JPA
    public EmployeeEntity() {
    }
}
