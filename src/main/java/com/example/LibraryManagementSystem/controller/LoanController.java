package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.models.Loan;
import com.example.LibraryManagementSystem.services.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    ILoanService loanService;

    @GetMapping("")
    public String getAllLoans(Model model) {
        return findPaginated(1,model);
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Loan getOne(Long id) {
        return loanService.getLoanById(id);
    }

    @PostMapping("/add")
    public String addNewLoan(Loan loan){
        loanService.saveLoan(loan);
        return "redirect:/loans";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLoan(Long id){
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo, Model model) {
        int pageSize = 6;
        Page<Loan> page = loanService.findPaginated(pageNo,pageSize);
        List<Loan> listLoans = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("loans",listLoans);
        return "loans";
    }
}
