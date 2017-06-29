package kamin.com.provectus2017.network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;


public class StrRequest extends StringRequest {
    public final static String TAG = StrRequest.class.getSimpleName();

    public StrRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    public Request<?> setTag(Object tag) {
        return super.setTag(tag);
    }

    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(retryPolicy);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    @Override
    protected String getParamsEncoding() {
        return super.getParamsEncoding();
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        Log.d(TAG,"response statusCode "+response.statusCode);
        return super.parseNetworkResponse(response);
    }
}
