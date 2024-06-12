package com.maxiflexy.apexbankapp.service;

import com.maxiflexy.apexbankapp.payload.request.EmailDetails;

public interface EmailService {
   void  sendEmailAlert (EmailDetails emailDetails);
   void  sendEmailWithAttachment (EmailDetails emailDetails);

}
