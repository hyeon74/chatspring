package com.example.gateway.controller;

import com.example.gateway.dto.TrackingLinkDetailDataDto;
import com.example.gateway.dto.TrackingLinkDetailOutputDto;
import com.example.gateway.dto.TrackingLinkPageOutputDto;
import com.example.gateway.service.TrackingLinkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TrackingLinkControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrackingLinkService service;

    @Test
    void listDetailsReturnsOk() throws Exception {
        TrackingLinkDetailDataDto detail = TrackingLinkDetailDataDto.builder().build();
        when(service.getTrackingLinkDetails(any())).thenReturn(
                TrackingLinkPageOutputDto.builder()
                        .allCnt(1)
                        .items(Collections.singletonList(
                                TrackingLinkDetailOutputDto.builder()
                                        .id("1")
                                        .detail(detail)
                                        .build()))
                        .build());

        mockMvc.perform(get("/tracking-links/details")
                .param("from", "2023-04-01")
                .param("to", "2023-04-02")
                .param("pagNo", "1")
                .param("pgaCnt", "10"))
               .andExpect(status().isOk());
    }
}
