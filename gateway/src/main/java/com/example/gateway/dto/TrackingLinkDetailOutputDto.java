package com.example.gateway.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 트래킹 링크의 ID와 상세 데이터를 담는 응답 DTO 입니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingLinkDetailOutputDto {
    /** 트래킹 링크 ID */
    private String id;
    /** 상세 데이터 */
    private TrackingLinkDetailDataDto detail;
}
