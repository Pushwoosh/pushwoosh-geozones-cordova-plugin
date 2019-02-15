//
// PushwooshGeozones.java
//
// Pushwoosh, 15/02/19.
//
// Pushwoosh Geozones Plugin for Cordova Android
// www.pushwoosh.com
//
// MIT Licensed

package com.pushwoosh.geozones.plugin;

import com.pushwoosh.internal.utils.PWLog;
import com.pushwoosh.location.PushwooshLocation;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class PushwooshGeozones extends CordovaPlugin {
	public static final String TAG = "PushwooshGeozones";
	private static final Map<String, Method> exportedMethods;

	@Retention(RUNTIME)
	@interface CordovaMethod {

	}

	static {
		HashMap<String, Method> methods = new HashMap<String, Method>();

		final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(PushwooshGeozones.class.getDeclaredMethods()));
		for (final Method method : allMethods) {
			if (method.isAnnotationPresent(PushwooshGeozones.CordovaMethod.class)) {
				methods.put(method.getName(), method);
			}
		}

		exportedMethods = methods;
	}


	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackId)
	{
		PWLog.debug(TAG, "Plugin Method Called: " + action);

		Method method = exportedMethods.get(action);
		if (method == null)
		{
			PWLog.debug(TAG, "Invalid action : " + action + " passed");
			return false;
		}

		try
		{
			Boolean result = (Boolean) method.invoke(this, data, callbackId);
			return result;
		}
		catch (Exception e)
		{
			PWLog.error(TAG, "Failed to execute action : " + action, e);
			return false;
		}
	}

	@CordovaMethod
	private boolean startLocationTracking(JSONArray data, final CallbackContext callbackContext) {
		PushwooshLocation.startLocationTracking();
		return true;
	}

	@CordovaMethod
	private boolean stopLocationTracking(JSONArray data, final CallbackContext callbackContext)
	{
		PushwooshLocation.stopLocationTracking();
		return true;
	}

}
