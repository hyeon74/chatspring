package com.example.gateway.service;

import com.example.gateway.client.AirbridgeClient;
import com.example.gateway.dto.TrackingLinkDetailDataDto;
import com.example.gateway.dto.TrackingLinkDetailOutputDto;
import com.example.gateway.dto.TrackingLinkDetailResponseDto;
import com.example.gateway.dto.TrackingLinkListInputDto;
import com.example.gateway.dto.TrackingLinkListResponseDto;
import com.example.gateway.dto.TrackingLinkPageOutputDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrackingLinkService {

    private final AirbridgeClient airbridgeClient;
    private final String token;
    private final String language;

    public TrackingLinkService(AirbridgeClient airbridgeClient,
                               @Value("${airbridge.api.token:}") String token,
                               @Value("${airbridge.api.language:ko}") String language) {
        this.airbridgeClient = airbridgeClient;
        this.token = token;
        this.language = language;
    }

    public TrackingLinkPageOutputDto getTrackingLinkDetails(TrackingLinkListInputDto params) {
        String auth = token.isEmpty() ? null : "Bearer " + token;

        // *****************************
        // 1단계: 전체 건수 조회
        // *****************************
        // 페이징 처리를 위해 먼저 from/to 값만 이용하여 목록 API를 호출한다.
        // 이렇게 하면 skip과 size 값의 영향을 받지 않고 전체 건수를 얻을 수 있다.
        Map<String, Object> countParams = new HashMap<>();
        countParams.put("from", params.getFrom());
        countParams.put("to", params.getTo());
        TrackingLinkListResponseDto countResponse =
                airbridgeClient.getTrackingLinks(auth, language, countParams);

        int totalCount = 0;
        if (countResponse != null && countResponse.getData() != null) {
            // 목록 API 응답의 totalCount 필드에서 전체 건수를 추출한다.
            totalCount = countResponse.getData().getTotalCount();
        }

        // *****************************
        // 2단계: 현재 페이지 목록 조회
        // *****************************
        // Controller 에서 계산하여 전달된 skip/size 값을 그대로 사용해
        // 목록 API를 다시 호출하고 현재 페이지에 해당하는 항목만 조회한다.
        TrackingLinkListResponseDto listResponse =
                airbridgeClient.getTrackingLinks(auth, language, params.toMap());

        List<TrackingLinkDetailOutputDto> details = new ArrayList<>();
        if (listResponse != null
                && listResponse.getData() != null
                && listResponse.getData().getTrackingLinks() != null) {
            // 조회된 각 ID에 대해 상세 정보 API를 호출하여 결과 리스트를 만든다.
            for (TrackingLinkListResponseDto.Item item :
                    listResponse.getData().getTrackingLinks()) {
                String id = item.getId();
                TrackingLinkDetailResponseDto detailResponse =
                        airbridgeClient.getTrackingLinkDetail(auth, language, id, "id");
                TrackingLinkDetailDataDto detailData =
                        detailResponse != null ? detailResponse.getData() : null;
                details.add(new TrackingLinkDetailOutputDto(id, detailData));
            }
        }

        // 전체 건수와 상세 목록을 포함한 DTO 반환
        return new TrackingLinkPageOutputDto(totalCount, details);
    }
}
