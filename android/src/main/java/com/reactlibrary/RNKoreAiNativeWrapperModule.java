
package com.reactlibrary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import kore.botssdk.activity.BotChatActivity;
import kore.botssdk.listener.BotSocketConnectionManager;
import kore.botssdk.net.SDKConfiguration;
import kore.botssdk.utils.BundleUtils;

public class RNKoreAiNativeWrapperModule extends ReactContextBaseJavaModule {
  private SharedPreferences sharedPreferences;
  private final String preferenceName = "MashreqPreferences";
  private final String BOT_ID = "BOT_ID";
  private final String BOT_NAME = "BOT_NAME";
  private final String IDENTITY = "IDENTITY";
  private final String AUTHORIZATION = "AUTHORIZATION";
  private final String XAUTH = "XAUTH";
  private final String JWT_SERVER_URL = "JWT_SERVER_URL";
  private final String KORE_BOT_SERVER_URL = "KORE_BOT_SERVER_URL";
  private final String SERVER_URL = "SERVER_URL";
  private final String Branding_SERVER_URL = "Branding_SERVER_URL";
  private final ReactApplicationContext reactContext;

  public RNKoreAiNativeWrapperModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    sharedPreferences = reactContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
  }

  @ReactMethod
  public void initialize(String bot_id, String bot_name, String authorisation, String xauth, String identity,
                          String serverUrl, String jwtUrl, String brandingUrl)
  {
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString(BOT_ID , bot_id);
      editor.putString(BOT_NAME, bot_name);
      editor.putString(AUTHORIZATION, authorisation);
      editor.putString(XAUTH, xauth);
      editor.putString(IDENTITY, identity);
      editor.putString(KORE_BOT_SERVER_URL, serverUrl);
      editor.putString(SERVER_URL, serverUrl);
      editor.putString(JWT_SERVER_URL, jwtUrl);
      editor.putString(Branding_SERVER_URL, brandingUrl);
      editor.apply();
  }

  @ReactMethod
  public void show()
  {
      SDKConfiguration.Client.bot_id = sharedPreferences.getString(BOT_ID, "");
      SDKConfiguration.Client.bot_name = sharedPreferences.getString(BOT_NAME, "");
      SDKConfiguration.Client.identity = sharedPreferences.getString(IDENTITY, "");
      SDKConfiguration.Server.JWT_SERVER_URL = sharedPreferences.getString(JWT_SERVER_URL, "");
      SDKConfiguration.Server.KORE_BOT_SERVER_URL = sharedPreferences.getString(KORE_BOT_SERVER_URL, "");
      SDKConfiguration.Server.SERVER_URL = sharedPreferences.getString(SERVER_URL, "");
      SDKConfiguration.Server.Branding_SERVER_URL = sharedPreferences.getString(Branding_SERVER_URL, "");

      BotSocketConnectionManager.getInstance().startAndInitiateConnectionWithConfig(reactContext, SDKConfiguration.Client.authorization, SDKConfiguration.Client.xauth);

      Intent intent = new Intent(reactContext, BotChatActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      Bundle bundle = new Bundle();
      //This should not be null
      bundle.putBoolean(BundleUtils.SHOW_PROFILE_PIC, false);
      bundle.putString(BundleUtils.BOT_NAME_INITIALS,SDKConfiguration.Client.bot_name.charAt(0)+"");
      intent.putExtras(bundle);
      reactContext.startActivity(intent);
  }

  @Override
  public String getName() {
    return "RNKoreAiNativeWrapper";
  }
}