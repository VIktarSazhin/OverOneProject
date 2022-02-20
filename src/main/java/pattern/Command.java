package pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
     String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException;
}
