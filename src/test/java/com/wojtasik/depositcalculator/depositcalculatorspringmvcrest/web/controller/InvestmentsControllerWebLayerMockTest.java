package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.BusinessService;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositResponse;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositReturnedModel;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InvestmentsController.class)
class InvestmentsControllerWebLayerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService businessService;


    @Test
    void getDepositsReturnList() throws Exception {
        //given
        List<DepositResponse> deposits = new ArrayList<>();
        deposits.add(new DepositResponse(1L, "Temp_Deposit"));
        //when
        when(businessService.list()).thenReturn(deposits);
        ResultActions perform = mockMvc.perform(get("/api/investments"));
        //then
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();

        List<DepositResponse> depositResponses = objectMapper.readValue(contentAsString, new TypeReference<List<DepositResponse>>() {});
        assertEquals(depositResponses.size(), 1);
    }
    @Test
    void postDepositModelAndDepositReturnedModelResponse() throws Exception {
        //given
        DepositModel depositModel = new DepositModel(1L, "Test_Deposit", 12.1, 3, LocalDate.of(2019,1,1), LocalDate.of(2020,1,1));
        ModelMapper modelMapper = new ModelMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        //when
        when(businessService.addDeposit(depositModel)).thenReturn(modelMapper.map(depositModel, DepositReturnedModel.class));
        String valueAsString = objectMapper.writeValueAsString(depositModel);
        //then
        ResultActions perform = mockMvc.perform(post("/api/investments").contentType(APPLICATION_JSON_VALUE)
                .content(valueAsString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("name", is("Test_Deposit")))
                .andExpect(jsonPath("debitRate", is(12.1)));
    }


}