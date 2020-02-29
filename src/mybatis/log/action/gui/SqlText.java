package mybatis.log.action.gui;

import com.intellij.openapi.project.Project;
import mybatis.log.util.BareBonesBrowserLaunch;
import mybatis.log.util.ConfigUtil;
import mybatis.log.util.RestoreSqlUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ob
 * @email huanglingbin@chainfly.com
 * @date 2019/6/20
 */
public class SqlText extends JFrame {
    private static String preparingLine = "";
    private static String parametersLine = "";
    private static boolean isEnd = false;

    private JPanel panel1;
    private JButton buttonOK;
    private JButton buttonCopy;
    private JButton buttonClose;
    private JTextArea originalTextArea;
    private JTextArea resultTextArea;
    private JButton buttonClear;
    private JButton alipayDonate;
    private JButton githubButton;

    public SqlText(Project project) {
        this.setTitle("restore sql from text"); //设置标题
        setContentPane(panel1);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(e -> onOK(project));
        buttonCopy.addActionListener(e -> onCopy());
        buttonClear.addActionListener(e -> onClear());
        buttonClose.addActionListener(e -> onClose());

        alipayDonate.setContentAreaFilled(false);
        alipayDonate.addActionListener(e -> BareBonesBrowserLaunch.openURL("https://github.com/kookob/mybatis-log-plugin/blob/master/DONATE.md"));

        githubButton.setBorder(null);
        githubButton.setContentAreaFilled(false);
        githubButton.addActionListener(e -> BareBonesBrowserLaunch.openURL("https://github.com/kookob/mybatis-log-plugin"));

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });
        panel1.registerKeyboardAction(e -> onClose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(Project project) {
        if(originalTextArea == null || StringUtils.isBlank(originalTextArea.getText())) {
            this.resultTextArea.setText("Can't restore sql from text.");
            return;
        }
        String originalText = originalTextArea.getText();
        final String PREPARING = ConfigUtil.getPreparing(project);
        final String PARAMETERS = ConfigUtil.getParameters(project);
        if(originalText.contains(PREPARING) && originalText.contains(PARAMETERS)) {
            String[] sqlArr = originalText.split("\n");
            if(sqlArr != null && sqlArr.length >= 2) {
                String resultSql = "";
                for(int i=0; i<sqlArr.length; ++i) {
                    String currentLine = sqlArr[i];
                    if(StringUtils.isBlank(currentLine)) {
                        continue;
                    }
                    if(currentLine.contains(PREPARING)) {
                        preparingLine = currentLine;
                        continue;
                    } else {
                        currentLine += "\n";
                    }
                    if(StringUtils.isEmpty(preparingLine)) {
                        continue;
                    }
                    if(currentLine.contains(PARAMETERS)) {
                        parametersLine = currentLine;
                    } else {
                        if(StringUtils.isBlank(parametersLine)) {
                            continue;
                        }
                        parametersLine += currentLine;
                    }
                    if(!parametersLine.endsWith("Parameters: \n") && !parametersLine.endsWith("null\n") && !parametersLine.endsWith(")\n")) {
                        if(i == sqlArr.length -1) {
                            this.resultTextArea.setText("Can't restore sql from text.");
                            break;
                        }
                        continue;
                    } else {
                        isEnd = true;
                    }
                    if(StringUtils.isNotEmpty(preparingLine) && StringUtils.isNotEmpty(parametersLine) && isEnd) {
                        resultSql += RestoreSqlUtil.restoreSql(project, preparingLine, parametersLine) + "\n------------------------------------------------------------\n";
                    }
                }
                if(StringUtils.isNotEmpty(resultSql)) {
                    this.resultTextArea.setText(resultSql);
                }
            } else {
                this.resultTextArea.setText("Can't restore sql from text.");
            }
        } else {
            this.resultTextArea.setText("Can't restore sql from text.");
        }
    }

    private void onCopy() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(this.resultTextArea.getText());
        clipboard.setContents(selection, null);
    }

    private void onClear() {
        this.resultTextArea.setText("");
        this.originalTextArea.setText("");
    }

    private void onClose() {
        this.setVisible(false);
    }
}
