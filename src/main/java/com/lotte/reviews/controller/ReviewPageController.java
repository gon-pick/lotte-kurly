package com.lotte.reviews.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotte.crawling.dto.CrawlingCategoryDto;
import com.lotte.reviews.dto.ReviewDto;
import com.lotte.reviews.dto.ReviewInsertDto;
import com.lotte.reviews.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ReviewPageController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private ReviewService reviewService;

    public ReviewPageController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @ResponseBody
    @RequestMapping(value = "reviewList", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> reviewList() {
        logger.info("reviewList() " + new Date());

        List<ReviewDto> list = reviewService.ReviewList();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "reviewInsert", method = {RequestMethod.GET, RequestMethod.POST})
    public String reviewInsert(String userNo, String userNickName, String reviewTitle, String reviewContent, String productNo, String reviewRate) {
        logger.info("reviewInsert() " + new Date());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


        ReviewInsertDto dto = new ReviewInsertDto(Integer.parseInt(userNo), reviewContent, sdf.format(timestamp),
                sdf.format(timestamp), Integer.parseInt(reviewRate), Integer.parseInt(productNo), reviewTitle);
        System.out.println(dto.toString());

        return "Review Insert Success";
    }
}
