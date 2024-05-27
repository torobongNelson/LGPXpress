package org.smartapplication.services;

import org.smartapplication.dtos.request.EmailSenderRequest;
import org.smartapplication.dtos.response.EmailSenderResponse;

public interface NotificationService {
    EmailSenderResponse sendEmail(EmailSenderRequest emailSenderRequest);
}
