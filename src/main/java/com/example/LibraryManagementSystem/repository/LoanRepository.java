package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
