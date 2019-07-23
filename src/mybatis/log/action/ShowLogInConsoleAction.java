package mybatis.log.action;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import mybatis.log.action.gui.FilterSetting;
import mybatis.log.action.gui.SqlText;
import mybatis.log.tail.TailContentExecutor;
import mybatis.log.util.ConfigUtil;
import mybatis.log.util.StringConst;
import org.apache.commons.lang.StringUtils;


/**
 * 插件入口
 *
 * @author ob
 */
public class ShowLogInConsoleAction extends DumbAwareAction {

    public ShowLogInConsoleAction(Project project) {
        super();
        ConfigUtil.init(project);
        ConfigUtil.settingDialog = new FilterSetting(project);
        ConfigUtil.sqlTextDialog = new SqlText(project);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) return;
    }

    public void showLogInConsole(final Project project) {
        if (project == null) return;
        ConfigUtil.setRunning(project, true);
        final TailContentExecutor executor = new TailContentExecutor(project);
        Disposer.register(project, executor);
        executor.withRerun(() -> showLogInConsole(project));
        executor.withStop(() -> {
            ConfigUtil.setRunning(project, false);
            ConfigUtil.setIndexNum(project, 1);
        }, () -> ConfigUtil.getRunning(project));
        executor.withFormat(() -> ConfigUtil.setSqlFormat(project, !ConfigUtil.getSqlFormat(project)));
        executor.withFilter(() -> {
            //启动filter配置
            FilterSetting dialog = ConfigUtil.settingDialog;
            dialog.pack();
            dialog.setSize(600, 400);//配置大小
            dialog.setLocationRelativeTo(null);//位置居中显示
            String[] filters = PropertiesComponent.getInstance(project).getValues(StringConst.FILTER_KEY);//读取过滤字符
            if (filters != null && filters.length > 0) {
                dialog.getTextArea().setText(StringUtils.join(filters, "\n"));
            }
            dialog.getPreparingTextField().setText(ConfigUtil.getPreparing(project));
            dialog.getParametersTextField().setText(ConfigUtil.getParameters(project));
            dialog.setVisible(true);
        });
        executor.withText(() -> {
            SqlText sqlText = ConfigUtil.sqlTextDialog;
            sqlText.pack();
            sqlText.setSize(1000, 600);//配置大小
            sqlText.setLocationRelativeTo(null);//位置居中显示
            sqlText.setVisible(true);
        });
        executor.run();
    }

}
