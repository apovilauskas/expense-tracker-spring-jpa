package org.data2.expensetracker.expense;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public List<Expense> findAllExpenses(){
        return expenseRepository.findAllByOrderByDateDescIdDesc();
    }

    public ExpenseSummary getSummary(){
        return new ExpenseSummary(expenseRepository.count(), expenseRepository.totalAmount());
    }

    public Expense save(Expense expense){
        return expenseRepository.save(expense);
    }
}
