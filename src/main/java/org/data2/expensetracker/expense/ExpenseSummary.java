package org.data2.expensetracker.expense;

import java.math.BigDecimal;

public record ExpenseSummary(long totalEntries, BigDecimal totalAmount) {
}
