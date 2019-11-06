package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.BusinessService;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositWithCalculationModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InvestmentsControllerResponsesTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService businessService;

    @Test
    void getAvailableDepositsResponse() throws Exception {
        mockMvc.perform(get("/api/investments"))
                .andExpect(status().isOk());
    }


    @Test
    void postNewDepositResponse() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        DepositModel depositModel = new DepositModel();
        String valueAsString = objectMapper.writeValueAsString(depositModel);
        mockMvc.perform(post("/api/investments").contentType(APPLICATION_JSON_VALUE)
                .content(valueAsString))
                .andExpect(status().isOk());
    }

    @Test
    void postNewCalculationResponse() throws Exception {
        CalculationModel calculationModel = new CalculationModel(new BigDecimal(1000), "current");
        ObjectMapper objectMapper = new ObjectMapper();

        String valueAsString = objectMapper.writeValueAsString(calculationModel);

        mockMvc.perform(post("/api/investments").contentType(APPLICATION_JSON_VALUE)
                .content(valueAsString))
                .andExpect(status().isOk());
    }

    @Test
    void hetCalculationsOfDepositResponse() throws Exception {
        DepositWithCalculationModel deposit = new DepositWithCalculationModel();
        Optional<DepositWithCalculationModel> returnedValue = Optional.of(deposit);
        when(businessService.getDepositWithCalculations(1L)).thenReturn(returnedValue);

        mockMvc.perform(get("/api/investments/1/calculations"))
                .andExpect(status().isOk());
    }


}