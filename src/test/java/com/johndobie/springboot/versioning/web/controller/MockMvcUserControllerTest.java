package com.johndobie.springboot.versioning.web.controller;

import com.johndobie.springboot.versioning.util.TestDataHelper;
import com.johndobie.springboot.versioning.web.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.johndobie.springboot.versioning.util.TestDataHelper.readJsonAsObject;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class MockMvcUserControllerTest {

    private static final Integer USER_ONE_ID = 1;
    private static final Integer USER_TWO_ID = 2;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSaveUser() throws Exception {
        User user = TestDataHelper.getUserDetails(USER_ONE_ID);
        User savedUser = saveUser(user);
        assertThat(savedUser.getId()).isEqualTo(user.getId());
    }

    @Test
    public void testGetUser() throws Exception {
        User user = TestDataHelper.getUserDetails(USER_TWO_ID);
        User savedUser = saveUser(user);
        assertThat(savedUser.getId()).isEqualTo(user.getId());

        savedUser = getUser(USER_TWO_ID);
        assertThat(savedUser.getId()).isEqualTo(USER_TWO_ID);
    }

    private User saveUser(User user) throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .post(UserController.SAVE_USER_MODEL_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestDataHelper.getJsonObjectAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        return readJsonAsObject(mvcResult.getResponse().getContentAsString(), User.class);
    }

    private User getUser(Integer id) throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get(UserController.GET_USER_MODEL_ENDPOINT)
                        .param("id", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        return readJsonAsObject(mvcResult.getResponse().getContentAsString(), User.class);
    }
}

