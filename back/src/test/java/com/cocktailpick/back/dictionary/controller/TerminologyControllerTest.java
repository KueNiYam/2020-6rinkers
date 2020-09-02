package com.cocktailpick.back.dictionary.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.web.context.WebApplicationContext;

import com.cocktailpick.back.common.documentation.DocumentationWithSecurity;
import com.cocktailpick.back.dictionary.dto.TerminologyResponse;
import com.cocktailpick.back.dictionary.service.TerminologyService;
import com.cocktailpick.back.tag.dto.TerminologyRequest;
import com.cocktailpick.back.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = TerminologyController.class)
class TerminologyControllerTest extends DocumentationWithSecurity {
	private static final String VODKA_IMAGE_URL = "https://media-verticommnetwork1.netdna-ssl.com/wines/absolut-vodka-45l-434781.jpg";

	@MockBean
	private TerminologyService terminologyService;

	@MockBean
	private UserService userService;

	private TerminologyRequest terminologyRequest;

	private TerminologyResponse terminologyResponse;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext,
		RestDocumentationContextProvider restDocumentationContextProvider) {
		super.setUp(webApplicationContext, restDocumentationContextProvider);

		terminologyRequest = TerminologyRequest.builder()
			.name("보드카")
			.terminologyType("술")
			.description("러시아의 술이고 감자나 호밀을 증류하여 만듭니다.")
			.imageUrl(VODKA_IMAGE_URL)
			.build();

		terminologyResponse = new TerminologyResponse(1L, "보드카", "술", "러시아의 술입니다.", VODKA_IMAGE_URL);

		objectMapper = new ObjectMapper();

	}

	@DisplayName("용어를 생성한다.")
	@Test
	void save() throws Exception {
		when(terminologyService.save(any())).thenReturn(1L);

		mockMvc.perform(post("/api/terminologies")
			.content(objectMapper.writeValueAsString(terminologyRequest))
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(header().string("Location", "/api/terminologies/1"));
	}

	@DisplayName("모든 용어를 조회한다.")
	@Test
	void findTerminologies() throws Exception {
		List<TerminologyResponse> terminologyResponses = Arrays.asList(
			terminologyResponse,
			new TerminologyResponse(2L, "지거", "칵테일", "음료의 양을 측정하는 도구입니다.", VODKA_IMAGE_URL)
		);
		when(terminologyService.findAllTerminologies()).thenReturn(terminologyResponses);

		mockMvc.perform(get("/api/terminologies")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@DisplayName("단일 용어를 조회한다.")
	@Test
	void findTerminology() throws Exception {
		when(terminologyService.findTerminology(anyLong())).thenReturn(terminologyResponse);

		mockMvc.perform(get("/api/terminologies/1")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
}