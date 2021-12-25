package com.cinema.web.controller.session.dto;

import lombok.Data;

import java.util.List;

/**
 * @author chenguo
 * @date 2021/12/24 10:29 上午
 */
@Data
public class ManageDto {
    private List<String> cinemaIds;
    private List<String> hallIds;
    private List<String> movieIds;
}
