package me.xiao.springlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 15:03
 */

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Welocom to the home page!";
    }
}
