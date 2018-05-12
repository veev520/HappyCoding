package club.veev.plugin.happycoding;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;

public interface IHappyWindow {

    Content getContent();
    void onCreate(Project project, ToolWindow toolWindow);
    void onAdded();
    void onSelectedChanged();
    void onRemoved(boolean b);
}
