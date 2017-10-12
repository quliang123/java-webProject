package controllerupload;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by 123 on 2017/09/04.
 */
@Controller
public class TwoController {

    @RequestMapping("/two")
    public String doFirst(MultipartFile[] file, HttpSession session) {
        for (MultipartFile item : file) {
            if (item.getSize() > 0) {
                try {
                    item.transferTo(new File(session.getServletContext().getRealPath("/upload"), item.getOriginalFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                    return "/upload.jsp";
                }

            } else {
                return "/upload.jsp";
            }
        }
        return "/1.jsp";
    }
}
