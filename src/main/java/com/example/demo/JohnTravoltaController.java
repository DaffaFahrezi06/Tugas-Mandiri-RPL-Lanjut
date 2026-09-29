package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JohnTravoltaController {

    @GetMapping("/")
    public String showPage() {
        return "JohnTravolta";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam(value = "jam", required = false, defaultValue = "0") double jam,
            @RequestParam(value = "biaya", required = false, defaultValue = "0") double biaya,
            Model model) {

        double wage = 15000.0;
        double gaji;

        if (jam > 40) {
            double jamLembur = jam - 40;
            gaji = (40 * wage) + (jamLembur * 1.5 * wage);
        } else {
            gaji = jam * wage;
        }

        double tabungan = gaji - biaya;
        String result;

        if (tabungan > 0) {
            result = String.format("John Travolta mendapatkan gaji sebesar Rp %,.2f dan bisa menabung sebanyak Rp %,.2f. John Travolta Bisa Menabung", gaji, tabungan);
        } else if (tabungan == 0) {
            result = String.format("John Travolta mendapatkan gaji sebesar Rp %,.2f. Seluruh penghasilan habis untuk biaya hidup. John Travolta Tidak Bisa Menabung", gaji);
        } else {
            result = String.format("John Travolta mendapatkan gaji sebesar Rp %,.2f dan defisit (kurang) sebesar Rp %,.2f. John Travolta Tidak Bisa Menabung", gaji, Math.abs(tabungan));
        }

        model.addAttribute("jam", jam);
        model.addAttribute("biaya", biaya);
        model.addAttribute("result", result);

        return "JohnTravolta";
    }
}