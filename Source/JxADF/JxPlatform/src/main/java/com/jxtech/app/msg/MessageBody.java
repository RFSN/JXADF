package com.jxtech.app.msg;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.jxtech.util.StrUtil;

/**
 * 消息体
 * 
 * @author wmzsoft@gmail.com
 * @date 2014.12
 * 
 */
public class MessageBody implements java.io.Serializable {
    private static final long serialVersionUID = -6053424969121831045L;
    public static final long EMAIL = 1; // 邮件
    public static final long SMS = 2; // 短信
    public static final long NOTE = 4;// 公告
    public static final long WEBCHAT = 8;// 微信
    public static final long ALL = 0xFFFF;
    private String sender;// 发送者
    private String reciver;// 接收者，如果是邮件的话，直接为邮件地址
    private String cc;// 抄送者
    private String bcc;// 密送者
    private String subject;// 主题
    private String content;// 内容
    private Date sendTime;// 发送时间
    private Date endTime;// 过期时间
    private Date createTime;// 创建时间
    private long messageType;// 消息类型
    private List<String> files = new ArrayList<String>();// 附件文件集合
    // 图片集合 邮件中的标识<img src='cid:A+图片路径的Hashcode'>
    private List<String> images = new ArrayList<String>();
    private boolean imageAutoDisplay = false;// 图片自动显示

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMessageType() {
        return messageType;
    }

    public void setMessageType(long messageType) {
        this.messageType = messageType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sender=").append(sender);
        sb.append("\r\nreciver=").append(reciver);
        sb.append("\r\ncc=").append(cc);
        sb.append("\r\nbcc=").append(bcc);
        sb.append("\r\nSubject=").append(subject);
        sb.append("\r\ncontent=").append(content);
        sb.append("\r\nsendTime=").append(sendTime);
        sb.append("\r\nendTime=").append(endTime);
        sb.append("\r\ncreateTime=").append(createTime);
        sb.append("\r\nmessageType=").append(messageType);
        return sb.toString();
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public void addFile(String filename) {
        if (!StrUtil.isNull(filename)) {
            files.add(filename);
        }
    }

    public String getFileNames() {
        return list2String(files);
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void addImage(String image) {
        if (!StrUtil.isNull(image)) {
            images.add(image);
        }
    }

    public String getImageFiles() {
        return list2String(images);
    }

    public String list2String(List<String> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size <= 0) {
            return null;
        }
        StringBuilder fns = new StringBuilder();
        for (int i = 0; i < size; i++) {
            fns.append(list.get(i).trim());
            if (i < size - 1) {
                fns.append(",");
            }
        }
        return fns.toString();
    }

    public boolean isImageAutoDisplay() {
        return imageAutoDisplay;
    }

    public void setImageAutoDisplay(boolean imageAutoDisplay) {
        this.imageAutoDisplay = imageAutoDisplay;
    }

    public MessageBody cloneMe() {
        MessageBody body = new MessageBody();
        body.setSender(sender);
        body.setReciver(reciver);
        body.setCc(cc);
        body.setBcc(bcc);
        body.setSubject(subject);
        body.setContent(content);
        body.setMessageType(messageType);
        body.setImageAutoDisplay(imageAutoDisplay);
        if (sendTime != null) {
            body.setSendTime(new Date(sendTime.getTime()));
        }
        if (endTime != null) {
            body.setEndTime(new Date(endTime.getTime()));
        }
        if (createTime != null) {
            body.setCreateTime(new Date(createTime.getTime()));
        }
        body.setFiles(cloneList(files));
        body.setImages(cloneList(images));
        return body;
    }

    private List<String> cloneList(List<String> list) {
        if (list == null) {
            return null;
        }
        Iterator<String> iter = list.iterator();
        List<String> nlist = new ArrayList<String>();
        while (iter.hasNext()) {
            nlist.add(iter.next());
        }
        return nlist;
    }
}
