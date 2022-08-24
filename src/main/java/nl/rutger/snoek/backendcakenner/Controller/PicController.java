package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@CrossOrigin
@RestController
public class PicController {

    @Autowired
    private PicService picservice;


    @PostMapping("/imageUpload")
    public String uploadImage(@RequestParam("imageFile")MultipartFile imageFile){



        try{
            return picservice.SaveFile(imageFile);
        } catch(IOException e){
            System.out.println("bruhhh");
            e.printStackTrace();

            String error = "error";
            return error;
        }

    }

}
