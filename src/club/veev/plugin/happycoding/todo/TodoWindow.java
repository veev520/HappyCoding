package club.veev.plugin.happycoding.todo;

import club.veev.plugin.happycoding.IHappyWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;

public class TodoWindow implements IHappyWindow {
    private Content mContent;

    private JPanel mComponent;
    private JTextField mTextField1;
    private JList mList1;

    @Override
    public Content getContent() {
        return mContent;
    }

    @Override
    public void onCreate(Project project, ToolWindow toolWindow) {
        mContent = ContentFactory.SERVICE.getInstance().createContent(mComponent, getTitle(), false);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onSelectedChanged() {

    }

    @Override
    public void onRemoved(boolean b) {

    }

    public String getTitle() {
        return "Todo";
    }
}
