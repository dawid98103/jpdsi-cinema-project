package pl.paw.cinema.controller.error;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private static final String PATH = "/error";
    private final ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, true);
        final StringBuilder errorDetails = new StringBuilder();
        errorAttributes.forEach((attribute, value) -> errorDetails.append("<tr><td>")
                .append(attribute)
                .append("</td><td><pre>")
                .append(value)
                .append("</pre></td></tr>"));

        return String.format("<html><head><style>td{vertical-align:top;border:solid 1px #666;}</style>"
                + "</head><body><h2>Error Page</h2><table>%s</table></body></html>", errorDetails.toString());
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
