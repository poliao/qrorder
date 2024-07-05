package com.example.demo.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.admin.optionmenu_admin;
import com.example.demo.repository.admin.optionmenu_adminrepository;

@Service
public class optionmenuservice_admin {
    @Autowired
    private optionmenu_adminrepository optionMenuRepository;

    public List<optionmenu_admin> getAllOptionMenus() {
        return optionMenuRepository.findAll();
    }

    public optionmenu_admin saveOptionMenu(optionmenu_admin optionMenu) {
        return optionMenuRepository.save(optionMenu);
    }
}
