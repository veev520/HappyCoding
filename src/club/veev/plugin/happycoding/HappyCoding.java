package club.veev.plugin.happycoding;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentManagerAdapter;
import com.intellij.ui.content.ContentManagerEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HappyCoding implements ToolWindowFactory {

    private ToolWindow mToolWindow;
    private List<IHappyWindow> mContentList;

    private ContentManagerAdapter mContentManagerAdapter = new ContentManagerAdapter() {
        @Override
        public void contentAdded(ContentManagerEvent event) {
            for (IHappyWindow window : mContentList) {
                if (event.getContent() == window.getContent()) {
                    window.onAdded();
                }
            }
        }

        @Override
        public void selectionChanged(ContentManagerEvent event) {
            for (IHappyWindow window : mContentList) {
                if (event.getContent() == window.getContent()) {
                    window.onSelectedChanged();
                }
            }
        }
    };

    public HappyCoding() {
        System.out.println("Constructor");
        mContentList = new ArrayList<>();

        mContentList.add(new MainWindow());
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        System.out.println("create");

        mToolWindow = toolWindow;

        toolWindow.getContentManager().addContentManagerListener(mContentManagerAdapter);

        for (IHappyWindow window : mContentList) {
            toolWindow.getContentManager().addContent(window.getContent());
            window.onCreate(project, toolWindow);
        }
    }

    @Override
    public void init(ToolWindow window) {
        System.out.println("init");
    }
}
