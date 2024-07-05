package com.example.demo.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.admin.menuitem;
import com.example.demo.repository.admin.menuitem_adminrepository;

@Service
public class menuitemservice_admin {
    @Autowired
    private menuitem_adminrepository menuRepository;

    public List<menuitem> getAllMenus() {
        return menuRepository.findAll();
    }

    public menuitem saveMenu(menuitem menu) {
        return menuRepository.save(menu);
    }
}
