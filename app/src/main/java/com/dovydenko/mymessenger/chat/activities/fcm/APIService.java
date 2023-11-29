package com.dovydenko.mymessenger.chat.activities.fcm;

import com.dovydenko.mymessenger.chat.activities.fcmmodels.MyResponse;
import com.dovydenko.mymessenger.chat.activities.fcmmodels.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization: key=AAAArKpxxy0:APA91bGMLm1urSun3BRVMW6RdWZowgZg8nA7kBQ0-sN3dd-AQTbCafnvOcHahIEcZgH3l6IIZ90us8lbE9fOnSZWsV8-DhGHY8zPHj0LFwWbdcZbVwmGBR86WIinhT6qMBowQGZys1gt"
            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
