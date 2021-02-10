package org.zrnq.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.mamoe.mirai.message.data.RichMessage;
import org.zrnq.ParsedRichMessage;
import org.zrnq.annotation.RichMessageType;

/**
 * Rich message that contains a map for the specified location.
 * @see LocationMessage2
 * */
@RichMessageType(typeName = "Location", fullName = "RichMessage/JSON/Location", acceptedFeatureValues = "com.tencent.map")
public final class LocationMessage extends JsonMessage{
    @Override
    public ParsedRichMessage parseMessage(RichMessage message) {
        JSONObject json= JSON.parseObject(message.getContent());
        json=json.getJSONObject("meta").getJSONObject("Location.Search");
        return new ParsedRichMessage(json.getString("address"),this.getClass());
    }
}
