package com.avanse.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserConsentReqObj {
    private String name;
    private String birthDate;
    private String lan;
    private String consentVersion;
    private String date;

    // create builder for create entity using userConsentReqObj
 public  static UserConsent toConsent(UserConsentReqObj userConsentReqObj){

        return UserConsent
                .builder()
                .name(userConsentReqObj.getName())
                .lan(userConsentReqObj.getLan())
                .birthDate(userConsentReqObj.getBirthDate())
                .date(userConsentReqObj.getDate())
                .consentVersion(userConsentReqObj.getConsentVersion()).build();
    }

    public UserConsentResObj toResponce(UserConsentReqObj consentReqObj) {
        return UserConsentResObj
                .builder()
                .name(consentReqObj.getName())
                .lan(consentReqObj.getLan())
                .birthDate(consentReqObj.getBirthDate())
                .date(consentReqObj.getDate())
                .consentVersion(consentReqObj.getConsentVersion()).build();
    }
}
