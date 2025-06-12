package com.example.gateway.client;

import com.example.gateway.dto.TrackingLinkDetailResponseDto;
import com.example.gateway.dto.TrackingLinkListResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "airbridgeClient", url = "${airbridge.api.base-url:https://api.airbridge.io}")
public interface AirbridgeClient {

    @GetMapping("/tracking-links")
    TrackingLinkListResponseDto getTrackingLinks(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "Accept-Language", required = false) String acceptLanguage,
            @RequestParam Map<String, Object> params);

    @GetMapping("/tracking-links/{id}")
    TrackingLinkDetailResponseDto getTrackingLinkDetail(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "Accept-Language", required = false) String acceptLanguage,
            @PathVariable("id") String id,
            @RequestParam(name = "idType", required = false) String idType);
}
