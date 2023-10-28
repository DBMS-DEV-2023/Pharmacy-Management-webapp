package com.pharmacy.pharmacymanagementsystem.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.pharmacy.pharmacymanagementsystem.models.Category;
import com.pharmacy.pharmacymanagementsystem.models.IncreaseMedicationStock;
import com.pharmacy.pharmacymanagementsystem.models.MedicationStock;
import com.pharmacy.pharmacymanagementsystem.service.AdminService;
import com.pharmacy.pharmacymanagementsystem.service.MessageService;

import jakarta.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;


@Controller
public class AdminDashboardController extends Helper {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MessageService messageService;

    @GetMapping("admindashboard")
    public String AdminDashboard(Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }
        model.addAttribute("categories", adminService.getCategories());
        model.addAttribute("category", new Category());
        
        return "AdminDashboard";
    }
    
    
    @PostMapping("addcategory")
    public String AddCategory(@ModelAttribute Category category, Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }

        adminService.addCategory(category);
        return "redirect:/admindashboard";
    }

    @GetMapping("{catId}/delcategory")
    public String DeleteCategory(@PathVariable("catId") int catId,Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }

        adminService.DeleteCategory(catId);
        return "redirect:/admindashboard";
    }


    @GetMapping("{catId}_viewmedicine")
    public String ViewMedicine(@PathVariable("catId") int catId,Model model, HttpSession session, RedirectAttributes attributes)
    {
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }
        model.addAttribute("medicines", adminService.getMedicinesByCategoryId(catId));
        Category category=adminService.getCategoryById(catId);
        model.addAttribute("category", category);
        model.addAttribute("quantity", new IncreaseMedicationStock());

        return "viewmedicine";
    }
    @GetMapping("{catId}_addmedicine")
    public String addMedicationStock(@PathVariable("catId") int catId,Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }

        Category category=adminService.getCategoryById(catId);
        
        model.addAttribute("medicine", new MedicationStock());
        model.addAttribute("category", category);
        return "addmedicine";
    }

    @PostMapping("{catId}/addmedicine")
    public String PostaddMedicationStock(@PathVariable("catId") int catId,@ModelAttribute MedicationStock medicine, Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }

        Category category=adminService.getCategoryById(catId);
        adminService.addMedicationStock(medicine,category);
        messageService.redirectWithSuccess(attributes, "Medicine added to "+category.getCat_name());
        return "redirect:/{catId}_viewmedicine";
    }
    
    @GetMapping("{catId}/{id}/delmedicine")
    public String DeleteMedicine(@PathVariable("id") int id,@PathVariable("catId") int catId,Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }
        // Category category=adminService.getCategoryById(catId);
        adminService.deleteMedicine(id);
        return "redirect:/{catId}_viewmedicine";
    }
    @GetMapping("{catId}_{id}_restock")
    public String addRestock(@PathVariable("catId") int catId,@PathVariable("id") int id,Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }

        Category category=adminService.getCategoryById(catId);
        MedicationStock medicine=adminService.getMedicineById(id);
        model.addAttribute("quantity", new IncreaseMedicationStock());
        model.addAttribute("category", category);
        model.addAttribute("medicine", medicine);

        return "addrestock";
    }
    
    @PostMapping("{catId}/{id}/restock")
    public String PostAddRestock(@PathVariable("id") int id,@PathVariable("catId") int catId,@ModelAttribute IncreaseMedicationStock quantity, Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }

        MedicationStock medicine=adminService.getMedicineById(id);
        adminService.restock(medicine, quantity);
        return "redirect:/{catId}_viewmedicine";
    }
    
    @GetMapping("adminorders")
     public String AdminOrders(Model model, HttpSession session, RedirectAttributes attributes){
        if (!isAuthenticated(session)) {
            return "redirect:/";
        }
        model.addAttribute("orders", adminService.getOrders());
        List<Integer> amountlist= adminService.getOrders().stream().map(order->order.getTotal_amount()).collect(Collectors.toList());
        List<Date> datelist= adminService.getOrders().stream().map(order->order.getOrder_date()).collect(Collectors.toList());
        model.addAttribute("amount",amountlist);
        model.addAttribute("date", datelist);
        // List<Customer> c=new ArrayList<Customer>();
        // for(Order o:adminService.getOrders())
        // {
        //     c.add(adminService.getCustomerById(o.getCustomer_id()));
        // }
        // model.addAttribute("customers", c);
        return "AdminOrders";
    }


}
