package com.techtest;

import com.techtest.api.domain.entity.TUser;
import com.techtest.api.infrastructure.http.UserController;
import com.techtest.api.infrastructure.persistence.UserRepository;
import com.techtest.api.usecases.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes={UserRepository.class,UserService.class,UserController.class})
@AutoConfigureMockMvc
@EnableWebMvc
@EnableConfigurationProperties
public class TestUserRestController {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    private TUser user;

    @BeforeEach
    void setUp(){
        user = new TUser();
        user.setEmail("email");
    }

    @Test
    public void successCreateUserTest() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/")
                        .content(getUserToStringJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void wrongPasswordCreateUserTest() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/")
                        .content(getWrongPasswordUserToStringJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void wrongEmailCreateUserTest() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/")
                        .content(getWrongEmailUserToStringJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void getAllUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getUserNotFoudTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void successUpdateUserTest() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/user/")
                        .content(getUserToStringJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void loginFailedUserTest() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                        .content(getLogin())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }



    private String getUserToStringJson(){
        return "{\n" +
                "    \"name\": \"Juan Rodriguess\",\n" +
                "    \"email\": \"aaa@rodriguez.org\",\n" +
                "    \"password\": \"hunterT2ja\",\n" +
                "    \"phones\": [\n" +
                "        {\n" +
                "            \"number\": \"12345617\",\n" +
                "            \"citycode\": \"1\",\n" +
                "            \"contrycode\": \"57\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"number\": \"12345617\",\n" +
                "            \"citycode\": \"1\",\n" +
                "            \"contrycode\": \"57\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    private String getWrongPasswordUserToStringJson(){
        return "{\n" +
                "    \"name\": \"Juan Rodriguess\",\n" +
                "    \"email\": \"aaa@rodriguez.org\",\n" +
                "    \"password\": \"hunt\",\n" +
                "    \"phones\": [\n" +
                "        {\n" +
                "            \"number\": \"12345617\",\n" +
                "            \"citycode\": \"1\",\n" +
                "            \"contrycode\": \"57\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"number\": \"12345617\",\n" +
                "            \"citycode\": \"1\",\n" +
                "            \"contrycode\": \"57\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    private String getWrongEmailUserToStringJson(){
        return "{\n" +
                "    \"name\": \"Juan Rodriguess\",\n" +
                "    \"email\": \"rodriguez.org\",\n" +
                "    \"password\": \"huntTaa\",\n" +
                "    \"phones\": [\n" +
                "        {\n" +
                "            \"number\": \"12345617\",\n" +
                "            \"citycode\": \"1\",\n" +
                "            \"contrycode\": \"57\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"number\": \"12345617\",\n" +
                "            \"citycode\": \"1\",\n" +
                "            \"contrycode\": \"57\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    private String getLogin(){
        return "{\n" +
                "    \"email\": \"juan@rodriguez.org\",\n" +
                "    \"password\": \"hunter2\"\n" +
                "}";
    }

}
