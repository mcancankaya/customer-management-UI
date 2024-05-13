package com.mcancankaya.core;

import javax.swing.*;

public class Helper {
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fields) {
        for (JTextField field : fields) {
            return isFieldEmpty(field);
        }
        return false;
    }

    public static boolean isEmailValid(String mail) {
        if (mail == null || mail.trim().isEmpty()) return false;
        if (!mail.contains("@")) return false;
        String[] parts = mail.split("@");
        if (parts.length != 2) return false;
        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;
        if (!parts[1].contains(".") || parts[1].length() < 3) return false;
        return true;
    }

    public static void showMessage(String message) {
        String msg;
        String title;
        UIManager.put("OptionPane.okButtonText","Tamam");

        switch (message) {
            case "fill" -> {
                msg = "Lütfen tüm alanları doldurunuz !";
                title = "Hata";
            }
            case "done" -> {
                msg = "İşlem başarılı !";
                title = "Sonuç";
            }
            case "error" -> {
                msg = "Bir hata oluştu ! ";
                title = "Hata";
            }
            default -> {
                msg = message;
                title = "Mesaj";
            }
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
