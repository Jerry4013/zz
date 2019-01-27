package zz.client.ui;

import com.zzpublic.zwing.Button;
import com.zzpublic.zwing.Label;
import com.zzpublic.zwing.TextField;
import com.zzpublic.zwing.View;
import zz.common.model.TodoItem;
import zz.common.model.TodoList;
import zz.client.service.TodoListService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class MainView extends View{

    class AddingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(textField.getText().equals(""))
                JOptionPane.showMessageDialog(null,"Can not add an empty item.",
                        "Wrong",  JOptionPane.ERROR_MESSAGE);
            else{
                TodoItem todoItem = new TodoItem(textField.getText());
                todoListService.add(todoItem);
                textField.setText("");
                dataToView();
            }
        }
    }

    class EditingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String inputValue = JOptionPane.showInputDialog("Please input a value");
            todoListService.set(Integer.parseInt(e.getActionCommand())-1, new TodoItem(inputValue));
            dataToView();
        }
    }

    class DeleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int res = JOptionPane.showConfirmDialog(null,
                    "Are you sure deleting this item?","confirm",
                    JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION) {
                todoListService.delete(Integer.parseInt(e.getActionCommand())-1);
                dataToView();
            }else
                return;
        }
    }

    // mark - service

    private TodoListService todoListService = new TodoListService();

    // mark - views

    private static final int paddingNormal = 10;
    private static final int paddingSmall = 5;
    private static final int cellWidth = 100;
    private static final int cellHeight = 30;
    private static final int panelHeight = 40;

    private static final int windowPadding = 40;

    private Label titleLabel;
    private Button addButton;
    private TextField textField;
    private View containerView;

    protected void initSubviews(){
        super.initSubviews();

        titleLabel = new Label();
        titleLabel.setLocation(paddingNormal, paddingNormal);
        titleLabel.setSize(this.getWidth() - 2 * paddingNormal, cellHeight);
        titleLabel.setText("");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);

        View inputView = new View();
        inputView.setSize(this.getWidth(), panelHeight);
        inputView.setLocation(0, this.getHeight() - inputView.getHeight() - windowPadding);
        this.add(inputView);

        addButton = new Button("Add");
        addButton.setSize(cellWidth,cellHeight);
        addButton.setLocation(inputView.getWidth() - paddingSmall - addButton.getWidth(), paddingSmall);
        inputView.add(addButton);


        textField = new TextField();
        textField.setSize(addButton.getX() - 2 * paddingSmall, cellHeight);
        textField.setLocation(paddingSmall, paddingSmall);
        inputView.add(textField);
    }

    @Override
    protected void initEvents() {
        super.initEvents();
        AddingListener addingListener = new AddingListener();
        addButton.addActionListener(addingListener);
        textField.addActionListener(addingListener);
    }

    @Override
    protected void viewDidDisplay() {
        super.viewDidDisplay();
        dataToView();
    }

    private void dataToView(){
        TodoList todoList = todoListService.get();
        titleLabel.setText(todoList.getTitle());

        if (containerView != null){
            this.remove(containerView);
        }
        containerView = new View();

        containerView.setLocation(0, titleLabel.getY() + titleLabel.getHeight() + paddingNormal);
        containerView.setSize(this.getWidth(),
                this.getHeight() - windowPadding - containerView.getY() - panelHeight);
        this.add(containerView);

        int y = 0;

        LinkedList<TodoItem> items = todoList.getItems();

        int itemID = 0;
        for(TodoItem item : items){
            itemID++;

            Button edit = new Button("Edit");
            Button delete = new Button("Delete");
            edit.setSize(cellWidth, cellHeight);
            delete.setSize(cellWidth, cellHeight);
            edit.setLocation(this.getWidth() - edit.getWidth() - delete.getWidth() - 2 * paddingNormal, y);
            delete.setLocation(this.getWidth() - delete.getWidth() - paddingNormal, y);
            edit.setActionCommand(Integer.toString(itemID));
            delete.setActionCommand(Integer.toString(itemID));
            containerView.add(edit);
            containerView.add(delete);

            DeleteListener deleteListener = new DeleteListener();
            delete.addActionListener(deleteListener);

            EditingListener editingListener = new EditingListener();
            edit.addActionListener(editingListener);

            Label label = new Label();
            label.setText(item.getText());
            label.setLocation(paddingNormal, y);
            label.setSize(this.getWidth() - 2 * paddingNormal - 2* edit.getWidth(), cellHeight);
            containerView.add(label);

            y += label.getHeight() + paddingNormal;
        }

    }
}
