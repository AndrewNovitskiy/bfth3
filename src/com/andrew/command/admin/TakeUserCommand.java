package com.andrew.command.admin;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.util.JspPathConstant.ADMIN_USER_JSP;

/**
 * Created by Andrew on 06.04.2017.
 */
public class TakeUserCommand implements Command {
    private static final Logger log = Logger.getLogger(TakeUserCommand.class);
    private UserDao dao;

    public TakeUserCommand() {
        super();
        dao = new UserDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        User user = dao.takeUserById(userId);
        request.setAttribute("user", user);
        return new ForwardAction(ADMIN_USER_JSP);
    }
}
