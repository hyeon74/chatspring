package com.example.gateway.dto;

/**
 * 트래킹 링크의 ID와 상세 데이터를 담는 응답 DTO 입니다.
 */
public class TrackingLinkDetailOutputDto {
    /** 트래킹 링크 ID */
    private final String id;
    /** 상세 데이터 */
    private final TrackingLinkDetailDataDto detail;

    public TrackingLinkDetailOutputDto(String id, TrackingLinkDetailDataDto detail) {
        this.id = id;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public TrackingLinkDetailDataDto getDetail() {
        return detail;
    }
}
