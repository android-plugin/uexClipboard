package org.zywx.wbpalmstar.plugin.uexclipboard;

import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.engine.universalex.EUExBase;
import org.zywx.wbpalmstar.engine.universalex.EUExCallback;

import android.content.Context;
import android.text.ClipboardManager;

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

	public void getContent(String[] params) {
		jsCallback(F_CALLBACK_GET_CONTENT, 0, EUExCallback.F_C_TEXT, clipboardManager.getText().toString());
	}

	@Override
	protected boolean clean() {
		return true;
	}

}