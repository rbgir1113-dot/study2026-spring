package com.app.oauth.util;

import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SmsUtil {

    @Value("${coolsms.api.key}")
    private String apiKey;

    @Value("${coolsms.api.secret}")
    private String apiSecret;

    @Value("${spring.mail.username}")
    private String emailUsername;

    @Value("${spring.mail.password}")
    private String emailPassword;

    private DefaultMessageService messageService;
    private final JavaMailSenderImpl mailSender;

    @PostConstruct
    private void init(){
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, "https://api.coolsms.co.kr");
    }

    public SingleMessageSentResponse sendOneMemberPhone(String to, String content) {
        Message message = new Message();

        // "01012341234"
        String toPhoneNumber = to.replaceAll("-", "");

        message.setTo(toPhoneNumber);
//        message.setFrom("01047099813");
        message.setFrom("01035059904");
        message.setText(content);

        SingleMessageSentResponse response = this
                .messageService
                .sendOne(new SingleMessageSendingRequest(message));
        return response;
    }

    // 이메일 전송
    public void sendOneMemberEmail(String to,String subject, String content ) {
        MimeMessage mineMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mineMessage, false, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject); // 제목
            helper.setText(content);
            helper.setFrom("rbgir1113@gmail.com","뀨잉"); // 보낸 이메일, 보낸 사람 이름

            mailSender.send(mineMessage);

        } catch (Exception e) {
            throw new RuntimeException("메일 전송 실패" + e.getMessage());
        }
    }
}
