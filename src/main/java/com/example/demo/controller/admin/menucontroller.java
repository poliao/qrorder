package com.example.demo.controller.admin;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.admin.menuitem;
import com.example.demo.service.admin.menuservice_add_admin;

@RestController
@RequestMapping("/admin/menus")
public class menucontroller {
    @Autowired
    private menuservice_add_admin menuService;

    @PostMapping
    public String createMenu(@RequestBody menuitem menuDTO) {
        return menuService.saveMenu(menuDTO);
    }

    @GetMapping
    public List<menuitem> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public Optional<menuitem> getMenuItemById(@PathVariable("id") Long id) {
        return menuService.getMenuItemById(id);
    }

    @PutMapping("/{id}")
    public String updateMenu(@PathVariable("id") Long id, @RequestBody menuitem menuDTO) {
        return menuService.updateMenu(id, menuDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteMenu(@PathVariable("id") Long id) {
        return menuService.deleteMenu(id);
    }
}
