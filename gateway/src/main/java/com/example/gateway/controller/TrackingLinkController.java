package com.example.gateway.controller;

import com.example.gateway.dto.TrackingLinkPageOutputDto;
import com.example.gateway.service.TrackingLinkService;
import com.example.gateway.dto.TrackingLinkListInputDto;
import com.example.gateway.dto.TrackingLinkListRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tracking-links")
public class TrackingLinkController {

    private final TrackingLinkService service;

    public TrackingLinkController(TrackingLinkService service) {
        this.service = service;
    }

    @GetMapping("/details")
    public TrackingLinkPageOutputDto listDetails(TrackingLinkListRequestDto request) {
        TrackingLinkListInputDto params = request.toServiceDto();
        return service.getTrackingLinkDetails(params);
    }
}
