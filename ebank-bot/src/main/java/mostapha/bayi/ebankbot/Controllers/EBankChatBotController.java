package mostapha.bayi.ebankbot.Controllers;

import mostapha.bayi.ebankbot.agents.EbankAIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EBankChatBotController {
    private EbankAIAgent ebankAIAgent;

    public EBankChatBotController(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }


    @GetMapping("/chat")
    public String chat(@RequestParam(name = "query", defaultValue = "Bonjour") String query) {
        return ebankAIAgent.chat(query);
    }
}
