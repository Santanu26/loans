package com.santanu.loan.controller;

import com.santanu.loan.model.Customer;
import com.santanu.loan.model.Loan;
import com.santanu.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody @Validated Customer customer) {
        return loanService.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId()).orElse(null);
    }
}
