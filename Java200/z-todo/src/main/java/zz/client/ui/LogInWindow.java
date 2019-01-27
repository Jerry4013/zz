package zz.client.ui;

import com.zzpublic.zwing.Button;
import com.zzpublic.zwing.Label;
import com.zzpublic.zwing.TextField;
import com.zzpublic.zwing.View;
import zz.client.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInWindow extends View {

    private static final int paddingNormal = 30;
    private static final int cellHeight = 30;
    private static final int TEXT_FIELD_WIDTH = 200;
    private static final int LABEL_WIDTH = 100;
    private static final int BUTTON_WIDTH = 100;
    private static final int TEXT_X = 350;
    private static final int TEXT_Y = 100;

    private Label username;
    private TextField usernameText;
    private Label password;
    private TextField passwordText;
    private Button register;
    private Label registerResult;

    private UserService userService = new UserService();


    protected void initSubviews(){
        super.initSubviews();

        usernameText = new TextField();
        usernameText.setSize(TEXT_FIELD_WIDTH, cellHeight);
        usernameText.setLocation(TEXT_X, TEXT_Y);
        this.add(usernameText);

        username = new Label();
        username.setSize(LABEL_WIDTH, cellHeight);
        username.setLocation(usernameText.getX() - username.getWidth(),
                TEXT_Y);
        username.setText("User name");
        this.add(username);

        passwordText = new TextField();
        passwordText.setSize(TEXT_FIELD_WIDTH, cellHeight);
        passwordText.setLocation(TEXT_X, TEXT_Y + cellHeight + paddingNormal);
        this.add(passwordText);

        password = new Label();
        password.setSize(LABEL_WIDTH, cellHeight);
        password.setLocation(passwordText.getX() - password.getWidth(),
                passwordText.getY());
        password.setText("Password");
        this.add(password);

        register = new Button("Register");
        register.setSize(BUTTON_WIDTH, cellHeight);
        register.setLocation(password.getX()+20,
                password.getY()+password.getHeight()+cellHeight);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameText.getText().trim().equals("") ||
                        passwordText.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Username or password is empty, please try again.",
                            "Error",  JOptionPane.ERROR_MESSAGE);
                }else{
                     boolean result = userService.register(usernameText.getText(),
                             passwordText.getText());
                    if (!result) {
                        JOptionPane.showMessageDialog(null,
                                "This username has been used, please try again.",
                                "Error",  JOptionPane.ERROR_MESSAGE);

                    }else{
                        registerResult = new Label("Registered successfully!");
                        registerResult.setForeground(Color.GREEN);
                        registerResult.setSize(LABEL_WIDTH*3, cellHeight*2);
                        registerResult.setFontSize(18);
                        registerResult.setLocation(register.getX(),register.getY() + register.getHeight()
                                + cellHeight);
                        add(registerResult);
                    }

                }
            }
        });
        this.add(register);






    }

}
