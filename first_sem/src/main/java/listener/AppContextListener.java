package listener;

import dao.DbConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            DbConnection.init();
            sce.getServletContext().setAttribute("dataSource", DbConnection.getDataSource());
            System.out.println();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DbConnection.destroy();
    }
}
