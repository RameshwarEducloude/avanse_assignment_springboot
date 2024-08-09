package com.avanse.assignment;

import com.avanse.assignment.entities.UserConsent;
import com.avanse.assignment.entities.UserConsentReqObj;
import com.avanse.assignment.entities.UserConsentResObj;
import com.avanse.assignment.utility.CommonConstants;
import com.avanse.assignment.utility.CommonUtility;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedOutputStream;
import java.io.IOException;

@Controller
public class ConsentController {

    @Autowired
    ConsentService consentService;

    @GetMapping("/")
    public String goForUserConsent() {
        return "consentpage";
    }

    @PostMapping("/saveconsent")
    public void saveConsent(@RequestBody UserConsentReqObj userConsentReqObj, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        try {
            UserConsent userConsent = UserConsentReqObj.toConsent(userConsentReqObj);
            UserConsentResObj resObj = consentService.saveUserConsent(userConsent);
            jsonObject.put(CommonConstants.STATUS, true);
            jsonObject.put(CommonConstants.DATA, JSONObject.fromObject(resObj));
        } catch (Exception e) {
            e.fillInStackTrace();
            jsonObject.put(CommonConstants.STATUS, false);
            jsonObject.put(CommonConstants.ERROR_MESSAGE, e.getMessage());
        }
        CommonUtility.writeDataInResponse(response, jsonObject.toString());
    }




}
