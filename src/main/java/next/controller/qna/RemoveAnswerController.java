package next.controller.qna;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import core.mvc.Controller;
import next.dao.AnswerDao;
import next.model.Result;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RemoveAnswerController implements Controller {

    Logger log = LoggerFactory.getLogger(RemoveAnswerController.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        AnswerDao answerDao = new AnswerDao();
        Result result = answerDao.remove(Long.parseLong(req.getParameter("answerId") .trim()));
        log.error(req.getParameter("answerId"));
        log.error(result.toString());

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(mapper.writeValueAsString(result));

        return null;
    }
}
