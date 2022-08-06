package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test /* HTTPステータス200が返却されることを確認.  */
    void test01() throws Exception {
        mockMvc.perform(get("http://localhost:8080/selectUser?userId=0001"))
                .andExpect(status().isOk());
    }
    @Test /* レスポンス情報が期待通りであることを確認.  */
    void test02() throws Exception {
        String expected = "{\"userId\":\"0001\",\"password\":\"passw0rd\",\"userName\":\"demoUser01\"," +
                "\"birthday\":\"1991-09-06\",\"age\":30,\"gender\":1,\"departmentId\":1,\"role\":\"ROLE_ADMIN\"," +
                "\"department\":{\"departmentId\":1,\"departmentName\":\"System management department\"}}";
        String actual = mockMvc.perform(get("http://localhost:8080/selectUser?userId=0001"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        Assertions.assertEquals(expected, actual);
    }
}