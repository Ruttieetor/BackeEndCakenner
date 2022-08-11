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




    public String SaveFile(MultipartFile imageFile) throws IOException {

        String filename = imageFile.getOriginalFilename();
        String folder =  "C:\\Users\\rutge\\IdeaProjects\\BackEndCakenner\\images";
        byte[] bytes = imageFile.getBytes();
        Path path =Paths.get(folder +"\\"+ filename);
        Files.write(path, bytes);
        String url = "http://localhost:8080/images/" + filename;
        return url;
    }
}
