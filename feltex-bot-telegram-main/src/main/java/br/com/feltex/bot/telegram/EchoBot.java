package br.com.feltex.bot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return DadosBot.BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return DadosBot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            var mensagem = responder(update);
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder(Update update) {
        var textoMensagem = update.getMessage().getText().toLowerCase();
        var chatId = update.getMessage().getChatId().toString();

        var resposta = "";
        
        
        
        switch(textoMensagem) {
        
        
        	case "oi":
	        	resposta = "\uD83E\uDD16 Iai Pedro. Como que voce ta?";
	        	
        	break;
        	
        	case "+-":
        		resposta = "\uD83E\uDD16 Entendi. Mas fica tranquilo, vai da bom. Confia!";
	        	
	        break;
	        
        	case ".":
	        	resposta = "\uD83E\uDD16 Teste realizado com sucesso";
	        	
        	break;
        
        }


       

        return SendMessage.builder()
                .text(resposta)
                .chatId(chatId)
                .build();
    }



    

}
