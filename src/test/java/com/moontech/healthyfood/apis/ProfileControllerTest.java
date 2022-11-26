package com.moontech.healthyfood.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moontech.healthyfood.configuration.MysqlBaseConfigurationTest;
import com.moontech.healthyfood.configuration.TestConstants;
import com.moontech.healthyfood.models.requests.ProfileRequest;
import com.moontech.healthyfood.models.responses.AuthorityResponse;
import com.moontech.healthyfood.services.RoleService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Prueba del controlador de perfiles.
 *
 * @author Felipe Monzón
 * @enterprise moontech
 * @since 21 nov., 2022
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@WithMockUser(roles = TestConstants.ROLE_ADMIN)
class ProfileControllerTest extends MysqlBaseConfigurationTest {
  @Autowired private MockMvc mockMvc;
  /** Servicio de perfiles. */
  @MockBean private RoleService roleService;
  /** Mapper. */
  @Autowired private ObjectMapper objectMapper;
  /** Ruta base de perfiles. */
  private static final String PROFILE_BASE_PATH = "/profiles";

  @Test
  @DisplayName("GET /profiles empty list")
  void retrieve_empty_profiles(TestInfo testInfo) throws Exception {
    log.info(TestConstants.TEST_RUNNING, testInfo.getDisplayName());
    Mockito.when(this.roleService.retrieve()).thenReturn(new ArrayList<>());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(PROFILE_BASE_PATH)
                .header(TestConstants.UUID_HEADER, String.valueOf(UUID.randomUUID())))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
  }

  @Test
  @DisplayName("GET /profiles success")
  void retrieve_all_profiles(TestInfo testInfo) throws Exception {
    log.info(TestConstants.TEST_RUNNING, testInfo.getDisplayName());
    Mockito.when(this.roleService.retrieve())
        .thenReturn(Collections.singletonList(this.getAuthorityResponse()));
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(PROFILE_BASE_PATH)
                .header(TestConstants.UUID_HEADER, String.valueOf(UUID.randomUUID())))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(7)));
  }

  @Test
  @DisplayName("GET /profiles search success")
  void search_profiles(TestInfo testInfo) throws Exception {
    log.info(TestConstants.TEST_RUNNING, testInfo.getDisplayName());
    Mockito.when(this.roleService.retrieve())
        .thenReturn(Collections.singletonList(this.getAuthorityResponse()));
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get(PROFILE_BASE_PATH + "/2L")
                .header(TestConstants.UUID_HEADER, String.valueOf(UUID.randomUUID())))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(7)));
  }

  @Test
  @DisplayName("POST /profiles success")
  void save_success(TestInfo testInfo) throws Exception {
    log.info(TestConstants.TEST_RUNNING, testInfo.getDisplayName());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(PROFILE_BASE_PATH)
                .header(TestConstants.UUID_HEADER, String.valueOf(UUID.randomUUID()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(this.getProfileRequest())))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  @DisplayName("PUT /profiles success")
  void update_success(TestInfo testInfo) throws Exception {
    log.info(TestConstants.TEST_RUNNING, testInfo.getDisplayName());
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.put(PROFILE_BASE_PATH + "/1")
                .header(TestConstants.UUID_HEADER, String.valueOf(UUID.randomUUID()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(this.getProfileRequest())))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  private ProfileRequest getProfileRequest() {
    ProfileRequest request = new ProfileRequest();
    request.setId(1L);
    request.setName("ROLE_ADMIN");
    request.setValue(TestConstants.ROLE_ADMIN);
    return request;
  }

  private AuthorityResponse getAuthorityResponse() {
    AuthorityResponse response = new AuthorityResponse();
    response.setId(1L);
    response.setName("ROLE_ADMIN");
    response.setValue(TestConstants.ROLE_ADMIN);
    return response;
  }
}
