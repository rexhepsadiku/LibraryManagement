package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.Loan;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ILoanService {
    List<Loan> getAllLoans();
    Loan getLoanById(long id);
    void saveLoan(Loan loan);
    void deleteLoan(long id);
    Page<Loan> findPaginated(int pageNo, int pageSize);
}
