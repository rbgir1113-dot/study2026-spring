package com.app.restful.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CongestionDTO {
//    key이름이 같으면 생략이 가능
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("perpage")
    private Integer perpage;
    private Integer totalCount;
    private Integer currentCount;
    private Integer matchCount;

    @JsonProperty("data")
    private List<CongestionDataDTO> congestionList;


}
