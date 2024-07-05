package com.example.demo.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.admin.optiondetail_admin;
import com.example.demo.repository.admin.optiondetail_adminrepository;

@Service
public class optiondetailservice_admin {
    @Autowired
    private optiondetail_adminrepository optionDetailRepository;

    public List<optiondetail_admin> getAllOptionDetails() {
        return optionDetailRepository.findAll();
    }

    public optiondetail_admin saveOptionDetail(optiondetail_admin optionDetail) {
        return optionDetailRepository.save(optionDetail);
    }
}
