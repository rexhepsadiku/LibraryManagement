package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.Loan;
import com.example.LibraryManagementSystem.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private LoanRepository loanRepository;
    public List<Loan> getAllLoans() {
        List<Loan> loan = new ArrayList<Loan>();
        loanRepository.findAll().forEach(loan::add);
        return loan;
    }
    public Loan getLoanById(long id){return loanRepository.findById(id).get();}
    public void saveLoan(Loan loan){loanRepository.save(loan);}
    public void deleteLoan(long id){loanRepository.deleteById(id);}
    public Page<Loan> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return loanRepository.findAll(pageable);
    }
}
