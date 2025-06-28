package org.seclass.greenroad.controller;
import org.seclass.greenroad.dto.Result;
import org.seclass.greenroad.entity.Greenroad;
import org.seclass.greenroad.entity.Student;
import org.seclass.greenroad.service.IGreenroadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greenroad")
public class GreenroadController {

    @Autowired
    private IGreenroadService greenroadService;

    @ResponseBody
    @PostMapping("/setgreenroad")
    public Result setGreenRoad(@RequestBody Greenroad greenroad){
        return greenroadService.setGreenroad(greenroad);
    }




}
