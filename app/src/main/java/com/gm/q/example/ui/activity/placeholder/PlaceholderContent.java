package com.gm.q.example.ui.activity.placeholder;

import android.accounts.AccountAuthenticatorActivity;
import android.app.AliasActivity;
import android.app.ExpandableListActivity;
import android.app.LauncherActivity;
import android.app.ListActivity;
import android.app.NativeActivity;
import android.app.TabActivity;
import android.preference.PreferenceActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();


    static {
        addItem(new PlaceholderItem("AccountAuthenticatorActivity", AccountAuthenticatorActivity.class));
        addItem(new PlaceholderItem("AliasActivity", AliasActivity.class));
        addItem(new PlaceholderItem("ExpandableListActivity", ExpandableListActivity.class));
        addItem(new PlaceholderItem("LauncherActivity", LauncherActivity.class));
        addItem(new PlaceholderItem("ListActivity", ListActivity.class));
        addItem(new PlaceholderItem("PreferenceActivity", PreferenceActivity.class));
        addItem(new PlaceholderItem("NativeActivity", NativeActivity.class));
        addItem(new PlaceholderItem("TabActivity", TabActivity.class));
        addItem(new PlaceholderItem("androidx.activity.ComponentActivity 继承👇🏻", androidx.activity.ComponentActivity.class));
        addItem(new PlaceholderItem("androidx.core.app.ComponentActivity ", androidx.core.app.ComponentActivity.class));
        addItem(new PlaceholderItem("AppCompatActivity 继承👇🏻", AppCompatActivity.class));
        addItem(new PlaceholderItem("FragmentActivity", FragmentActivity.class));
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.content, item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String content;
        public final Class<?> activity;
        public String doc;

        public PlaceholderItem(String content, Class<?> activity) {
            this.content = content;
            this.activity = activity;
        }

        public PlaceholderItem(String content, String doc, Class<?> activity) {
            this.content = content;
            this.doc = doc;
            this.activity = activity;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}