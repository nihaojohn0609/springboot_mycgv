package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.MemberService;
import com.springboot.mycgv.service.NoticeService;
import com.springboot.mycgv.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    PageService pageService;

    @Autowired
    MemberService memberService;

    @GetMapping("index")
    public String admin_index() {
        return "/admin/admin_index";
    }
    @GetMapping("notice_list/{page}")
    public String admin_notice_list(@PathVariable String list, @PathVariable String page, Model model) {
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "admin_notice"));
        model.addAttribute("admin_list", noticeService.list(pageDto));
        model.addAttribute("page", pageDto);
        return "/admin/admin_notice_list";
    }

    @GetMapping("notice_content/{nid}/{page}")
    public String admin_notice_content(@PathVariable String nid, @PathVariable String page, Model model) {
        return "/admin/admin_notice_content";
    }

    @GetMapping("notice_write")
    public String admin_notice_write() {
        return "/admin/admin_notice_write";
    }

    @GetMapping("notice_update/{nid}/{page}")
    public String admin_notice_update(@PathVariable String nid, @PathVariable String page, Model model) {
        return "/admin/admin_notice_update";
    }

    @GetMapping("notice_delete/{nid}/{page}")
     public String admin_notice_delete(@PathVariable String nid, @PathVariable String page, Model model) {
        return "/admin/admin_notice_delete";
    }

    @GetMapping("member_list/{page}")
    public String admin_member_list() {
        return "/admin/admin_member_list";
    }
}

