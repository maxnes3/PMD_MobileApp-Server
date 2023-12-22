package com.android.mobileappserver.Mail;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailDTO {
    private Long id;
    private String message;
    private Long postdate;
    private Long userId;

    public MailDTO(MailModel mail){
        this.id = mail.getId();
        this.message = mail.getMessage();
        this.postdate = mail.getPostdate();
        this.userId = mail.getUser().getId();
    }
}
