package mybatis.log.tail;

import com.intellij.execution.Executor;
import com.intellij.execution.ExecutorRegistry;
import com.intellij.icons.AllIcons;
import mybatis.log.Icons;
import mybatis.log.util.StringConst;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Window Config
 * @author ob
 */
public class TailRunExecutor extends Executor {
	public static final Icon ToolWindowRun = Icons.MyBatisIcon;

	public static final String TOOLWINDOWS_ID = "MyBatis Log";

	@Override
	@NotNull
	public String getStartActionText() {
		return TOOLWINDOWS_ID;
	}

	@Override
	public String getToolWindowId() {
		return TOOLWINDOWS_ID;
	}

	@Override
	public Icon getToolWindowIcon() {
		return ToolWindowRun;
	}

	@Override
	@NotNull
	public Icon getIcon() {
		return ToolWindowRun;
	}

	@Override
	public Icon getDisabledIcon() {
		return AllIcons.Process.DisabledRun;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	@NotNull
	public String getActionName() {
		return TOOLWINDOWS_ID;
	}

	@Override
	@NotNull
	public String getId() {
		return StringConst.PLUGIN_ID;
	}

	@Override
	public String getContextActionId() {
		return "MyBatisLogActionId";
	}

	@Override
	public String getHelpId() {
		return null;
	}

	public static Executor getRunExecutorInstance() {
		return ExecutorRegistry.getInstance().getExecutorById(StringConst.PLUGIN_ID);
	}
}
