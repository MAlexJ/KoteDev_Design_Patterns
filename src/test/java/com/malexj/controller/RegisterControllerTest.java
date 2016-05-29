package com.malexj.controller;

import com.malexj.config.BaseConfigTest;
import com.malexj.model.dto.AccountAllDTO;
import com.malexj.model.dto.AccountEmailDTO;
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

public class RegisterControllerTest extends BaseConfigTest {

    private ObjectMapper mapper;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockHttpSession session;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        this.mapper = new ObjectMapper();
    }

    //Register full form -> success
    @Test
    public void test_register_POST() throws Exception {
        //when
        AccountAllDTO dto = new AccountAllDTO();
        dto.setName("Alex");
        dto.setEmail("www@www.ru");
        dto.setPassword("2364");
        //then
        this.mockMvc.perform(
                post("/register")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    //Register form -> error
    @Test
    public void test_register_without_name_POST_ERROR() throws Exception {
        //when
        AccountAllDTO dto = new AccountAllDTO();
        dto.setEmail("www@www.ru");
        dto.setPassword("2364");
        //then
        this.mockMvc.perform(
                post("/register")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
        )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    //Register form -> error
    @Test
    public void test_register_without_email_POST_ERROR() throws Exception {
        //when
        AccountAllDTO dto = new AccountAllDTO();
        dto.setName("user");
        dto.setPassword("2364");
        //then
        this.mockMvc.perform(
                post("/register")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
        )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    //Register form -> error
    @Test
    public void test_register_without_password_POST_ERROR() throws Exception {
        //when
        AccountAllDTO dto = new AccountAllDTO();
        dto.setName("user");
        dto.setEmail("eew@mai.ru");
        //then
        this.mockMvc.perform(
                post("/register")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
        )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }


    //Restore form -> success
    @Test
    public void test_restore_POST() throws Exception {
        //given
        AccountAllDTO dto = new AccountAllDTO();
        dto.setName("Alex");
        dto.setEmail("www@www.ru");
        dto.setPassword("2364");
        this.mockMvc.perform(
                post("/register")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
        );

        //when
        AccountEmailDTO accountEmailDTO = new AccountEmailDTO();
        accountEmailDTO.setEmail("www@www.ru");

        //then
        this.mockMvc.perform(
                post("/restore")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(accountEmailDTO))
        )
                .andDo(print())
                .andExpect(status().isOk());

    }

    //Restore form -> fail
    @Test
    public void test_restore_POST_ERROR() throws Exception {
        //given
        AccountEmailDTO account = new AccountEmailDTO();

        //when
        account.setEmail("www@www.ru");

        //then
        this.mockMvc.perform(
                post("/restore")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(account))
        )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    //TODO test validate email -> RegEx

}
