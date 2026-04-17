package org.data2.expensetracker.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long>{

    List<Expense> findAllByOrderByDateDescIdDesc();

    @Query("select coalesce(sum(e.cost), 0) from Expense e")
    BigDecimal totalAmount();
}
