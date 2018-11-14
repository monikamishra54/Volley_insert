package com.example.mgc.volley_insert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
Button b1;
    EditText t1,t2,t3;
    String name,email,mobile;
    String url="https://monikamishra.000webhostapp.com/insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText) findViewById(R.id.editText1);
        t2=(EditText) findViewById(R.id.editText2);
        t3=(EditText) findViewById(R.id.editText3);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=t1.getText().toString();
                email=t2.getText().toString();
                mobile=t3.getText().toString();

StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();

    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(MainActivity.this,"Error while reading from server",Toast.LENGTH_LONG).show();
    }
})
{
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String,String> Prams=new HashMap<String, String>();
        Prams.put("name",name);
        Prams.put("email",email);
        Prams.put("mobile",mobile);
        return Prams;
    }

};
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

            }

        });

    }
}
