package Controller;

import Model.QuestionAnswer;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.Map;

@Controller
public class WebController {

    private final OllamaChatModel chatModel;

    @Autowired
    public WebController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @PostMapping("/ask")
    public String getAnswer(@RequestParam("question") String question, Model model)
    {
        String answer = Map.of("generation", this.chatModel.call(question)).toString();
        String startTag = "</think>";
        int startIndex = answer.indexOf(startTag);

        // Extract response if start tag is found
        answer = (startIndex != -1) ? answer.substring(startIndex + startTag.length()) : answer;

        model.addAttribute("question", question);
        model.addAttribute("answer", answer.substring(0,answer.length()-1));

        return "index";

    }
}
