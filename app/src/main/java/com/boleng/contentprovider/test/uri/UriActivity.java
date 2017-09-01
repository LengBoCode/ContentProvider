package com.boleng.contentprovider.test.uri;

import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.boleng.contentprovider.R;

public class UriActivity extends AppCompatActivity {

    private String TAG = UriActivity.class.getSimpleName();
    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final String AUTHORITY = "com.lengbo";
    private static final int STUDENT_CODE = 100;
    private static final int STUDENT_ID_CODE = 101;


    static {
        uriMatcher.addURI(AUTHORITY, "student", STUDENT_CODE);
        uriMatcher.addURI(AUTHORITY, "student/#", STUDENT_ID_CODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        Uri uri = Uri.parse("context://" + AUTHORITY + "/student");
        Log.i(TAG, " " + uriMatcher.match(uri));
        uri = Uri.parse("context://" + AUTHORITY + "/student/"+9);
        Log.i(TAG, " " + uriMatcher.match(uri));
        Log.i(TAG,"  "+ContentUris.parseId(uri));
    }
}
