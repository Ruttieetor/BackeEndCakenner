package nl.rutger.snoek.backendcakenner.Service;


import antlr.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PicService {



//Does not use any repository and instead uses a local file to save the images
    // function gives the url for the picture back so that the frontend can use this.
    public String SaveFile(MultipartFile imageFile) throws IOException {

        String filename = imageFile.getOriginalFilename();
        // EDIT STRUNG UNDER THIS COMMENT TO THE DIRECT PATH OF UR PICTURE FOLDER
        String folder =  "C:\\Users\\rutge\\IdeaProjects\\BackEndCakenner\\images";
        //------------------------------------------------------------------------
        byte[] bytes = imageFile.getBytes();
        Path path =Paths.get(folder +"\\"+ filename);
        Files.write(path, bytes);
        String url = "http://localhost:8080/images/" + filename;
        return url;
    }
}
