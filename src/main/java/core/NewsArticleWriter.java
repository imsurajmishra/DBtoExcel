package core;

import connection.JDBCConnection;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.ExcelUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsArticleWriter {


    public void writeToSheet(ResultSet newsArticles, String sheetName) throws SQLException, IOException {
        XSSFSheet dailyNewsArticleSheet = ExcelUtils.createSheet(sheetName);
        int rowNumber = 0;
        while (newsArticles.next()) {
            createRow(newsArticles, dailyNewsArticleSheet, rowNumber);
            rowNumber++;
        }
    }

    private void createRow(ResultSet newsArticles, XSSFSheet dailyNewsArticleSheet, int rowNumber) throws SQLException {
        String title = newsArticles.getString("title");
        String link = newsArticles.getString("link");

        Row row = dailyNewsArticleSheet.createRow(rowNumber);
        ExcelUtils.setRow(row,title,link);
    }

    public void writeToFile(FileOutputStream out) throws IOException {
        ExcelUtils.write(out);
        out.close();
    }
}
