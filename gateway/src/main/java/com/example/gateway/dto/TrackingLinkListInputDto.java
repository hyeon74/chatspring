package com.example.gateway.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 목록 API 호출 시 사용되는 쿼리 파라미터를 담는 DTO 입니다.
 */
public class TrackingLinkListInputDto {
    /** 조회 시작일 */
    private final String from;
    /** 조회 종료일 */
    private final String to;
    /** 건너뛸 항목 수 */
    private final Integer skip;
    /** 가져올 항목 수 */
    private final Integer size;
    /** 검색 키워드 */
    private final String keyword;
    /** 채널 명 */
    private final String channelName;
    /** 정렬 키 */
    private final String sortKey;
    /** 정렬 타입 */
    private final String sortType;

    public TrackingLinkListInputDto(String from, String to, Integer skip, Integer size,
                                  String keyword, String channelName, String sortKey, String sortType) {
        this.from = from;
        this.to = to;
        this.skip = skip;
        this.size = size;
        this.keyword = keyword;
        this.channelName = channelName;
        this.sortKey = sortKey;
        this.sortType = sortType;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getSkip() {
        return skip;
    }

    public Integer getSize() {
        return size;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getSortKey() {
        return sortKey;
    }

    public String getSortType() {
        return sortType;
    }

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
