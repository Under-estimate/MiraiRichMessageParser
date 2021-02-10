package org.zrnq.data;

import net.mamoe.mirai.message.data.RichMessage;
import org.w3c.dom.Element;
import org.zrnq.ParsedRichMessage;
import org.zrnq.annotation.RichMessageType;

/**
 * Rich message that contains an audio link.
 * */
@RichMessageType(typeName = "Audio", fullName = "RichMessage/XML/Audio", acceptedFeatureValues = "2")
public final class AudioMessage extends XmlMessage{
    @Override
    public ParsedRichMessage parseMessage(RichMessage message) {
        Element root=parseDocument(message.getContent());
        ParsedRichMessage prm=new ParsedRichMessage(root.getElementsByTagName("summary").item(0).getTextContent(),this.getClass());
        prm.addLink(root.getAttribute("url"),root.getElementsByTagName("title").item(0).getTextContent());
        return prm;
    }
}