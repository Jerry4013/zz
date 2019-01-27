package zz.client;

import com.zzpublic.zwing.View;
import com.zzpublic.zwing.ViewFlow;
import com.zzpublic.zwing.Window;
import zz.client.ui.LogInWindow;
import zz.client.ui.LoginView;
import zz.client.ui.MainView;

public class Client {
    public static void main(String[] args) {
        View view = new LoginView();
        ViewFlow viewFlow = new ViewFlow();
        viewFlow.push(view);
        Window window = new Window(viewFlow);
        window.setVisible(true);
        window.setResizable(true);

//        LogInWindow logInWindow = new LogInWindow();
//        MainView mainView = new MainView();
//        ViewFlow viewFlow = new ViewFlow();
//
//        viewFlow.push(logInWindow);
//        Window window = new Window(viewFlow);
//        window.setLocation(400,150);
//
//        window.setVisible(true);
    }
}
