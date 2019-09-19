package cn.qydx.service.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthyProbeController {
	
    @GetMapping("/health")
    public String greeting(Model model) {
        model.addAttribute("status", "状态健康良好！");
        return "health";
    }
}
