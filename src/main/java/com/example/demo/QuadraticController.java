package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuadraticController {

    @GetMapping("/")
    public String showPage() {
        return "Quadratic";
    }

    @GetMapping("/calculate")
    public String handleGetCalculate() {
        return "redirect:/";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam(value = "a", defaultValue = "1") double a,
            @RequestParam(value = "b", defaultValue = "1") double b,
            @RequestParam(value = "c", defaultValue = "1") double c,
            Model model) {

        String result;

        if (a == 0) {
            result = "Nilai 'a' tidak boleh 0 pada persamaan kuadrat!";
        } else {
            double discriminant = (b * b) - (4 * a * c);

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                result = String.format("Dua akar real berbeda: x₁ = %.2f, x₂ = %.2f (Diskriminan D = %.2f)", x1, x2, discriminant);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                result = String.format("Satu akar kembar (real): x = %.2f (Diskriminan D = 0)", x);
            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                result = String.format("Akar imajiner/kompleks: x₁ = %.2f + %.2fi, x₂ = %.2f - %.2fi (Diskriminan D = %.2f)", 
                        realPart, imaginaryPart, realPart, imaginaryPart, discriminant);
            }
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        model.addAttribute("result", result);

        return "Quadratic";
    }
}