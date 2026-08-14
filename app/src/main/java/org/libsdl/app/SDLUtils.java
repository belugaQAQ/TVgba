package org.libsdl.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;

/**
 * Small compatibility facade for the SDL 2 Android Java API used by the app.
 * SDL 2.30.9 exposes these operations through SDLActivity rather than SDLUtils.
 */
public final class SDLUtils {
    public static boolean mFullscreenModeActive;

    private SDLUtils() {
    }

    public static Config init(Context context, View gameView) {
        return new Config(context, gameView);
    }

    public static void onNativeKeyDown(int keyCode) {
        SDLActivity.onNativeKeyDown(keyCode);
    }

    public static void onNativeKeyUp(int keyCode) {
        SDLActivity.onNativeKeyUp(keyCode);
    }

    public static boolean dispatchKeyEvent(KeyEvent event) {
        return SDLActivity.handleKeyEvent(null, event.getKeyCode(), event, null);
    }

    public static final class Config {
        private final Context context;
        private final View gameView;
        private String[] libraries;
        private String[] arguments;

        private Config(Context context, View gameView) {
            this.context = context;
            this.gameView = gameView;
        }

        public Config setLibraries(String... libraries) {
            this.libraries = libraries;
            return this;
        }

        public Config setArguments(String... arguments) {
            this.arguments = arguments;
            return this;
        }
    }
}
