package com.example.gateway.dto;

import java.util.List;

/**
 * 트래킹 링크 목록 API의 응답을 매핑한 DTO 입니다.
 */
public class TrackingLinkListResponseDto {
    /** 응답 본문 */
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /**
     * 실제 데이터가 포함되는 내부 객체
     */
    public static class Data {
        /** 전체 항목 수 */
        private int totalCount;
        /** 조회된 ID 목록 */
        private List<Item> trackingLinks;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<Item> getTrackingLinks() {
            return trackingLinks;
        }

        public void setTrackingLinks(List<Item> trackingLinks) {
            this.trackingLinks = trackingLinks;
        }
    }

    /**
     * 목록 항목을 나타내는 객체
     */
    public static class Item {
        /** 트래킹 링크 ID */
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
