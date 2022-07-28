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
        mockMvc.perform(get("http://localhost:8080/demo?userId=0001"))
                .andExpect(status().isOk());
    }
    @Test /* レスポンス情報が期待通りであることを確認.  */
    void test02() throws Exception {
        String expected = "{\"userId\":\"0001\",\"userName\":\"demoUser01\",\"age\":30}";
        String actual = mockMvc.perform(get("http://localhost:8080/demo?userId=0001"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        Assertions.assertEquals(expected, actual);
    }
}