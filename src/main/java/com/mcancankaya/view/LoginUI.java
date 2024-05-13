package com.mcancankaya.view;

import com.mcancankaya.business.UserService;
import com.mcancankaya.core.Helper;
import com.mcancankaya.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;
    private JButton btn_login;
    private UserService userService;

    public LoginUI() {
        this.userService = new UserService();
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(400, 400);
        this.setVisible(true);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        this.btn_login.addActionListener(e -> {
            if (!Helper.isEmailValid(this.fld_mail.getText())) {
                Helper.showMessage("Geçerli bir e-posta giriniz.");
            }
            if (Helper.isFieldEmpty(this.fld_mail) || Helper.isFieldEmpty(this.fld_password)) {
                Helper.showMessage("fill");
            } else {
                User user = this.userService.findByLogin(this.fld_mail.getText(), this.fld_password.getText());
                if (Objects.isNull(user)) {
                    Helper.showMessage("Girdiğiniz bilgilere göre kullanıcı bulunamadı...");
                } else {
                    System.out.println(user.toString());
                }
            }
        });
    }
}
