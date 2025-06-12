package com.example.gateway.dto;

/**
 * 트래킹 링크 목록 조회 시 컨트롤러에서 사용하는 입력 DTO입니다.
 * 요청 파라미터를 바인딩한 후 서비스 계층에서 사용할 DTO로 변환합니다.
 */
public class TrackingLinkListRequestDto {
    /** 조회 시작일 */
    private String from;
    /** 조회 종료일 */
    private String to;
    /** 요청한 페이지 번호 */
    private Integer pagNo;
    /** 페이지당 항목 수 */
    private Integer pgaCnt;
    /** 검색 키워드 */
    private String keyword;
    /** 채널 명 */
    private String channelName;
    /** 정렬 키 */
    private String sortKey;
    /** 정렬 타입 */
    private String sortType;

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public Integer getPagNo() { return pagNo; }
    public void setPagNo(Integer pagNo) { this.pagNo = pagNo; }

    public Integer getPgaCnt() { return pgaCnt; }
    public void setPgaCnt(Integer pgaCnt) { this.pgaCnt = pgaCnt; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getChannelName() { return channelName; }
    public void setChannelName(String channelName) { this.channelName = channelName; }

    public String getSortKey() { return sortKey; }
    public void setSortKey(String sortKey) { this.sortKey = sortKey; }

    public String getSortType() { return sortType; }
    public void setSortType(String sortType) { this.sortType = sortType; }

    /**
     * 컨트롤러 DTO를 서비스 레이어에서 사용하는 DTO로 변환합니다.
     * <p>
     * 페이지 번호(`pagNo`)와 페이지 크기(`pgaCnt`)를 이용해 페이징에 필요한
     * `skip` 값을 계산합니다. `skip`은 (현재 페이지 - 1) * 페이지 크기
     * 공식으로 구하며, 이후 목록 API 호출에 사용됩니다.
     * 또한 `pgaCnt` 값은 목록 API의 `size` 파라미터로 그대로 전달되어 한
     * 번에 가져올 항목 수를 결정합니다.
     */
    public TrackingLinkListInputDto toServiceDto() {
        Integer skip = null;
        if (pagNo != null && pgaCnt != null) {
            // (페이지 번호 - 1) * 페이지 크기 = 건너뛸 항목 수
            skip = (pagNo - 1) * pgaCnt;
        }
        Integer size = pgaCnt;
        return new TrackingLinkListInputDto(from, to, skip, size,
                keyword, channelName, sortKey, sortType);
    }
}
