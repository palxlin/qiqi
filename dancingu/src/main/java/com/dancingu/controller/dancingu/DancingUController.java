package com.dancingu.controller.dancingu;

import com.dancingu.model.Answer;
import com.dancingu.model.QueryVo;
import com.dancingu.model.UploadRequest;
import com.dancingu.service.dancingu.IDancingUService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fanlin on 2017/10/23.
 */
@Controller
@RequestMapping(value = "")
public class DancingUController {

    private static final Logger logger = LoggerFactory.getLogger(DancingUController.class);

    @Autowired
    IDancingUService dancingUService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("user") String user, @RequestParam("question") String question, @RequestParam("answer") String answer) {

        UploadRequest uploadRequest = new UploadRequest(user, question, answer);

        dancingUService.upload(uploadRequest);

        return "uploading...";
    }

    @RequestMapping(value = "query", method = RequestMethod.POST, consumes = "text/html;charset=UTF-8")
    @ResponseBody
    public String query(@RequestBody QueryVo queryVo) {

        return "query...";
    }


    @RequestMapping(value = "upload", method = RequestMethod.GET)
    @ResponseBody
    public String uploadGet(@RequestParam("user") String user, @RequestParam("question") String question, @RequestParam("answer") String answer) {

        UploadRequest uploadRequest = new UploadRequest(user, question, answer);

        dancingUService.upload(uploadRequest);

        return "uploading...";
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public String queryGet(@RequestBody QueryVo queryVo) {

        return "query...";
    }
}
