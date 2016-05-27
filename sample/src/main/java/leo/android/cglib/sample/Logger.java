package leo.android.cglib.sample;

import android.util.Log;

public class Logger {

	public static String TAG = "cglib";
	
	/** If don't want print out log, could set level > Log.ASSERT **/
	private static int LEVEL = Log.VERBOSE;

	private static String getMethodName() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		if (sts == null) {
			return null;
		}
		String clsName = null;
		for (StackTraceElement st : sts) {
			if (st.isNativeMethod()) {
				continue;
			}
			clsName = st.getClassName();
			if (clsName.equals(Thread.class.getName())) {
				continue;
			}
			if (clsName.equals(Logger.class.getName())) {
				continue;
			}
			return "[" + Thread.currentThread().getName() + ":"
					+ st.getFileName() + ":" + st.getLineNumber() + " "
					+ st.getMethodName() + "]";
		}
		return null;
	}

	public static void i(Object str) {
		if (LEVEL <= Log.INFO) {
			String name = getMethodName();
			if (name != null) {
				Log.i(TAG, name + str);
			} else {
				Log.i(TAG, str.toString());
			}
		}
	}

	public static void v(Object str) {
		if (LEVEL <= Log.VERBOSE) {
			String name = getMethodName();
			if (name != null) {
				Log.v(TAG, name + str);
			} else {
				Log.v(TAG, str.toString());
			}
		}
	}

	public static void w(Object str) {
		if (LEVEL <= Log.WARN) {
			String name = getMethodName();
			if (name != null) {
				Log.w(TAG, name + str);
			} else {
				Log.w(TAG, str.toString());
			}
		}
	}

	public static void e(Object str) {
		if (LEVEL <= Log.ERROR) {
			String name = getMethodName();
			if (name != null) {
				Log.e(TAG, name + str);
			} else {
				Log.e(TAG, str.toString());
			}
		}
	}

	public static void e(Exception ex) {
		if (LEVEL <= Log.ERROR) {
			Log.e(TAG, "error", ex);
		}
	}

	public static void e(String log, Throwable tr) {
		String line = getMethodName();
		Log.e(TAG, "{Thread:" + Thread.currentThread().getName() + "}"
				+ "[" + line + ":] " + log + "\n", tr);
	}

	public static void d(Object str) {
		if (LEVEL <= Log.DEBUG) {
			String name = getMethodName();
			if (name != null) {
				Log.d(TAG, name + str);
			} else {
				Log.d(TAG, str.toString());
			}
		}
	}

}
