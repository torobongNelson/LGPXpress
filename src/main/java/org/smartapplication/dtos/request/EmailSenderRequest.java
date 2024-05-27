package org.smartapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailSenderRequest {
    private String from;
    private String to;
    private String subject;
    private String text;
    private String send;

}
