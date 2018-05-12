package club.veev.plugin.happycoding;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;

public class MainWindow implements IHappyWindow {
    private Content mContent;
    private JPanel mComponent;

    public MainWindow() {
        mContent = ContentFactory.SERVICE.getInstance().createContent(mComponent, getTitle(), false);
    }

    @Override
    public void onCreate(Project project, ToolWindow toolWindow) {

    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRemoved(boolean b) {

    }

    @Override
    public void onSelectedChanged() {
        if (mContent.isSelected()) {
            System.out.println(getTitle() + " 我被选中了");
        } else {
            System.out.println(getTitle() + " 我没有被选中");
        }
    }

    @Override
    public Content getContent() {
        return mContent;
    }

    public String getTitle() {
        return "Main";
    }
}
