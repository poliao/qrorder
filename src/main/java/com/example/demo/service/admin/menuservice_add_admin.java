package com.example.demo.service.admin;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.admin.menuitem;
import com.example.demo.entity.admin.optiondetail_admin;
import com.example.demo.entity.admin.optionmenu_admin;
import com.example.demo.repository.admin.menuitem_adminrepository;

import jakarta.transaction.Transactional;

@Service
public class menuservice_add_admin {
    @Autowired
    private menuitem_adminrepository menuRepository;

    @Transactional
    public String saveMenu(menuitem menuDTO) {
        menuitem menu = new menuitem();
        menu.setNamemenu(menuDTO.getNamemenu());
        menu.setImg(menuDTO.getImg());
        menu.setPric(menuDTO.getPric());

        List<optionmenu_admin> optionMenus = menuDTO.getOptionsmenu().stream().map(optionmenuDTO -> {
            optionmenu_admin optionMenu = new optionmenu_admin();
            optionMenu.setOption_name(optionmenuDTO.getOption_name());
            optionMenu.setMenu(menu);

            List<optiondetail_admin> optionDetails = optionmenuDTO.getOptiondetail().stream().map(optiondetailDTO -> {
                optiondetail_admin optionDetail = new optiondetail_admin();
                optionDetail.setOptiondetail(optiondetailDTO.getOptiondetail());
                optionDetail.setOptionMenu(optionMenu);
                return optionDetail;
            }).collect(Collectors.toList());

            optionMenu.setOptiondetail(optionDetails);
            return optionMenu;
        }).collect(Collectors.toList());

        menu.setOptionsmenu(optionMenus);

        menuRepository.save(menu);

        return "สร้างเมนูสำเร็จ";
    }

    @Transactional
    public List<menuitem> getAllMenuItems() {
        return menuRepository.findAll();
    }

    @Transactional
    public Optional<menuitem> getMenuItemById(Long id) {
        return menuRepository.findById(id);
    }
}
