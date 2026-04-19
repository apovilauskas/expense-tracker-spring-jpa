package org.data2.expensetracker.expense;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/")
    public String redirectToExpenses(){
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String showExpenses(Model model){
        if(!model.containsAttribute("expense")){
            model.addAttribute("expense", Expense.builder().build());
        }
        model.addAttribute("categories", Category.values());
        model.addAttribute("expenses", expenseService.findAllExpenses());
        model.addAttribute("summary", expenseService.getSummary());
        return "index";
    }

    @PostMapping("/expenses")
    public String addExpense(@Valid @ModelAttribute("expense") Expense expense,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("categories", Category.values());
            model.addAttribute("expenses", expenseService.findAllExpenses());
            model.addAttribute("summary", expenseService.getSummary());
            return "index";
        }
        expenseService.save(expense);
        redirectAttributes.addFlashAttribute("message","Expense saved.");
        return "redirect:/expenses";
    }

}
