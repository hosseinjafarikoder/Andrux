package com.andrux.andrux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Controller
@RequestMapping("/terminal")
public class Terminal {
    Logger logger = LoggerFactory.getLogger(Terminal.class);

    @GetMapping("/java")
    public String javaTerminal(){
        logger.info("log for javaTerminal endpoint");
//        return "terminal/javaTerminal";
        return "redirect:https://www.tutorialspoint.com/compile_java_online.php";
    }

    @GetMapping("/java2")
    @ResponseBody
    public ResponseEntity<String> proxyWebsite() {
        String externalUrl = "https://www.tutorialspoint.com/compile_java_online.php";  // Replace with the actual URL

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.TEXT_HTML));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                externalUrl, HttpMethod.GET, entity, String.class);

        String modifiedHtml = modifyHtml(response.getBody());

        HttpHeaders modifiedHeaders = new HttpHeaders();
        modifiedHeaders.setContentType(MediaType.TEXT_HTML);
        System.out.println("code ok??");

        return new ResponseEntity<>(modifiedHtml, modifiedHeaders, HttpStatus.OK);
    }

    private String modifyHtml(String originalHtml) {
        // Modify the original HTML as needed
//        String modifiedHtml = originalHtml.replace("<div id=\"north\">", "<div id=\"north\" style=\"display:none;\">");
//        String modifiedHtml = originalHtml + "<script>document.getElementById('north').style.display = 'none';</script>";
        String modifiedHtml = originalHtml + "<script>document.addEventListener('DOMContentLoaded', function() { document.getElementById('north').style.display = 'none'; });</script>";

        return modifiedHtml;
    }


    @GetMapping("/html")
    @ResponseBody
    public ResponseEntity<String> proxyHtmlWebsite() {
        String externalUrl = "https://www.tutorialspoint.com/online_html_editor.php";  // Replace with the actual URL

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.TEXT_HTML));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                externalUrl, HttpMethod.GET, entity, String.class);

        String modifiedHtml = modifyHtml2(response.getBody());

        HttpHeaders modifiedHeaders = new HttpHeaders();
        modifiedHeaders.setContentType(MediaType.TEXT_HTML);
        System.out.println("code ok??");

        return new ResponseEntity<>(modifiedHtml, modifiedHeaders, HttpStatus.OK);
    }

    private String modifyHtml2(String originalHtml) {
        // Modify the original HTML as needed
//        String modifiedHtml = originalHtml.replace("<div id=\"north\">", "<div id=\"north\" style=\"display:none;\">");
//        String modifiedHtml = originalHtml + "<script>document.getElementById('north').style.display = 'none';</script>";
        String modifiedHtml = originalHtml + "<script>document.addEventListener('DOMContentLoaded', function() { document.getElementById('north').style.display = 'none'; });</script>";

        return modifiedHtml;
    }

    @PostMapping("/handler")
    public String terminalHandler(@RequestParam("mySwitch") String mySwitch){
        String result = "";
        switch (mySwitch){
            case "java":
                result = "redirect:https://www.tutorialspoint.com/compile_java_online.php";
                break;
            case "python":
                result = "redirect:https://www.tutorialspoint.com/online_python_compiler.php";
                break;
            case "js":
                result = "redirect:https://www.tutorialspoint.com/online_javascript_editor.php";
                break;
            case "git":
                result = "redirect:https://www.tutorialspoint.com/linux_terminal_online.php";
                break;
            case "db":
                result = "redirect:https://www.tutorialspoint.com/execute_sql_online.php";
                break;
            default:
                System.out.println("error");
        }
        return result;
    }

}
