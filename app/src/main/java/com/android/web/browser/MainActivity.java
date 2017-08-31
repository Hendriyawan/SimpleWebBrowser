package com.android.web.browser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	private EditText edit_text_url;
	private Button btn_go;
	private WebView web_view;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*EditText & Button*/
        edit_text_url = (EditText)findViewById(R.id.edit_text_url);
        btn_go = (Button)findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);
        /*WebView*/
        web_view = (WebView)findViewById(R.id.web_view);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new WebViewClient()
        {
        	@Override
            public void onPageFinished(WebView view, String url)
            {
            	edit_text_url.setText(url);
            }
        });
    }
    @Override
    public void onClick(View v)
    {
    	String url = edit_text_url.getText().toString();
        web_view.loadUrl(url);
    }
}
