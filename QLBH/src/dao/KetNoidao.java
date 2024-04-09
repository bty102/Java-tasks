package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * KetNoidao
 */
public class KetNoidao {

    Connection cn;
    public void ketNoi() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Da xac dinh HQTCSDL");
        cn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-94HP78LH\\BTY:1433;databaseName=BaiTap;user=sa;password=123;encrypt=false");
        System.out.println("Da ket noi vao CSDL");
    }

    public static void main(String[] args) {
        try {
            KetNoidao kn = new KetNoidao();
            kn.ketNoi();
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }
}
