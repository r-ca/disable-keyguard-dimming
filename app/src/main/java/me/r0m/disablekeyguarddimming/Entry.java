package me.r0m.disablekeyguarddimming;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;

public class Entry implements IXposedHookLoadPackage {
    private static final String SYSTEM_UI_PACKAGE = "com.android.systemui";

    private static final float KeyGuardDimAmount = 0f;

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(SYSTEM_UI_PACKAGE)) {
            return;
        }

        XposedBridge.log("DisableWallpaperDimmingModule: Loading for package " + lpparam.packageName);

        try {
            Class<?> scrimControllerClass = XposedHelpers.findClass("com.android.systemui.statusbar.phone.ScrimController", lpparam.classLoader);
//            XposedBridge.log("DisableWallpaperDimmingModule: Found ScrimController class.");

            XposedHelpers.findAndHookMethod(
                    scrimControllerClass,
                    "scheduleUpdate",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            try {
                                XposedHelpers.setFloatField(param.thisObject, "mScrimBehindAlphaKeyguard", KeyGuardDimAmount);
//                                XposedBridge.log("DisableWallpaperDimmingModule: Set mScrimBehindAlphaKeyguard to " + KeyGuardDimAmount);

                                Class<?> scrimStateClass = XposedHelpers.findClass("com.android.systemui.statusbar.phone.ScrimState", lpparam.classLoader);
                                Object[] enumConstants = scrimStateClass.getEnumConstants();

                                for (Object constant : enumConstants) {
                                    try {
                                        XposedHelpers.setFloatField(constant, "mScrimBehindAlphaKeyguard", KeyGuardDimAmount);
//                                        XposedBridge.log("DisableWallpaperDimmingModule: Set mScrimBehindAlphaKeyguard for " + constant.toString() + " to " + KeyGuardDimAmount);
                                    } catch (Throwable t) {
//                                        XposedBridge.log("DisableWallpaperDimmingModule: Error setting mScrimBehindAlphaKeyguard for " + constant.toString() + ": " + t);
                                    }
                                }
                            } catch (Throwable t) {
//                                XposedBridge.log("DisableWallpaperDimmingModule: Error in scheduleUpdate hook: " + t);
                            }
                        }
                    }
            );

            XposedBridge.log("DisableWallpaperDimmingModule: Successfully hooked scheduleUpdate methods in ScrimController.");

        } catch (Throwable t) {
            XposedBridge.log("DisableWallpaperDimmingModule: Failed to hook ScrimController: " + t);
        }
    }
}