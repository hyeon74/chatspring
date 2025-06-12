package com.example.gateway.dto;

import java.util.List;

import com.example.gateway.dto.TrackingLinkDetailOutputDto;

/**
 * 페이징 처리된 트래킹 링크 상세 목록을 나타내는 DTO 입니다.
 */
public class TrackingLinkPageOutputDto {
    /** 전체 항목 수 */
    private final int allCnt;
    /** 현재 페이지의 상세 목록 */
    private final List<TrackingLinkDetailOutputDto> items;

    public TrackingLinkPageOutputDto(int allCnt, List<TrackingLinkDetailOutputDto> items) {
        this.allCnt = allCnt;
        this.items = items;
    }

    public int getAllCnt() {
        return allCnt;
    }

    public List<TrackingLinkDetailOutputDto> getItems() {
        return items;
    }
}
