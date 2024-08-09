package com.avanse.assignment;

import com.avanse.assignment.entities.UserConsent;
import com.avanse.assignment.entities.UserConsentResObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsentServiceImpl implements ConsentService{

    @Autowired
    ConsentRepository consentRepository;

    @Override
    public UserConsent saveUserConsent(UserConsent userConsent) {
        consentRepository.save(userConsent);
        return userConsent;
    }


}
