package com.example.gateway.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 트래킹 링크 상세 조회 API의 응답 형식을 매핑한 DTO 입니다.
 */
@Getter
@Setter
public class TrackingLinkDetailResponseDto {
    /** "data" 필드에 포함된 상세 정보 */
    private TrackingLinkDetailDataDto data;
}
