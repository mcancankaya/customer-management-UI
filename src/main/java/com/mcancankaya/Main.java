package com.mcancankaya;

import com.mcancankaya.core.Database;
import com.mcancankaya.core.Helper;
import com.mcancankaya.view.LoginUI;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Helper.setTheme();
        Connection conn = Database.getInstance();
        LoginUI loginUI = new LoginUI();
    }
}