package com.example.gateway.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 트래킹 링크 목록 API의 응답을 매핑한 DTO 입니다.
 */
@Getter
@Setter
public class TrackingLinkListResponseDto {
    /** 응답 본문 */
    private Data data;

    /**
     * 실제 데이터가 포함되는 내부 객체
     */
    @Getter
    @Setter
    public static class Data {
        /** 전체 항목 수 */
        private int totalCount;
        /** 조회된 ID 목록 */
        private List<Item> trackingLinks;
    }

    /**
     * 목록 항목을 나타내는 객체
     */
    @Getter
    @Setter
    public static class Item {
        /** 트래킹 링크 ID */
        private String id;
    }
}
