package com.example.gateway.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 목록 API 호출 시 사용되는 쿼리 파라미터를 담는 DTO 입니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingLinkListInputDto {
    /** 조회 시작일 */
    private String from;
    /** 조회 종료일 */
    private String to;
    /** 건너뛸 항목 수 */
    private Integer skip;
    /** 가져올 항목 수 */
    private Integer size;
    /** 검색 키워드 */
    private String keyword;
    /** 채널 명 */
    private String channelName;
    /** 정렬 키 */
    private String sortKey;
    /** 정렬 타입 */
    private String sortType;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);
        if (skip != null) map.put("skip", skip);
        if (size != null) map.put("size", size);
        if (keyword != null) map.put("keyword", keyword);
        if (channelName != null) map.put("channel_name", channelName);
        if (sortKey != null) map.put("sort_key", sortKey);
        if (sortType != null) map.put("sort_type", sortType);
        return map;
    }
}
