import connection.JDBCConnection;
import core.NewsArticleWriter;
import dao.NewsArticleDao;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.ExcelUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class DataExport {

    private static String SELECT_QUERY = "select title, link from NEWS_ARTICLES";
    static NewsArticleDao newsArticleDao = new NewsArticleDao();
    static NewsArticleWriter newsArticleWriter = new NewsArticleWriter();

    public static void main(String[] args) throws SQLException, IOException {
        ResultSet newsArticles = newsArticleDao.getNewsArticles(SELECT_QUERY);

        newsArticleWriter.writeToSheet(newsArticles,"daily_news_articles");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("news_article_lists.xlsx"));
        newsArticleWriter.writeToFile(fileOutputStream);
    }
}
