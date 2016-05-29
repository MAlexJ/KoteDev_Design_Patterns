package com.malexj.controller;

import com.malexj.config.BaseConfigTest;
import com.malexj.model.dto.AccountAllDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RegisterControllerTest extends BaseConfigTest {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MockHttpSession session;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void test_register_POST() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        AccountAllDTO dto = new AccountAllDTO();
        dto.setName("Alex");
        dto.setEmail("www@www.ru");
        dto.setPassword("2364");

        this.mockMvc.perform(
                post("/register")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }


}
