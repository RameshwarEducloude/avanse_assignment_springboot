package com.avanse.assignment;

import com.avanse.assignment.entities.UserConsent;
import com.avanse.assignment.entities.UserConsentResObj;

public interface ConsentService {

    UserConsentResObj saveUserConsent(UserConsent userConsent);
}
