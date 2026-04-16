package org.data2.expensetracker.expense;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "expenses")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String title;

    @Size(max = 255)
    @Column(length = 255)
    private String description;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    @DecimalMin(value = "0.01")
    private BigDecimal cost;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PastOrPresent
    private LocalDate date;

    @Column(nullable = false, length = 30)
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

}
