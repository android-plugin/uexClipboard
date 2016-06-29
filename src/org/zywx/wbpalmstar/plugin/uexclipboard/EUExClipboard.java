package org.zywx.wbpalmstar.plugin.uexclipboard;

import android.content.Context;
import android.text.ClipboardManager;

import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.engine.universalex.EUExBase;
import org.zywx.wbpalmstar.engine.universalex.EUExCallback;

public class EUExClipboard extends EUExBase {

    public static final String F_CALLBACK_GET_CONTENT = "uexClipboard.cbGetContent";
    private ClipboardManager clipboardManager;

    public EUExClipboard(Context context, EBrowserView inParent) {
        super(context, inParent);
        clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    /**
     * params[0]--->内容
     *
     * @param params
     */
    public void copy(String[] params) {
        if (params.length > 0) {
            clipboardManager.setText(params[0]);
        }
    }


    public String getContent(String[] params) {
        String value=clipboardManager.getText().toString();
        jsCallback(F_CALLBACK_GET_CONTENT, 0, EUExCallback.F_C_TEXT, value.replace("\n","\\n"));
        return value;
    }

    @Override
    protected boolean clean() {
        return true;
    }

}