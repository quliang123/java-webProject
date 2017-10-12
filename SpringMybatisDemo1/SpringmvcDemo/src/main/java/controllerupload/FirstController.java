package controllerupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by 123 on 2017/08/30.
 */

@Controller
public class FirstController {

    @RequestMapping(value = "/first")
    public String doFirst(MultipartFile file, HttpSession session)  {

        try {
            file.transferTo(new File(session.getServletContext().getRealPath("/upload"), file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
            return "/upload.jsp";
        }
        return "/1.jsp";
    }
}
