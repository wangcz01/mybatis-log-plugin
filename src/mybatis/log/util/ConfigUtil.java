package mybatis.log.util;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;
import mybatis.log.action.gui.SqlText;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置项参数
 *
 * @author ob
 */
public class ConfigUtil {
    public static boolean active = false;
    public static SqlText sqlTextDialog;
    public static Map<String, ConsoleView> consoleViewMap = new HashMap<>();

    public static void init(Project project) {
        if(project != null) {
            setRunning(project, false);
            setSqlFormat(project, false);
            setIndexNum(project, 1);
            setPreparing(project, StringConst.PREPARING);
            setParameters(project, StringConst.PARAMETERS);
        }
    }

    public static void setRunning(Project project, boolean value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.runningKey, value);
    }

    public static void setSqlFormat(Project project, boolean value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.sqlFormatKey, value);
    }

    public static void setIndexNum(Project project, int value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.indexNumKey, value, 1);
    }

    public static boolean getRunning(Project project) {
        return PropertiesComponent.getInstance(project).getBoolean(StringConst.runningKey);
    }

    public static boolean getSqlFormat(Project project) {
        return PropertiesComponent.getInstance(project).getBoolean(StringConst.sqlFormatKey);
    }

    public static int getIndexNum(Project project) {
        return PropertiesComponent.getInstance(project).getInt(StringConst.indexNumKey, 1);
    }

    public static String getPreparing(Project project) {
        if(project == null) {
            return StringConst.PREPARING;
        }
        return PropertiesComponent.getInstance(project).getValue(StringConst.PREPARING_KEY);
    }

    public static String getParameters(Project project) {
        if(project == null) {
            return StringConst.PARAMETERS;
        }
        return PropertiesComponent.getInstance(project).getValue(StringConst.PARAMETERS_KEY);
    }

    public static void setPreparing(Project project, String value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.PREPARING_KEY, value);
    }

    public static void setParameters(Project project, String value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.PARAMETERS_KEY, value);
    }

    public static int getStartup(Project project) {
        return PropertiesComponent.getInstance(project).getInt(StringConst.STARTUP_KEY, 1);
    }

    public static void setStartup(Project project, int value) {
        PropertiesComponent.getInstance(project).setValue(StringConst.STARTUP_KEY, value, 1);
    }
}
