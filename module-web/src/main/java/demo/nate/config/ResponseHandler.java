package demo.nate.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice(basePackages = "demo.nate")
public class ResponseHandler implements ResponseBodyAdvice<ObjectNode> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.getMethod().getName().equalsIgnoreCase("exceptionsHandler");
    }

    @Override
    public ObjectNode beforeBodyWrite(ObjectNode body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        if(body!=null){
            objectNode.set("body", body);
        }
        objectNode.put("status", 1);
        return objectNode;
    }

    @ExceptionHandler(value = {
            Exception.class, RuntimeException.class})
    public ObjectNode exceptionsHandler(Exception e, HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("error", e.getMessage());
        objectNode.put("status", 0);

        log.error("HttpServletRequest Error: "+request.getRequestURI(),e);

        return objectNode;
    }

}
