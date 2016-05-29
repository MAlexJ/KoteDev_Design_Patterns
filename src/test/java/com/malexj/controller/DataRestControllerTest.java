package com.malexj.controller;

import com.malexj.config.BaseConfigTest;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class DataRestControllerTest extends BaseConfigTest {

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
    public void test_intro_get() throws Exception {
        this.mockMvc.perform(
                get("/intro")
                        .session(session)
                        .contentType(MediaType.TEXT_HTML)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("{\"id\":")));
    }

    //path = "/behavioral"
    @Test
    public void test_behavioral_get() throws Exception {
        this.mockMvc.perform(
                get("/behavioral")
                        .session(session)
                        .contentType(MediaType.TEXT_HTML)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("{\"id\":")));
    }

    //path = "/creational"
    @Test
    public void test_creational_get() throws Exception {
        this.mockMvc.perform(
                get("/creational")
                        .session(session)
                        .contentType(MediaType.TEXT_HTML)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("{\"id\":")));
    }

    //path = "/structural"
    @Test
    public void test_structural_get() throws Exception {
        this.mockMvc.perform(
                get("/structural")
                        .session(session)
                        .contentType(MediaType.TEXT_HTML)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("{\"id\":")));
    }

}
