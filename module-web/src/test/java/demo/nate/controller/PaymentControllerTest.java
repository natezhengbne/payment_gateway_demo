package demo.nate.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.nate.BaseUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest extends BaseUnitTest {
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private URL base;
    private MultiValueMap<String, Object> paramMap;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api/payment/pay");

        paramMap = new LinkedMultiValueMap<>();
        paramMap.add("userId", "testUserId");
        paramMap.add("orderId", "testOrderId");
        paramMap.add("secureCode", "3535");
    }

    @Test
    @DisplayName("Test - Request method 'GET' not supported")
    void testFailedByGetMethod() throws JsonProcessingException {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    @DisplayName("Test - Valid Credit Card Number")
    void validCreditCardNum() throws JsonProcessingException {
        paramMap.add("cardType", "amex");
        paramMap.add("cardNum", "378282246310005");

        ResponseEntity<String> response = template.postForEntity(base.toString(),paramMap,
                String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(response.getBody());
        int status = actualObj.get("status").asInt();
        assertEquals(1, status);
    }

    @Test
    @DisplayName("Test - Invalid Credit Card Number")
    void invalidCreditCardNum() throws JsonProcessingException {
        paramMap.add("cardType", "visa");
        paramMap.add("cardNum", "4111111111111");

        ResponseEntity<String> response = template.postForEntity(base.toString(),paramMap,
                String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(response.getBody());
        int status = actualObj.get("status").asInt();
        assertEquals(0, status);
    }

}