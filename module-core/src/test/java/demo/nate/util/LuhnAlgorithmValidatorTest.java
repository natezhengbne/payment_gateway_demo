package demo.nate.util;

import demo.nate.BaseUnitTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class LuhnAlgorithmValidatorTest extends BaseUnitTest {

    Map<String, Boolean> cardMap = new HashMap<String, Boolean>(){{
        put("4111111111111111", true);
        put("4111111111111", false);
        put("4012888888881881", true);
        put("378282246310005", true);
        put("6011111111111117", true);
        put("5105105105105100", true);
        put("5105 1051 0510 5106", false);
        put("9111111111111111", false);
    }};

    @Test
    void check() {
        for(String cardNo : cardMap.keySet()){
            Boolean result = LuhnAlgorithmValidator.check(cardNo);
            log.info("CardNo: "+cardNo+" Result: "+result);
            assertEquals(cardMap.get(cardNo), result);
        }
    }
}