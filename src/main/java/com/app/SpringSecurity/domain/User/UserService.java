package com.app.SpringSecurity.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class UserService {
    public Map<String, String> getForm() {
        Map<String,String> form = new HashMap<>();
        form.put("Formulario"
                ,"https://docs.google.com/forms/d/e/1FAIpQLSclJ7f4My4atgQbvIY-2ANpCGqdA4p_E8qbcLdDqdByGbs1rQ/viewform");
        return  form;
    }
}
