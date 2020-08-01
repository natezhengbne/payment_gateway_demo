package demo.nate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.nate.constant.CreditCardType;
import demo.nate.service.CreditCardValidatorFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private CreditCardValidatorFactory creditCardValidatorFactory;

    @ApiOperation(value = "Pay the order")
    @RequestMapping(value = "/pay", method = {RequestMethod.POST})
    public ObjectNode pay(
            @ApiParam(name = "orderId", value = "Order Id")
            @RequestParam(value = "orderId") String orderId,
            @ApiParam(name = "userId", value = "User Id")
            @RequestParam(value = "userId") String userId,
            @ApiParam(name = "cardType", value = "Card Type")
            @RequestParam(value = "cardType") String cardType,
            @ApiParam(name = "cardNum", value = "Credit Card Num")
            @RequestParam(value = "cardNum") String cardNum,
            @ApiParam(name = "secureCode", value = "Secure Code")
            @RequestParam(value = "secureCode") String secureCode
    ){

        cardNum = cardNum.trim().replaceAll(" ","");

        Boolean isValid = creditCardValidatorFactory.get(cardType).validate(cardNum);

        if(isValid){
            return new ObjectMapper().createObjectNode();
        }

        throw new RuntimeException("Credit Card is invalid.");
    }
}
