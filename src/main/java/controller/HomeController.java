package controller;


import dao.UserDao;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@SessionAttributes(names = {"user", "count"})
public class HomeController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @ModelAttribute("count")
    public Integer initCount() {
        return 0;
    }


    @GetMapping("")
    public String Index(ModelMap modelMap) {
        return "index";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") User user, ModelMap modelMap) {
        if (UserDao.checkLogin(user)) {
            modelMap.addAttribute("count", 0);
            return "redirect:/loginSuccess";
        } else
            modelMap.addAttribute("message", "Login failed. Try again.");
        return "index";
    }

    @GetMapping("/loginSuccess")
    public String getLoginSuccess(@SessionAttribute("user") User user, @SessionAttribute(name = "count") Integer count, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("count", ++count);
        return "loginSuccess";
    }
}
