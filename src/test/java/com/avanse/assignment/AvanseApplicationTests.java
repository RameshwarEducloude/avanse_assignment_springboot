package com.avanse.assignment;

import com.avanse.assignment.entities.UserConsentReqObj;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AvanseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ConsentController consentController;

	@Test
	void saveConsentTest(){
		UserConsentReqObj userConsentReqObj = new UserConsentReqObj();

	}

}
